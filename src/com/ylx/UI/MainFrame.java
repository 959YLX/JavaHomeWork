package com.ylx.UI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ylx on 16/12/7.
 */
public class MainFrame extends JFrame implements ActionListener{
    private JButton jButton = null;
    private JFileChooser jFileChooser = null;

    public MainFrame(String title){
        this.setTitle(title);
        init();
    }

    private void init(){
        this.setSize(600,500);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jButton = new JButton("OpenFile");
        jFileChooser = new JFileChooser(System.getProperty("user.dir"));
        jFileChooser.setDialogTitle("选择小说");
        jFileChooser.setFileFilter(new FileNameExtensionFilter("文本文件","txt"));
        jButton.setSize(30,15);
        jButton.addActionListener(this);
        this.add(jButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jFileChooser.showOpenDialog(this);
        System.out.println(jFileChooser.getSelectedFile());
    }
}
