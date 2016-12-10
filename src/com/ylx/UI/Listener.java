package com.ylx.UI;

import com.ylx.Analyse.PersonBean;
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
    private NamePanel namePanel = null;

    public Listener(){}

    public void setChoseFilePanel(ChoseFilePanel choseFilePanel) {
        this.choseFilePanel = choseFilePanel;
    }

    public void setNamePanel(NamePanel namePanel) {
        this.namePanel = namePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String ButtonName = e.getActionCommand();
        switch (ButtonName){
            case "打开":{
                File file = new FileManage(choseFilePanel).getOpenFile();
                if (file != null){
                    choseFilePanel.repaint(file.getPath());
                }
                break;
            }
            case "添加新人":{
                namePanel.addName();
                break;
            }
            case "开始分析":{
                PersonBean[] personsInfo = namePanel.getPersonNameInfo();
                String FilePath = choseFilePanel.getFilePath();
                break;
            }
        }
    }
}
