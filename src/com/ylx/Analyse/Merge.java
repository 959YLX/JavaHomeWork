package com.ylx.Analyse;

import com.ylx.UI.AnalysePanel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by ylx on 16/12/3.
 */
public class Merge {

    private volatile static Merge merge = new Merge();

    private ArrayList<LinkedList<Node>> finalList = null;
    private ConcurrentSkipListMap<Integer, LinkedList<Node>> submitMap = null;
    private AnalysePanel processPanel = null;
    private volatile int MaxLineNumber = 0,totalLineNumber = 0;

    public static volatile boolean FinishMerge = false;

    public void setProcessPanel(AnalysePanel processPanel) {
        this.processPanel = processPanel;
        this.totalLineNumber = processPanel.getTotalLineNumber();
    }

    public static Merge getMerge(){ return merge; }

    private Merge(){
        finalList = new ArrayList<>();
        submitMap = new ConcurrentSkipListMap<>();
    }

    void submit(int lineNumber, LinkedList<Node> textList){
        if (lineNumber > MaxLineNumber)
            MaxLineNumber = lineNumber;
        if (!textList.isEmpty())
            submitMap.put(lineNumber,textList);
        processPanel.setProcess(MaxLineNumber);
        if (lineNumber == totalLineNumber) {
            FinishMerge = true;
        }
    }

    public ConcurrentSkipListMap<Integer, LinkedList<Node>> getSubmitMap() {
        return submitMap;
    }
}
