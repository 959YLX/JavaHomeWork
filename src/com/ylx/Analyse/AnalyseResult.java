package com.ylx.Analyse;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by ylx on 16/12/11.
 */
public class AnalyseResult {

    private HashMap<String,Integer> timesMap = null,spanMap = null;
    private Set<String> closeRelation = null, unclosedRelation = null;
    private HashMap<Set<String>,Double> relationMap = null;
    private double closeValue = 0d,unclosedValue = 0d;

    void setCloseValue(double closeValue) {
        this.closeValue = closeValue;
    }

    void setUnclosedValue(double unclosedValue) {
        this.unclosedValue = unclosedValue;
    }

    void setCloseRelation(Set<String> closeRelation) {
        this.closeRelation = closeRelation;
    }

    void setRelationMap(HashMap<Set<String>, Double> relationMap) {
        this.relationMap = relationMap;
    }

    void setSpanMap(HashMap<String, Integer> spanMap) {
        this.spanMap = spanMap;
    }

    void setTimesMap(HashMap<String, Integer> timesMap) {
        this.timesMap = timesMap;
    }

    void setUnclosedRelation(Set<String> unclosedRelation) {
        this.unclosedRelation = unclosedRelation;
    }

    public HashMap<Set<String>, Double> getRelationMap() {
        return relationMap;
    }

    public Set<String> getCloseRelation() {
        return closeRelation;
    }

    public Set<String> getUnclosedRelation() {
        return unclosedRelation;
    }

    public HashMap<String, Integer> getSpanMap() {
        return spanMap;
    }

    public HashMap<String, Integer> getTimesMap() {
        return timesMap;
    }

    public double getCloseValue() {
        return closeValue;
    }

    public double getUnclosedValue() {
        return unclosedValue;
    }

}
