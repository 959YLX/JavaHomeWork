package com.ylx.UI;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

/**
 * Created by ylx on 16/12/7.
 */
class ChoseFilePanel extends JPanel{
    private JLabel PathLabel = null;

    ChoseFilePanel(Listener listener){
        listener.setChoseFilePanel(this);
        FlowLayout flowLayout = new FlowLayout();
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        left.setLayout(flowLayout);
        right.setLayout(flowLayout);
        PathLabel = new JLabel("/User/ylx/Desktop");
        PathLabel.setPreferredSize(new Dimension(250,40));
        PathLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        PathLabel.setVerticalTextPosition(SwingConstants.CENTER);
        left.add(PathLabel);
        JButton choseButton = new JButton("打开");
        choseButton.addActionListener(listener);
        choseButton.setPreferredSize(new Dimension(50,30));
        right.add(choseButton);
        this.setPreferredSize(new Dimension(0,50));
        this.setLayout(new BorderLayout());
        this.add(left,BorderLayout.WEST);
        this.add(right,BorderLayout.EAST);
    }

    String getFilePath(){
        return PathLabel.getText();
    }

    void repaint(String Path) {
        PathLabel.setText(Path);
        super.repaint();
    }
}
