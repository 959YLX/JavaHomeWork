package com.ylx.Analyse;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by ylx on 16/12/11.
 */
public class RelationCalculate {
    private PersonBean[] personBeans = null;
    private Map<Integer,LinkedList<Node>> relationList = null;

    public RelationCalculate(Map<Integer,LinkedList<Node>> relationList,PersonBean[] personBeans){
        this.personBeans = personBeans;
        this.relationList = relationList;
    }

    public RelationBean[] calculateRelation(){
        return null;
    }

}
