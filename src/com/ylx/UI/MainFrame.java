package com.ylx.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ylx on 16/12/7.
 */
public class MainFrame extends JFrame{

    private ChoseFilePanel choseFilePanel = null;

    public MainFrame(String title){
        this.setTitle(title);
        init();
    }

    private void init(){
        this.setSize(400,500);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        choseFilePanel = new ChoseFilePanel();
        choseFilePanel.setPreferredSize(new Dimension(0,55));
        this.add(choseFilePanel,BorderLayout.NORTH);
        this.setVisible(true);
    }



}
