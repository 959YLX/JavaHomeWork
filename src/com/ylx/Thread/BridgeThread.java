package com.ylx.Thread;

import com.ylx.Analyse.AnalyseTask;
import com.ylx.Analyse.Merge;
import com.ylx.Analyse.Node;
import com.ylx.Analyse.PersonBean;
import com.ylx.IO.ArticleReader;
import com.ylx.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ylx on 16/12/10.
 */
public class BridgeThread extends Thread {
    private static BridgeThread bridgeThread = new BridgeThread();
    private AnalyseTask task = null;

    private BridgeThread(){ start(); }

    public static BridgeThread getBridgeThread(){ return bridgeThread; }

    public void addAnalyseTask(AnalyseTask task){
        this.task = task;
        try {
            InputStream inputStream = new FileInputStream(task.getFilePath());
            PersonBean[] personBeans = task.getPersonsInfo();
            ArrayList<String> list = new ArrayList<>(15);
            for (PersonBean personBean : personBeans){
                list.add(personBean.getName());
                String[] alias = personBean.getAlias();
                Collections.addAll(list, alias);
            }
            String[] names = new String[list.size()];
            for (int i = 0; i < names.length; i++) {
                names[i] = list.get(i);
            }
            Merge.getMerge().setProcessPanel(task.getProcessPanel());
            AnalyseThread.getAnalyseThread().setName(names);
            new Thread(new ArticleReader(inputStream)).start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.setName("Bridge");
        while (!Main.STOP){
            try {
                sleep(500);
                if (Merge.FinishMerge){
                    ConcurrentHashMap<Integer,LinkedList<Node>> listHashMap = Merge.getMerge().getSubmitMap();
                    System.out.println(Main.getMapInfo(listHashMap));
                    Merge.FinishMerge = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
