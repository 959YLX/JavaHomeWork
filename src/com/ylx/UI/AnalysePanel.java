package com.ylx.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ylx on 16/12/10.
 */
public class AnalysePanel extends JPanel {

    private JButton analyse = null;

    AnalysePanel(Listener listener){
        this.setPreferredSize(new Dimension(0,50));
        analyse = new JButton("开始分析");
        analyse.addActionListener(listener);
        this.add(analyse);
    }

}
