package com.ylx.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ylx on 16/12/11.
 */
class AppearPanel extends JPanel {

    private JLabel nameLabel = null,timesLabel = null;
    private JProgressBar appearBar = null;

    AppearPanel(String name, int MaxValue){
        appearBar = new JProgressBar(0,MaxValue);
        nameLabel = new JLabel(name);
        timesLabel = new JLabel("0");
        init();
    }

    AppearPanel(String name, int MaxValue,int height){
        appearBar = new JProgressBar(0,MaxValue);
        nameLabel = new JLabel(name);
        timesLabel = new JLabel("0");
        init(height);
    }

    private void init(){
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(550,40));
        appearBar.setValue(0);
        this.add(nameLabel);
        this.add(appearBar);
        this.add(timesLabel);
    }

    private void init(int height){
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(550,height));
        appearBar.setValue(0);
        this.add(nameLabel);
        this.add(appearBar);
        this.add(timesLabel);
    }

    void updateProcess(int process){
        appearBar.setValue(process);
        timesLabel.setText(String.valueOf(process));
    }

}
