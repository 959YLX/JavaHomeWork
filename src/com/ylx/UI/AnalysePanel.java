package com.ylx.UI;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by ylx on 16/12/10.
 */
public class AnalysePanel extends JPanel {

    private JButton analyse = null;
    private AnalyseProcessBar process = null;
    private int totalLineNumber = -1;

    AnalysePanel(Listener listener){
        listener.setAnalysePanel(this);
        this.setPreferredSize(new Dimension(0,50));
        analyse = new JButton("开始分析");
        analyse.addActionListener(listener);
        this.add(analyse);
    }

    public int getTotalLineNumber(){ return totalLineNumber; }

    void changeToProcess(int totalLineNumber){
        this.totalLineNumber = totalLineNumber;
        process = new AnalyseProcessBar(totalLineNumber);
        this.removeAll();
        this.add(process);
        this.validate();
        this.repaint();
    }

    public void setProcess(int currentLineNumber){ process.setProgress(currentLineNumber); }

}
