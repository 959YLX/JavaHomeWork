package com.ylx.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ylx on 16/12/11.
 */
public class RelationPanel extends JPanel {

    private RelationSetPanel relationSetPanel = null;
    private RelationSearchPanel relationSearchPanel = null;

    RelationPanel(Listener listener){
        relationSearchPanel = new RelationSearchPanel(listener);
        listener.setRelationPanel(this);
        relationSetPanel = new RelationSetPanel();
        init();
    }

    private void init(){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(420,520));
        this.add(relationSetPanel,BorderLayout.NORTH);
        this.add(relationSearchPanel,BorderLayout.SOUTH);
    }

    void setRelationSet(String closeRelation, double closeValue, String uncloseRelation, double uncloseValue){
        relationSetPanel.setResult(closeRelation,closeValue,uncloseRelation,uncloseValue);
        this.repaint();
    }

    String getText(){
        return relationSearchPanel.getText();
    }

    void setSortPanel(String[] names){
        relationSearchPanel.setSortPanel(names);
        this.repaint();
    }

    public void setAnimation(String name,int value){
        relationSearchPanel.setAnimation(name,value);
    }

}
