package com.ylx.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ylx on 16/12/10.
 */
class AnalyseProcessBar extends JPanel {

    private JProgressBar progressBar = null;
    private JLabel label = null;
    private float TotalLineNumber = 0;

    AnalyseProcessBar(int TotalLineNumber){
        this.TotalLineNumber = (float)TotalLineNumber;
        progressBar = new JProgressBar(0,100);
        label = new JLabel("共"+(TotalLineNumber+1)+"行,正在分析第1行");
        init();
    }

    private void init(){
        this.setPreferredSize(new Dimension(400,50));
        this.setLayout(new FlowLayout());
        progressBar.setPreferredSize(new Dimension(200,30));
        this.add(progressBar);
        this.add(label);
    }

    void setProgress(int currentLineNumber){
        int process;
        if (currentLineNumber != TotalLineNumber) {
            process = (int) ((currentLineNumber / TotalLineNumber) * 100);
        }else{
            process = 100;
        }
        progressBar.setValue(process);
        label.setText("共"+((int)TotalLineNumber + 1)+"行,正在分析第"+(currentLineNumber + 1)+"行");
    }

}
