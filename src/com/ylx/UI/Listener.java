package com.ylx.UI;

import com.ylx.Analyse.AnalyseTask;
import com.ylx.Analyse.PersonBean;
import com.ylx.IO.ArticleReader;
import com.ylx.Thread.BridgeThread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by ylx on 16/12/7.
 */
public class Listener implements ActionListener {
    private ChoseFilePanel choseFilePanel = null;
    private NamePanel namePanel = null;
    private AnalysePanel analysePanel = null;

    Listener(){}

    void setChoseFilePanel(ChoseFilePanel choseFilePanel) {
        this.choseFilePanel = choseFilePanel;
    }

    void setNamePanel(NamePanel namePanel) {
        this.namePanel = namePanel;
    }

    void setAnalysePanel(AnalysePanel analysePanel){ this.analysePanel = analysePanel; }

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
                try {
                    PersonBean[] personsInfo = namePanel.getPersonNameInfo();
                    String FilePath = choseFilePanel.getFilePath();
                    int LineNumber = ArticleReader.getFileLineNumber(FilePath);
                    analysePanel.changeToProcess(LineNumber);
                    AnalyseTask analyseTask = new AnalyseTask();
                    analyseTask.setFilePath(FilePath);
                    analyseTask.setPersonsInfo(personsInfo);
                    analyseTask.setProcessPanel(analysePanel);
                    BridgeThread.getBridgeThread().addAnalyseTask(analyseTask);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            }
        }
    }
}
