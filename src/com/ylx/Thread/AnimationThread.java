package com.ylx.Thread;

import com.ylx.Analyse.AnalyseResult;
import com.ylx.Analyse.ResultSort;
import com.ylx.Main;
import com.ylx.UI.ResultFrame;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ylx on 16/12/11.
 */
public class AnimationThread extends Thread {

    public static final byte TIMES = 0,SPAN = 1,RELATION = 2;

    private String[] TimesSort = null,SpanSort =null,RelationSort = null;
    private int TimeMax = 0,SpanMax = 0,RelationMax = 0;
    private volatile boolean finish = false;
    private AnalyseResult result = null;
    private byte animationType = -1;
    private ResultFrame resultFrame = null;
    private String person = null;
    private NumberFormat numberFormat = NumberFormat.getNumberInstance();

    private static AnimationThread animationThread = new AnimationThread();

    private AnimationThread(){ start(); }

    public static AnimationThread getAnimationThread() {
        return animationThread;
    }

    public void startAnimation(byte animationType){
        if (result != null) {
            if (this.animationType == -1) {
                init();
                resultFrame = new ResultFrame(TimesSort,TimeMax,SpanSort,SpanMax,result,RelationMax);
            }
            this.animationType = animationType;
            finish = true;
        }
    }

    public void startAnimation(String person){
        this.person = person;
        this.RelationSort = ResultSort.getRelations(person,result.getRelationMap());
        animationType = RELATION;
        finish = true;
    }

    private void init(){
        numberFormat.setMaximumFractionDigits(2);
        TimesSort = ResultSort.getSortNames(result.getTimesMap());
        TimeMax = result.getTimesMap().get(TimesSort[0]);
        SpanSort = ResultSort.getSortNames(result.getSpanMap());
        SpanMax = result.getSpanMap().get(SpanSort[0]);
        RelationMax = (int)(ResultSort.getMaxValue(result.getRelationMap().values()) + 1);
    }

    void setResult(AnalyseResult result) {
        this.result = result;
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
                           for (String name : RelationSort){
                               HashMap<Set<String>,Double> maps = result.getRelationMap();
                               for (Map.Entry<Set<String>,Double> entry : maps.entrySet()){
                                   if (entry.getKey().contains(person) && entry.getKey().contains(name)){
                                       resultFrame.getRelationPanel().setAnimation(name,((Double.valueOf(numberFormat.format(entry.getValue()))/20)*i));
                                       break;
                                   }
                               }
                           }
                       }else{

                           for (String name : RelationSort){
                               HashMap<Set<String>,Double> maps = result.getRelationMap();
                               for (Map.Entry<Set<String>,Double> entry : maps.entrySet()){
                                   if (entry.getKey().contains(person) && entry.getKey().contains(name)){
                                       resultFrame.getRelationPanel().setAnimation(name,Double.valueOf(numberFormat.format(entry.getValue())));
                                       break;
                                   }
                               }
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
