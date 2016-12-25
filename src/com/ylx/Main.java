package com.ylx;

import com.ylx.Analyse.Node;
import com.ylx.Analyse.ResultSort;
import com.ylx.IO.ArticleReader;
import com.ylx.Thread.AnalyseThread;
import com.ylx.UI.MainFrame;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;

/**
 * Created by ylx on 16/11/26.
 */
public class Main {

    public static volatile boolean STOP = false;

    public static String getMapInfo(Map<Integer,LinkedList<Node>> map){
        String str = "result:\n";
        for (Map.Entry<Integer,LinkedList<Node>> entry : map.entrySet()){
            str += "\nkey:"+entry.getKey()+" --- value: ---";
            for (Node node : entry.getValue()){
                str += "  name:"+node.getName()+" location:"+node.getLocation();
            }
        }
        return str;
    }

    public static void main(String[] args) {
        new MainFrame("lala");

    }

}
