package com.ylx.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ylx on 16/12/26.
 */
class RelationSearchPanel extends JPanel {

    private JTextField searchField = null;
    private SortPanel sortPanel = null;

    RelationSearchPanel(Listener listener){
        JLabel searchLabel = new JLabel("姓名");
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(250,20));
        JButton searchButton = new JButton("查找");
        searchButton.setPreferredSize(new Dimension(75,20));
        searchButton.addActionListener(listener);
        this.setPreferredSize(new Dimension(380,400));
        this.setLayout(new FlowLayout());
        this.add(searchLabel);
        this.add(searchField);
        this.add(searchButton);
        this.setVisible(true);
    }

    void setSortPanel(String[] names){
        if (sortPanel != null){
            this.remove(sortPanel);
        }
        sortPanel = new SortPanel(names,3000,360);
        this.add(sortPanel);
        this.validate();
        this.repaint();
    }

    String getText(){
        return searchField.getText();
    }

    void setAnimation(String name, int value){
        sortPanel.setAnimation(name,value);
    }

}
