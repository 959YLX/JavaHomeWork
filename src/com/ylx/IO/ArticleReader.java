package com.ylx.IO;

import com.ylx.Thread.AnalyseThread;
import com.ylx.Thread.ThreadPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by ylx on 16/12/3.
 */
public class ArticleReader implements Runnable{

    private InputStream inputStream = null;
    private BufferedReader bufferedReader = null;
    private AnalyseThread analyseThread = null;

    public ArticleReader(InputStream inputStream){
        if (inputStream != null){
            this.inputStream = inputStream;
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            analyseThread = AnalyseThread.getAnalyseThread();
        }
    }

    @Override
    public void run() {
        while (true){
            String text = null;
            if (bufferedReader != null){
                try {
                    text = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (text != null){
                analyseThread.addText(text);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
