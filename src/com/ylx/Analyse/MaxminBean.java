package com.ylx.Analyse;

/**
 * Created by ylx on 16/12/11.
 */
public class MaxminBean {

    private int MaxLine = 0,MinLine = 0;

    void setMax(int Line){
        MaxLine = Line;
    }

    void setMin(int Line){
        MinLine = Line;
    }

    int getMaxLine() {
        return MaxLine;
    }

    int getMinLine() {
        return MinLine;
    }

}
