package com.ylx.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ylx on 16/12/7.
 */
public class NameInputPanel extends JPanel {
    private JLabel label = null;
    private JTextField textField = null;

    public NameInputPanel(boolean isRealName){
        if (isRealName){
            label = new JLabel("姓名:");
        }else{
            label = new JLabel("别名:");
        }
        textField = new JTextField();
        init();
    }

    private void init(){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(110,30));
        textField.setPreferredSize(new Dimension(65,30));
        this.add(label,BorderLayout.WEST);
        this.add(textField,BorderLayout.EAST);
    }

    String getInput(){ return textField.getText(); }

}
