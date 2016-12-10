package com.ylx.UI;

import com.ylx.Analyse.PersonBean;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ylx on 16/12/7.
 */
public class NamePanel extends JPanel{

    private ArrayList<NameAddPanel> nameList = null;
    private JButton AddButton = null;
    private Listener listener = null;

    NamePanel(Listener listener){
        this.listener = listener;
        AddButton = new JButton("添加新人");
        nameList = new ArrayList<>(10);
        init();
    }

    private void init(){
        listener.setNamePanel(this);
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(590,30));
        AddButton.setPreferredSize(new Dimension(300,30));
        AddButton.addActionListener(listener);
        this.add(AddButton);
    }

    void addName(){
        int height = 30;
        this.removeAll();
        nameList.add(new NameAddPanel());
        for (NameAddPanel nameAddPanel : nameList){
            height += 56;
            this.add(nameAddPanel);
        }
        this.add(AddButton);
        this.setPreferredSize(new Dimension(590,height));
        this.updateUI();
        this.validate();
        this.repaint();
    }

    public PersonBean[] getPersonNameInfo(){
        PersonBean[] personBeans = new PersonBean[nameList.size()];
        for (int i = 0; i < nameList.size(); i++) {
            personBeans[i] = nameList.get(i).getPersonBean();
        }
        return personBeans;
    }

}
