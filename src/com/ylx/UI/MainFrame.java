package com.ylx.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ylx on 16/12/7.
 */
public class MainFrame extends JFrame{

    private ChoseFilePanel choseFilePanel = null;
    private NamePanel namePanel = null;
    private Listener listener = null;

    public MainFrame(String title){
        this.setTitle(title);
        listener = new Listener();
        init();
    }

    private void init(){
        this.setSize(600,500);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        choseFilePanel = new ChoseFilePanel(listener);
        choseFilePanel.setPreferredSize(new Dimension(0,55));
        namePanel = new NamePanel(listener);
        JScrollPane jScrollPane = new JScrollPane(namePanel);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(jScrollPane,BorderLayout.CENTER);
        this.add(choseFilePanel,BorderLayout.NORTH);
        this.add(new AnalysePanel(listener),BorderLayout.SOUTH);
        this.setVisible(true);
    }



}
