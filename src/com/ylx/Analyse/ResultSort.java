package com.ylx.Analyse;

import java.util.*;

/**
 * Created by ylx on 16/12/12.
 */
public class ResultSort {

    public static String[] getSortNames(HashMap<String,Integer> map){
        String[] names = new String[map.size()];
        ArrayList<Map.Entry<String, Integer>> arrayList = new ArrayList<>(map.entrySet());
        arrayList.sort((Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) -> o1.getValue() > o2.getValue() ? -1 : 1);
        for (int i = 0; i < arrayList.size(); i++) {
            names[i] = arrayList.get(i).getKey();
        }
        return names;
    }

    public static double getMaxValue(Collection<Double> collection){
        Object[] objects = collection.toArray();
        Arrays.sort(objects);
        return (double) objects[objects.length - 1];
    }

    public static String[] getRelations(String name,HashMap<Set<String>,Double> maps){
        Map<String,Double> tempMap = new HashMap<>();
        for (Map.Entry<Set<String>,Double> map : maps.entrySet()){
            if (map.getKey().contains(name)){
                map.getKey().forEach( s -> {
                    if (!name.equals(s)){
                        tempMap.put(s,map.getValue());
                    }
                });
            }
        }
        String[] relations = new String[tempMap.size()];
        ArrayList<Map.Entry<String, Double>> arrayList = new ArrayList<>(tempMap.entrySet());
        arrayList.sort((Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) -> o1.getValue() > o2.getValue() ? -1 : 1);
        for (int i = 0; i < relations.length; i++) {
            relations[i] = arrayList.get(i).getKey();
        }
        return relations;
    }

}
