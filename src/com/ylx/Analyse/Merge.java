package com.ylx.Analyse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ylx on 16/12/3.
 */
public class Merge {

    private static Merge merge = new Merge();
    private ArrayList<LinkedList<Node>> finalList = null;
    private ConcurrentHashMap<Integer,LinkedList<Node>> submitMap = null;

    public static Merge getMerge(){ return merge; }

    private Merge(){
        finalList = new ArrayList<>();
        submitMap = new ConcurrentHashMap<>();
    }

    public void submit(int lineNumber,LinkedList<Node> textList){
        if (!textList.isEmpty())
            submitMap.put(lineNumber,textList);
    }

    public ConcurrentHashMap<Integer, LinkedList<Node>> getSubmitMap() {
        return submitMap;
    }
}
