package com.ylx.IO;

import com.ylx.Analyse.SubmitAnalyse;
import com.ylx.Thread.AnalyseThread;

import java.io.*;

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
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            analyseThread = AnalyseThread.getAnalyseThread();
        }
    }

    @Override
    public void run() {
        int LineNumber = 0;
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
                analyseThread.addText(new SubmitAnalyse(text,LineNumber));
                LineNumber++;
            }else{
                break;
            }
        }
    }
}
