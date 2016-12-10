package com.ylx.UI;

import com.ylx.Analyse.PersonBean;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ylx on 16/12/7.
 */
public class NameAddPanel extends JPanel {

    private NameInputPanel[] nameInputPanels = null;

    NameAddPanel(){
        nameInputPanels = new NameInputPanel[5];
        for (int i = 0;i < nameInputPanels.length;i++){
            nameInputPanels[i] = new NameInputPanel((i == 0));
        }
        init();
    }

    PersonBean getPersonBean(){
        PersonBean personBean = new PersonBean();
        String name = "";
        ArrayList<String> list = new ArrayList<>(4);
        for (int i = 0; i < nameInputPanels.length; i++) {
            String str = nameInputPanels[i].getInput();
            if (i == 0 && !str.equals("")){
                name = str;
            } else if (!str.equals("")) {
                list.add(str);
            }
        }
        String[] alias = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            alias[i] = list.get(i);
        }
        personBean.setAlias(alias);
        personBean.setName(name);
        return personBean;
    }

    private void init(){
        this.setLayout(new FlowLayout());
        this.setBorder(new BevelBorder(BevelBorder.RAISED));
        this.setPreferredSize(new Dimension(580,50));
        for (NameInputPanel nameInputPanel : nameInputPanels){
            this.add(nameInputPanel);
        }
    }

}
