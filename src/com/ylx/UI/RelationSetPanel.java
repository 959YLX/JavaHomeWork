package com.ylx.UI;

import javax.swing.*;
import java.awt.*;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by ylx on 16/12/26.
 */
class RelationSetPanel extends JPanel {

    private JLabel close = null,unclose = null;

    RelationSetPanel(){
        init();
    }

    private void init(){
        close = new JLabel();
        unclose = new JLabel();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(380,50));
        this.add(close,BorderLayout.NORTH);
        this.add(unclose,BorderLayout.SOUTH);
    }

    void setResult(String closeRelation, double closeValue, String uncloseRelation, double uncloseValue){
        close.setText(closeRelation+"关系最好,指数为:"+closeValue);
        close.setHorizontalTextPosition(SwingConstants.CENTER);
        unclose.setText(uncloseRelation+"关系最弱,指数为:"+uncloseValue);
        unclose.setHorizontalTextPosition(SwingConstants.CENTER);
        this.repaint();
    }

}
