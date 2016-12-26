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

    public static String[] getSortSearchNames(HashMap<Set<String>, Double> map,String searchName){
        HashMap<Set<String>, Double> temp = new HashMap<>();
        for (Map.Entry<Set<String>, Double> entry : map.entrySet()){
            if (entry.getKey().contains(searchName)){
                temp.put(entry.getKey(),entry.getValue());
            }
        }
        String[] names = new String[temp.size()];
        ArrayList<Map.Entry<Set<String>, Double>> arrayList = new ArrayList<>(temp.entrySet());
        arrayList.sort((Map.Entry<Set<String>, Double> o1,Map.Entry<Set<String>, Double> o2) -> o1.getValue() > o2.getValue() ? -1 : 1);
        for (int i = 0;i < arrayList.size();i++){
            for (String s : arrayList.get(i).getKey()){
                if (!s.equals(searchName)){
                    names[i] = s;
                }
            }
        }
        return names;
    }

}
