package com.ylx;

import com.ylx.Analyse.Merge;
import com.ylx.Analyse.Node;
import com.ylx.IO.ArticleReader;
import com.ylx.Thread.AnalyseThread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by ylx on 16/11/26.
 */
public class Main {

    public static String getMapInfo(Map<Integer,LinkedList<Node>> map){
        String str = "";
        for (Map.Entry<Integer,LinkedList<Node>> entry : map.entrySet()){
            str += "\nkey:"+entry.getKey()+" --- value: ---";
            for (Node node : entry.getValue()){
                str += "  name:"+node.getName()+" location:"+node.getLocation();
            }
        }
        return str;
    }

    public static void main(String[] args) {

        try {
            AnalyseThread.getAnalyseThread().setName(new String[]{"zhangsan","lisi"});
            ArticleReader articleReader = new ArticleReader(new FileInputStream("/Users/ylx/Desktop/xiaoshuo.txt"));
            Thread readThread = new Thread(articleReader);
            readThread.start();
            readThread.join();
            System.out.println("---");
            System.out.println(getMapInfo(Merge.getMerge().getSubmitMap()));
        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
