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
        linkedList.add(new Node("zhangsan",20));
        linkedList.add(new Node("zhangsan",260));
        linkedList.add(new Node("zhangsan",650));
        linkedList.add(new Node("zhangsan",860));
        linkedList1.add(new Node("lisi",10));
        linkedList1.add(new Node("lisi",50));
        linkedList1.add(new Node("lisi",251));
        linkedList1.add(new Node("lisi",38210));
        linkedList2.add(new Node("lisi",89));
        linkedList2.add(new Node("lisi",50));
        linkedList2.add(new Node("lisi",251));
        linkedList2.add(new Node("lisi",38210));
        linkedList3.add(new Node("lisi",1));
        linkedList3.add(new Node("lisi",50));
        linkedList3.add(new Node("lisi",251));
        linkedList3.add(new Node("lisi",38210));
        linkedList4.add(new Node("lisi",54));
        linkedList4.add(new Node("lisi",50));
        linkedList4.add(new Node("lisi",251));
        linkedList4.add(new Node("lisi",38210));
        LinkedList<Node>[] linkedLists = new LinkedList[]{linkedList,linkedList1,linkedList2,linkedList3,linkedList4};
        LinkedList<Node> temp = new TextAnalyse().getLocationList(linkedLists);
        for (Node node : temp){
            System.out.println("--"+node.getLocation());
        }
    }

}
