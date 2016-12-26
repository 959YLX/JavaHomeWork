package com.ylx.Thread;

import com.ylx.Analyse.AnalyseResult;
import com.ylx.Analyse.ResultSort;
import com.ylx.Main;
import com.ylx.UI.RelationPanel;
import com.ylx.UI.ResultFrame;

import java.util.Map;
import java.util.Set;

/**
 * Created by ylx on 16/12/11.
 */
public class AnimationThread extends Thread {

    public static byte TIMES = 0,SPAN = 1,RELATION = 2;

    private String[] TimesSort = null,SpanSort =null,relationNames = null;
    private int TimeMax = 0,SpanMax = 0;
    private volatile boolean finish = false;
    private AnalyseResult result = null;
    private byte animationType = -1;
    private ResultFrame resultFrame = null;
    private RelationPanel relationPanel = null;
    private String currentSearchName = null;

    private static AnimationThread animationThread = new AnimationThread();

    private AnimationThread(){ start(); }

    public static AnimationThread getAnimationThread() {
        return animationThread;
    }

    public void startAnimation(byte animationType){
        if (result != null) {
            if (this.animationType == -1) {
                init();
                resultFrame = new ResultFrame(TimesSort,TimeMax,SpanSort,SpanMax);
            }
            this.animationType = animationType;
            finish = true;
        }
    }

    public void setCurrentSearchName(String currentSearchName) {
        this.currentSearchName = currentSearchName;
    }

    private void init(){
        TimesSort = ResultSort.getSortNames(result.getTimesMap());
        TimeMax = result.getTimesMap().get(TimesSort[0]);
        SpanSort = ResultSort.getSortNames(result.getSpanMap());
        SpanMax = result.getSpanMap().get(SpanSort[0]);
    }

    void setResult(AnalyseResult result) {
        this.result = result;
    }

    public void setRelationPanel(RelationPanel relationPanel) {
        this.relationPanel = relationPanel;
    }

    public AnalyseResult getResult() {
        return result;
    }

    public void setRelationNames(String[] relationNames) {
        this.relationNames = relationNames;
    }

    private int getRelationValue(String name1,String name2){
        Map<Set<String>,Double> map = result.getRelationMap();
        for (Map.Entry<Set<String>,Double> entry : map.entrySet()){
            Set<String> relation = entry.getKey();
            if (relation.contains(name1) && relation.contains(name2)){
                return ((int)(entry.getValue()*1000));
            }
        }
        return 0;
    }

    @Override
    public void run() {
        while (!Main.STOP){
            try {
                if (finish){
                    if (animationType == TIMES){
                        for (int i = 0; i < 20; i++) {
                            if (i != 19){
                                for (String name : TimesSort){
                                    resultFrame.getTimesPanel().setAnimation(name,(((result.getTimesMap().get(name))/20)*i));
                                }
                            }else{
                                for (String name : TimesSort){
                                    resultFrame.getTimesPanel().setAnimation(name,result.getTimesMap().get(name));
                                }
                            }
                            sleep(50);
                    }
                }else if (animationType == SPAN){
                    for (int i = 0; i < 20; i++) {
                        if (i != 19){
                            for (String name : SpanSort){
                                resultFrame.getSpanPanel().setAnimation(name,(((result.getSpanMap().get(name))/20)*i));
                            }
                        }else{
                            for (String name : SpanSort){
                                resultFrame.getSpanPanel().setAnimation(name,result.getSpanMap().get(name));
                            }
                        }
                        sleep(50);
                    }
                }else if (animationType == RELATION){
                    for (int i = 0; i < 20; i++) {
                        if (i != 19){
                            for (String name : relationNames){
                                relationPanel.setAnimation(name,(((getRelationValue(name,currentSearchName))/20)*i));
                            }
                        }else{
                            for (String name : relationNames){
                                relationPanel.setAnimation(name,getRelationValue(name,currentSearchName));
                            }
                        }
                        sleep(50);
                    }
                }
                finish = false;
            }
            sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
