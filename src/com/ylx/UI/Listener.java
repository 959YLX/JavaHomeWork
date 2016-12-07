package com.ylx.UI;

import com.ylx.IO.FileManage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by ylx on 16/12/7.
 */
public class Listener implements ActionListener {
    private ChoseFilePanel choseFilePanel = null;

    public Listener(ChoseFilePanel choseFilePanel){
        this.choseFilePanel = choseFilePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String ButtonName = e.getActionCommand();
        System.out.println(ButtonName);
        switch (ButtonName){
            case "打开":{
                File file = new FileManage(choseFilePanel).getOpenFile();
                if (file != null){
                    choseFilePanel.repaint(file.getPath());
                }
            }
        }
    }
}
