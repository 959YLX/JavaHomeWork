package com.ylx.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ylx on 16/12/11.
 */
public class AppearPanel extends JPanel {

    private JLabel nameLabel = null,timesLabel = null;
    private JProgressBar appearBar = null;

    AppearPanel(String name, int MaxValue){
        appearBar = new JProgressBar(0,MaxValue*100);
        nameLabel = new JLabel(name);
        timesLabel = new JLabel("0");
        init();
    }

    private void init(){
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(550,40));
        appearBar.setValue(0);
        this.add(nameLabel);
        this.add(appearBar);
        this.add(timesLabel);
    }

    void changeName(String name){ nameLabel.setText(name); }

    void updateProcess(int process){
        appearBar.setValue(process);
        timesLabel.setText(String.valueOf(process));
    }

    void updateProcess(double process){
        appearBar.setValue((int) (process*100));
        timesLabel.setText(String.valueOf(process));
    }

}
