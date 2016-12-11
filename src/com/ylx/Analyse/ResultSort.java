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

}
