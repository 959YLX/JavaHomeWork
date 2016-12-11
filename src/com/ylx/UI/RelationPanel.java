package com.ylx.UI;

import com.ylx.Analyse.AnalyseResult;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ylx on 16/12/11.
 */
public class RelationPanel extends JPanel {

    private RelationSetPanel relationSetPanel = null;
    private RelationSearchPanel relationSearchPanel = null;
    private Listener listener = null;

    public RelationPanel(AnalyseResult result,String[] names,int Max,Listener listener){
        relationSetPanel = new RelationSetPanel(result);
        relationSearchPanel = new RelationSearchPanel(names,Max,listener);
        this.listener = listener;
        init();
    }

    public RelationSearchPanel getRelationSearchPanel() {
        return relationSearchPanel;
    }

    private void init(){
        this.setLayout(new BorderLayout());
        this.add(relationSetPanel,BorderLayout.NORTH);
        this.add(relationSearchPanel,BorderLayout.SOUTH);
    }

    public void setAnimation(String name,double process){
        relationSearchPanel.setProcess(name,process);
    }

}
