package com.ylx.Analyse;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ylx on 16/12/11.
 */
class RelationBean {

    private Set<String> relationSet = null;
    private double weight = 1d;

    RelationBean(String X_Name, String Y_Name){
        relationSet = new HashSet<>(2);
        relationSet.add(X_Name);
        relationSet.add(Y_Name);
    }

    Set<String> getRelationSet() {
        return relationSet;
    }

    void setWeight(double weight) {
        this.weight = weight;
    }

    double getWeight() {
        return weight;
    }

}
