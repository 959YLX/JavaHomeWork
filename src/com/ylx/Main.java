package com.ylx;

import java.util.LinkedList;

/**
 * Created by ylx on 16/11/26.
 */
public class Main {

    public static void main(String[] args) {

        LinkedList<Node> linkedList = new LinkedList<>();
        LinkedList<Node> linkedList1 = new LinkedList<>();
        LinkedList<Node> linkedList2 = new LinkedList<>();
        LinkedList<Node> linkedList3 = new LinkedList<>();
        LinkedList<Node> linkedList4 = new LinkedList<>();
        linkedList.add(new Node("zhangsan",20));
        linkedList.add(new Node("zhangsan",25));
        linkedList.add(new Node("zhangsan",5435));
        linkedList.add(new Node("zhangsan",6765));
        linkedList.add(new Node("zhangsan",98754));
        linkedList1.add(new Node("hahaha",10));
        linkedList1.add(new Node("hahaha",15));
        linkedList1.add(new Node("hahaha",251));
        linkedList1.add(new Node("hahaha",434));
        linkedList2.add(new Node("lisi",39));
        linkedList2.add(new Node("lisi",50));
        linkedList2.add(new Node("lisi",255));
        linkedList2.add(new Node("lisi",38210));
        linkedList3.add(new Node("wanger",1));
        linkedList3.add(new Node("wanger",501));
        linkedList3.add(new Node("wanger",2511));
        linkedList3.add(new Node("wanger",38210));
        linkedList4.add(new Node("lalala",510));
        linkedList4.add(new Node("lalala",514));
        linkedList4.add(new Node("lalala",1251));
        linkedList4.add(new Node("lalala",38210));
        LinkedList<Node>[] linkedLists = new LinkedList[]{linkedList,linkedList1,linkedList2,linkedList3,linkedList4};
        LinkedList<Node> temp = new TextAnalyse().getLocationList(linkedLists);
//        for (Node node : temp){
//            System.out.println(node.getName()+"--"+node.getLocation());
//        }
    }

}
