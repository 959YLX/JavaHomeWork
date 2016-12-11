package com.ylx.UI;

import com.ylx.Analyse.AnalyseResult;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by ylx on 16/12/12.
 */
public class RelationSetPanel extends JPanel {

    private JLabel closeLabel = null,unclosedLabel = null;
    private ArrayList<String> closeName = null,unclosedName = null;

    public RelationSetPanel(AnalyseResult result){
        closeName = new ArrayList<>(2);
        unclosedName = new ArrayList<>(2);
        result.getCloseRelation().forEach(s -> closeName.add(s));
        result.getUnclosedRelation().forEach(s -> unclosedName.add(s));
        init();
    }

    private void init(){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(400,50));
        closeLabel = new JLabel(closeName.get(0)+"与"+closeName.get(1)+"关系紧密");
        unclosedLabel = new JLabel(unclosedName.get(0)+"与"+unclosedName.get(1)+"关系疏远");
        this.add(closeLabel,BorderLayout.WEST);
        this.add(unclosedLabel,BorderLayout.EAST);
    }

}
