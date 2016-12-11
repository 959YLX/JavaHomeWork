package com.ylx.Analyse;

import java.util.*;

/**
 * Created by ylx on 16/12/11.
 */
public class PackResult {

    private PersonBean[] persons = null;
    private Map<String,String> aliasMaps = null;

    public PackResult(PersonBean[] persons){
        aliasMaps = new HashMap<>();
        for (PersonBean person : persons){
            String name = person.getName();
            String[] alias = person.getAlias();
            aliasMaps.put(name,name);
            for (String str : alias){
                aliasMaps.put(str,name);
            }
        }
    }

    public AnalyseResult getResult(Map<Integer,LinkedList<Node>> resultMap){
        AnalyseResult result = new AnalyseResult();
        result.setTimesMap(getPersonTimes(resultMap));
        result.setSpanMap(getPersonSpan(resultMap));
        return result;
    }

    private HashMap<String,Integer> getPersonSpan(Map<Integer,LinkedList<Node>> resultMap){
        HashMap<String,Integer> spanMap = new HashMap<>();
        HashMap<String,MaxminBean> tempMap = new HashMap<>();
        LinkedList<Node> tempList;
        for (Map.Entry<Integer,LinkedList<Node>> entry : resultMap.entrySet()){
            int LineNumber = entry.getKey();
            tempList = entry.getValue();
            for (Node node : tempList){
                String realName = aliasMaps.get(node.getName());
                if (realName != null){
                    if (tempMap.containsKey(realName)){
                        MaxminBean maxminBean = tempMap.get(realName);
                        if (maxminBean.getMaxLine() < LineNumber){
                            //最大
                            maxminBean.setMax(LineNumber);
                        }else if (maxminBean.getMinLine() > LineNumber){
                            //最小
                            maxminBean.setMin(LineNumber);
                        }
                    }else{
                        MaxminBean maxminBean = new MaxminBean();
                        maxminBean.setMax(LineNumber);
                        maxminBean.setMin(LineNumber);
                        tempMap.put(realName,maxminBean);
                    }
                }
            }
        }
        for (Map.Entry<String,MaxminBean> entry : tempMap.entrySet()){
            spanMap.put(entry.getKey(),(entry.getValue().getMaxLine()-entry.getValue().getMinLine()));
        }
        return spanMap;
    }

    private HashMap<String,Integer> getPersonTimes(Map<Integer,LinkedList<Node>> resultMap){
        HashMap<String,Integer> times = new HashMap<>();
        LinkedList<Node> tempList;
        for (Map.Entry<Integer,LinkedList<Node>> entry : resultMap.entrySet()){
            tempList = entry.getValue();
            for (Node node : tempList){
                String realName = aliasMaps.get(node.getName());
                if (realName != null){
                    if (times.containsKey(realName)){
                        times.put(realName,times.get(realName)+1);
                    }else{
                        times.put(realName,1);
                    }

                }
            }

        }
        return times;
    }

    private HashMap<Set<String>, Double> getRelation(Map<Integer,LinkedList<Node>> resultMap){
        ArrayList<RelationBean> relationList = new ArrayList<>(45);
        HashMap<String,Integer[]> newestLocation = new HashMap<>();
        String last = "";
        for (PersonBean personBean : persons){
            newestLocation.put(personBean.getName(),new Integer[]{-1,-1});
        }

        for (int i = 0; i < persons.length; i++) {
            for (int j = i+1; j < persons.length; j++) {
                RelationBean relationBean = new RelationBean();
                relationBean.setRelationSet(persons[i].getName(),persons[j].getName());
                relationList.add(relationBean);
            }
        }

        for (Map.Entry<Integer,LinkedList<Node>> entry : resultMap.entrySet()){

            int LineNumber = entry.getKey();
            LinkedList<Node> list = entry.getValue();
            for (Node node : list){
                String realName = aliasMaps.get(node.getName());
                if (!realName.equals(last) && !last.equals("")){

                    for (RelationBean relationBean:relationList){
                        if (relationBean.isRelation(realName,last)){
                            //记录权值
                        }
                    }

                    last = realName;
                }else{
                    newestLocation.put(realName,new Integer[]{LineNumber,node.getLocation()});
                    last = realName;
                }
            }

        }

    return null;

    }

}
