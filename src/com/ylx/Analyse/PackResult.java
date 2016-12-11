package com.ylx.Analyse;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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

}
