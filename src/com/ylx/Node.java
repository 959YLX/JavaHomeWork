package com.ylx;

/**
 * Created by ylx on 16/11/26.
 */
public class Node {

    private String Name = null;
    private int location = -1;

    public Node(String Name,int location){
        this.Name = Name;
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return Name;
    }
}
