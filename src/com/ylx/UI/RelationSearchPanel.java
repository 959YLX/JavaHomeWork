package com.ylx.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ylx on 16/12/12.
 */
public class RelationSearchPanel extends JPanel {

    private JLabel name = null;
    private JTextField textField = null;
    private JButton button = null;
    private SortPanel resultPanel = null;
    private Listener listener;

    public RelationSearchPanel(String[] names,int Max,Listener listener) {
        resultPanel = new SortPanel(names,Max);
        this.listener = listener;
        init();
    }

    private void init(){
        name = new JLabel("姓名");
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200,20));
        button = new JButton("查找");
        button.setPreferredSize(new Dimension(50,20));
        button.addActionListener(listener);
        this.setLayout(new FlowLayout());
        this.add(name);
        this.add(textField);
        this.add(button);
        this.add(resultPanel);
    }

    public String getText(){ return textField.getText(); }

    public void changeNames(String[] names){
        resultPanel.changeNames(names);
    }

    public void setProcess(String Name,double process){
        resultPanel.setAnimation(Name,process);
    }

}
