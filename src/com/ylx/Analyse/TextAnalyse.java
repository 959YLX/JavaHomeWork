package com.ylx.Analyse;

import java.util.LinkedList;

/**
 * 字符串处理类，用于对文本字符串进行抽象化，根据姓名提取出位置线性表
 * Created by ylx on 16/11/26.
 */
public class TextAnalyse implements Runnable{

    private String Article = null;
    private int LineNumber = 0;
    private String[] names = null;

    public TextAnalyse(String Article,String[] names,int LineNumber){
        if (!(Article == null || names == null)) {
            this.Article = Article;
            this.LineNumber = LineNumber;
            this.names = names;
        }
    }

    private LinkedList<Node> getLocationList(){
        LinkedList[] ListArray = new LinkedList[names.length];
        int j = 0;
        for (int i = 0; i < names.length; i++) {
            LinkedList<Node> list = getTextList(names[i]);
            if (!list.isEmpty()){
                ListArray[i-j] = list;
            }else{
                j++;
            }
        }
        if (j != 0){
            LinkedList[] finalList = new LinkedList[names.length-j];
            System.arraycopy(ListArray,0,finalList,0,names.length-j);
            return getLocationList(finalList);
        }
        return getLocationList(ListArray);
    }

    private LinkedList<Node> getLocationList(LinkedList<Node>[] ListArray){
        LinkedList<Node> locationList = new LinkedList<>();
        LinkedList<Node> tempList = new LinkedList<>();
        LinkedList<Integer> indexList = new LinkedList<>();
        for (int i = 0; i < ListArray.length; i++) {

            LinkedList<Node> temp = ListArray[i];
            Node tempNode;
            if (temp.size() != 0) {
                tempNode = temp.removeFirst();
            }else{
                break;
            }
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
        Merge.getMerge().submit(LineNumber,getLocationList());
    }
}
