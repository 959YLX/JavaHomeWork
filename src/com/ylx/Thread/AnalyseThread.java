package com.ylx.Thread;

import com.ylx.Analyse.SubmitAnalyse;
import com.ylx.Analyse.TextAnalyse;
import com.ylx.IO.ArticleReader;
import com.ylx.Main;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by ylx on 16/12/3.
 */
public class AnalyseThread extends Thread {

    private ConcurrentLinkedQueue<SubmitAnalyse> TextQueue = null;
    private ThreadPool threadPool = null;
    private String[] name = null;

    private static AnalyseThread analyseThread = new AnalyseThread();

    public static AnalyseThread getAnalyseThread(){ return analyseThread; }

    public void setName(String[] name) {
        this.name = name;
    }

    private AnalyseThread(){
        TextQueue = new ConcurrentLinkedQueue<>();
        threadPool = ThreadPool.getThreadPool();
        start();
    }

    public boolean addText(SubmitAnalyse task){
        return TextQueue.add(task);
    }

    @Override
    public void run() {
        while (!Main.STOP){
            if (!TextQueue.isEmpty() && name != null){
                SubmitAnalyse task = TextQueue.poll();
                threadPool.addAnalyseTask(new TextAnalyse(task.getArticle(),name,task.getLineNumber()));
            }
        }
    }
}
