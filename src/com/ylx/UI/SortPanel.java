package com.ylx.UI;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

/**
 * Created by ylx on 16/12/11.
 */
public class SortPanel extends JPanel{

    private AppearPanel[] appearPanels = null;
    private HashMap<String,Integer> maps = null;
    private int height = 0;

    SortPanel(String[] names, int MaxValue){
        appearPanels = new AppearPanel[names.length];
        maps = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            appearPanels[i] = new AppearPanel(names[i],MaxValue);
            maps.put(names[i],i);
            height += 45;
        }
        init();
    }

    SortPanel(String[] names, int MaxValue, int weight){
        appearPanels = new AppearPanel[names.length];
        maps = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            appearPanels[i] = new AppearPanel(names[i],MaxValue,35);
            maps.put(names[i],i);
            height += 40;
        }
        init(weight);
    }

    private void init(){
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(400,height));
        for (AppearPanel appearPanel : appearPanels){
            this.add(appearPanel);
        }
    }

    private void init(int weight){
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(weight,height));
        for (AppearPanel appearPanel : appearPanels){
            this.add(appearPanel);
        }
    }

    public void setAnimation(String name,int process){
        appearPanels[maps.get(name)].updateProcess(process);
    }

}
