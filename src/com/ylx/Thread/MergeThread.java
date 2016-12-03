package com.ylx.Thread;

import com.ylx.Analyse.Node;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ylx on 16/12/3.
 */
public class MergeThread extends Thread {

    private static MergeThread mergeThread = new MergeThread();
    private LinkedList<LinkedList<Node>> finalList = null;
    private ConcurrentHashMap<Integer,LinkedList<Node>> submitMap = null;

    public MergeThread getMergeThread(){ return mergeThread; }

    private MergeThread(){
        finalList = new LinkedList<>();
        submitMap = new ConcurrentHashMap<>();
    }

    public void submit(int lineNumber,LinkedList<Node> textList){
        submitMap.put(lineNumber,textList);
    }

    @Override
    public void run() {
        while (true){
            if (!submitMap.isEmpty()){
                for (Map.Entry<Integer,LinkedList<Node>> entry : submitMap.entrySet()){
                    int num = entry.getKey();

                }
            }
        }
    }
}
