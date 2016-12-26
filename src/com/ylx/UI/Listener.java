package com.ylx.UI;

import com.ylx.Analyse.*;
import com.ylx.IO.ArticleReader;
import com.ylx.Thread.AnimationThread;
import com.ylx.Thread.BridgeThread;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * Created by ylx on 16/12/7.
 */
public class Listener implements ActionListener,ChangeListener {
    private ChoseFilePanel choseFilePanel = null;
    private NamePanel namePanel = null;
    private AnalysePanel analysePanel = null;
    private RelationPanel relationPanel = null;

    Listener(){}

    void setRelationPanel(RelationPanel relationPanel) {
        this.relationPanel = relationPanel;
    }

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
                    BridgeThread.getBridgeThread().setPackResult(new PackResult(personsInfo,LineNumber));
                    BridgeThread.getBridgeThread().addAnalyseTask(analyseTask);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            }
            case "查找":{
                String searchName = relationPanel.getText();
                String[] names = ResultSort.getSortSearchNames(AnimationThread.getAnimationThread().getResult().getRelationMap(),searchName);
                relationPanel.setSortPanel(names);
                AnimationThread animationThread = AnimationThread.getAnimationThread();
                animationThread.setRelationNames(names);
                animationThread.setCurrentSearchName(searchName);
                animationThread.setRelationPanel(relationPanel);
                animationThread.startAnimation(AnimationThread.RELATION);
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int tabs = ((JTabbedPane)e.getSource()).getSelectedIndex();
        switch (tabs){
            case 0:{
                AnimationThread.getAnimationThread().startAnimation(AnimationThread.TIMES);
                break;
            }
            case 1:{
                AnimationThread.getAnimationThread().startAnimation(AnimationThread.SPAN);
                break;
            }
            case 2:{
                AnalyseResult result = AnimationThread.getAnimationThread().getResult();
                relationPanel.setRelationSet(getTextBySet(result.getCloseRelation()),result.getCloseValue(),getTextBySet(result.getUnclosedRelation()),result.getUnclosedValue());
            }
        }
    }


    private String getTextBySet(Set<String> relation){
        String str = "";
        boolean flag = true;
        for (String s : relation){
            if (flag){
                str += s;
                flag = false;
            }else{
                str += ("和"+s);
            }
        }
        return str;
    }

}
