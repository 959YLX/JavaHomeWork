package com.ylx.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ylx on 16/12/11.
 */
public class ResultFrame extends JFrame {

    private JTabbedPane tabbedPane = null;
    private SortPanel timesPanel = null,spanPanel = null;
    private RelationPanel relation = null;


    public ResultFrame(String[] TimesName, int TimesMax,String[] SpanName,int SpanMax){
        tabbedPane = new JTabbedPane();
        timesPanel = new SortPanel(TimesName,TimesMax);
        spanPanel = new SortPanel(SpanName,SpanMax);
        relation = new RelationPanel();
        init();
    }

    public SortPanel getSpanPanel() {
        return spanPanel;
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
        tabbedPane.addChangeListener(new Listener());
        tabbedPane.setPreferredSize(new Dimension(400,500));
        this.add(tabbedPane);
        this.setVisible(true);
    }

}
