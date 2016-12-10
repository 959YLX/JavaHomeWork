package com.ylx.Analyse;

import java.util.Set;

/**
 * Created by ylx on 16/12/11.
 */
public class RelationBean {

    private Set<String> relationSet = null;
    private double weight = -1d;

    public void setRelationSet(Set<String> relationSet) {
        this.relationSet = relationSet;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public Set<String> getRelationSet() {
        return relationSet;
    }
}
