package com.ylx.Analyse;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by ylx on 16/12/11.
 */
public class PackResult {

    private PersonBean[] persons = null;
    private Map<String,String> aliasMaps = null;
    private int amountPerson = -1;
    private int TotalLineNumber;

    public PackResult(PersonBean[] persons,int TotalLineNumber){
        this.persons = persons;
        amountPerson = persons.length;
        this.TotalLineNumber = TotalLineNumber;
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

    private String getRealName(String name){
        return aliasMaps.get(name);
    }

    public AnalyseResult getResult(Map<Integer,LinkedList<Node>> resultMap){
        AnalyseResult result = new AnalyseResult();
        result.setTimesMap(getPersonTimes(resultMap));
        result.setSpanMap(getPersonSpan(resultMap));
        RelationBean[][] relationBeans = getRelations(resultMap);
        return result;
    }

    private RelationBean[][] getRelations(Map<Integer,LinkedList<Node>> resultMap){
        RelationBean[][] relation = new RelationBean[amountPerson][amountPerson];
        Map<String,Integer> sort = new HashMap<>();
        Map<String,Integer[]> lastLocationMap = new HashMap<>();
        String lastName = null;
        for (int i = 0; i < amountPerson; i++) {
            sort.put(persons[i].getName(),i);
            for (int j = 0; j < amountPerson; j++) {
                RelationBean relationBean = new RelationBean(persons[i].getName(),persons[j].getName());
                if (j == i){ relationBean.setWeight(0d); }
                relation[i][j] = relationBean;
            }
        }
        for (int LineNumber = 0; LineNumber < TotalLineNumber; LineNumber++) {
            if (resultMap.containsKey(LineNumber)){
                LinkedList<Node> list = resultMap.get(LineNumber);
                for (Node node : list){
                    String name = getRealName(node.getName());
                    if (name.equals(lastName) || lastName == null){
                        lastLocationMap.put(name,new Integer[]{LineNumber,node.getLocation()});
                        lastName = name;
                        continue;
                    }
                    for (Map.Entry<String,Integer[]> lastLocation : lastLocationMap.entrySet()){
                        if (!lastLocation.getKey().equals(name)){
                            int X = sort.get(lastLocation.getKey()),Y = sort.get(name);
                            double weight = calculateRelation(relation[X][Y].getWeight(),LineNumber,node.getLocation(),lastLocation.getValue()[0],lastLocation.getValue()[1]);
                            relation[X][Y].setWeight(weight);
                            relation[Y][X].setWeight(weight);
                        }
                    }
                    lastLocationMap.put(name,new Integer[]{LineNumber,node.getLocation()});
                    lastName = name;
                }
            }
        }
        return relation;
    }

    private double calculateRelation(double baseRelationWeight,int line1,int location1,int line2,int location2){
        int delta = line1 - line2;
        if (delta == 0){
            return (baseRelationWeight *(1 + (1 / (Math.abs(location1 - location2) + 8))));
        }else if (Math.abs(delta) <= 10){
            return baseRelationWeight * (1 + Math.exp((delta > 0 ? -delta : delta) * 0.2 - 6));
        }
        return baseRelationWeight;
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

}
