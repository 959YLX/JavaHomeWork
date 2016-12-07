package com.ylx.UI;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

/**
 * Created by ylx on 16/12/7.
 */
public class ChoseFilePanel extends JPanel{
    private JLabel PathLabel = null;
    private JButton ChoseButton = null;
    private JPanel left = null,right = null;

    public ChoseFilePanel(){
        FlowLayout flowLayout = new FlowLayout();
        left = new JPanel();
        right = new JPanel();
        left.setLayout(flowLayout);
        right.setLayout(flowLayout);
        PathLabel = new JLabel("/User/ylx/Desktop");
        PathLabel.setPreferredSize(new Dimension(250,40));
        PathLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        PathLabel.setVerticalTextPosition(SwingConstants.CENTER);
        left.add(PathLabel);
        ChoseButton = new JButton("打开");
        ChoseButton.addActionListener(new Listener(this));
        ChoseButton.setPreferredSize(new Dimension(50,30));
        right.add(ChoseButton);
        this.setPreferredSize(new Dimension(0,50));
        this.setLayout(new BorderLayout());
        this.add(left,BorderLayout.WEST);
        this.add(right,BorderLayout.EAST);
    }


    public void repaint(String Path) {
        PathLabel.setText(Path);
        super.repaint();
    }
}
