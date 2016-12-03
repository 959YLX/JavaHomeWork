package com.ylx.Analyse;

/**a
 * 线性表节点类，用于存储线性表节点信息
 * Created by ylx on 16/11/26.
 */
public class Node {

    private String Name = null;
    private int location = -1;

    Node(String Name, int location){
        this.Name = Name;
        this.location = location;
    }

    int getLocation() {
        return location;
    }

    String getName() {
        return Name;
    }
}
