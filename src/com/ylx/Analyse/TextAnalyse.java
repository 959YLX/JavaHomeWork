package com.ylx.Analyse;

import java.util.LinkedList;

/**
 * 字符串处理类，用于对文本字符串进行抽象化，根据姓名提取出位置线性表
 * Created by ylx on 16/11/26.
 */
public class TextAnalyse implements Runnable{

    private String Article = null;

    public TextAnalyse(){

    }

    private LinkedList<Node> getLocationList(String Article,String[] names){
        if (Article == null || names == null) return null;
        else{
            this.Article = Article;
        }
        LinkedList<Node>[] ListArray = new LinkedList[names.length];
        for (int i = 0; i < names.length; i++) {
            ListArray[i] = getTextList(names[i]);
        }
        return getLocationList(ListArray);
    }

    private LinkedList<Node> getLocationList(LinkedList<Node>[] ListArray){
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
                    }else if (j == tempList.size() - 1){
                        tempList.add(tempNode);
                        indexList.add(i);
                        break;
                    }
                    j++;
                }
            }else{
                tempList.add(tempNode);
                indexList.add(i);
            }
        }
        while (true) {
            if (tempList.size() == 0) break;
            Node node = tempList.removeFirst();
            int index = indexList.removeFirst();
            locationList.add(node);
            LinkedList<Node> list = ListArray[index];
            if (!list.isEmpty()) {
                Node TempNode = list.removeFirst();
                insertNode(tempList, indexList, TempNode, index);
            }
        }
        return locationList;
    }

    private void insertNode(LinkedList<Node> tempList,LinkedList<Integer> indexList,Node newNode,int index){
        int j = 0;
        while (true) {
            if (tempList.isEmpty() || (j == tempList.size())){
                tempList.add(newNode);
                indexList.add(index);
                break;
            }else if (newNode.getLocation() <= tempList.get(j).getLocation()) {
                tempList.add(j, newNode);
                indexList.add(j,index);
                break;
            }
            j++;
        }
    }

    private LinkedList<Node> getTextList(String Name){
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

    @Override
    public void run() {

    }
}
