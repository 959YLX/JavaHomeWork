package com.ylx.Analyse;

/**
 * Created by ylx on 16/12/11.
 */
public class RelationBean {

    private String X_Name = null, Y_Name = null;
    private double weight = 1d;

    public RelationBean(String X_Name,String Y_Name){
        this.X_Name = X_Name;
        this.Y_Name = Y_Name;
    }

    public String getX_Name() {
        return X_Name;
    }

    public String getY_Name() {
        return Y_Name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

}
