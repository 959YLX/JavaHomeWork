package com.ylx.Thread;

import com.ylx.Analyse.TextAnalyse;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ylx on 16/12/3.
 */
public class ThreadPool extends Thread{

    private int maxTaskNumber = 300,corePoolSize = 2,maximumPoolSize = 4;
    private long keepAliveTime = 10;
    private LinkedBlockingQueue<Runnable> TextTaskQueue = null;
    private ThreadPoolExecutor TaskThreadPool = null;

    private static ThreadPool threadPool = new ThreadPool();

    public static ThreadPool getThreadPool(){ return threadPool; }

    private ThreadPool(){ init(); }

    private void init(){
        TextTaskQueue = new LinkedBlockingQueue<>(maxTaskNumber);
        TaskThreadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
                TimeUnit.MINUTES, TextTaskQueue, new ThreadPoolExecutor.CallerRunsPolicy());
        start();
    }

    void close() {
        TaskThreadPool.shutdown();
    }

    void addAnalyseTask(TextAnalyse textAnalyseTask) {
        TaskThreadPool.execute(textAnalyseTask);
    }

}
