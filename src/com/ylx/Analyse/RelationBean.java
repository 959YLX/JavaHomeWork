package com.ylx.Analyse;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ylx on 16/12/11.
 */
public class RelationBean {

    private Set<String> relationSet = null;
    private double weight = -1d;

    public boolean isRelation(String name1,String name2){
        return (relationSet.contains(name1) && relationSet.contains(name2));
    }

    public void setRelationSet(String name1,String name2) {
        relationSet = new HashSet<>();
        relationSet.add(name1);
        relationSet.add(name2);
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
