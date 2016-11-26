package com.ylx;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Created by ylx on 16/11/26.
 */
public class TextAnalyse {

    private String Article = null;
    private int ArticleLength = 0;
    public void setArticle(String article) {
        if (article != null) {
            Article = article;
            ArticleLength = article.length();
        }
    }

    public  LinkedList<Node> getLocationList(LinkedList<Node>[] ListArray){
        LinkedList<Node> locationList = new LinkedList<>();
        LinkedList<Node> tempList = new LinkedList<>();
        LinkedList<Integer> indexList = new LinkedList<>();
        for (int i = 0; i < ListArray.length; i++) {
            LinkedList<Node> temp = ListArray[i];
            Node tempNode = temp.removeFirst();
            if (tempList.size() != 0) {
                int j = 0;
                while (true) {
                    if (tempNode.getLocation() <= tempList.get(j).getLocation()) {
                        tempList.add(j, tempNode);
                        indexList.add(j,i);
                        break;
                    }else if (j == tempList.size() - 1 && i != ListArray.length - 1){
                        tempList.add(tempNode);
                        indexList.add(j,i);
                        break;
                    }
                    j++;
                }
            }else{
                tempList.add(tempNode);
            }
        }
//        for (int i = 0; i < tempList.size(); i++) {
//            Node node = tempList.removeFirst();
//            int index = indexList.removeFirst();
//            locationList.add(node);
//            LinkedList<Node> temp = ListArray[index];
//            Node tempNode = temp.removeFirst();
//
//        }
        return tempList;
    }

    public LinkedList<Node> getTextList(String Name){
        int NameLength  = Name.length();
        LinkedList<Node> NameList = new LinkedList<>();

        int i = 0;
        while (true){
            i = Article.indexOf(Name,i);
            if (i == -1) { break; }
            NameList.add(new Node(Name,i));
            i += NameLength;
        }
        return NameList;
    }

}
