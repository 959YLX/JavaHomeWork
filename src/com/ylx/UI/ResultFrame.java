package com.ylx.UI;

import com.ylx.Analyse.AnalyseResult;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ylx on 16/12/11.
 */
public class ResultFrame extends JFrame {

    private JTabbedPane tabbedPane = null;
    private SortPanel timesPanel = null,spanPanel = null;
    private RelationPanel relation = null;
    private Listener listener = null;

    public ResultFrame(String[] TimesName, int TimesMax, String[] SpanName, int SpanMax, AnalyseResult result,int relationMax){
        tabbedPane = new JTabbedPane();
        timesPanel = new SortPanel(TimesName,TimesMax);
        spanPanel = new SortPanel(SpanName,SpanMax);
        relation = new RelationPanel(result,TimesName,relationMax,listener);
        listener = new Listener();
        listener.setResultFrame(this);
        init();
    }

    public SortPanel getSpanPanel() {
        return spanPanel;
    }

    public RelationPanel getRelationPanel() {
        return relation;
    }

    public SortPanel getTimesPanel() {
        return timesPanel;
    }

    private void init(){
        this.setSize(420,520);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        tabbedPane.add("次数",timesPanel);
        tabbedPane.add("篇幅",spanPanel);
        tabbedPane.add("关系",relation);
        tabbedPane.addChangeListener(listener);
        tabbedPane.setPreferredSize(new Dimension(400,600));
        this.add(tabbedPane);
        this.setVisible(true);
    }

}
