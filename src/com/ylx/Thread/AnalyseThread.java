package com.ylx.Thread;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by ylx on 16/12/3.
 */
public class AnalyseThread extends Thread {

    private ConcurrentLinkedQueue<String> TextQueue = null;

    private static AnalyseThread analyseThread = new AnalyseThread();

    public static AnalyseThread getAnalyseThread(){ return analyseThread; }

    private AnalyseThread(){
        TextQueue = new ConcurrentLinkedQueue<>();
        start();
    }

    public boolean addText(String text){
        return TextQueue.add(text);
    }

    @Override
    public void run() {
        while (true){
            if (!TextQueue.isEmpty()){

            }
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
