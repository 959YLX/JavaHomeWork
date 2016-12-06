package com.ylx.Analyse;

/**
 * Created by ylx on 16/12/6.
 */
public class SubmitAnalyse{

    private String Article = null;
    private int LineNumber = -1;

    public SubmitAnalyse(String Article,int LineNumber){
        this.Article = Article;
        this.LineNumber = LineNumber;
    }

    public int getLineNumber() {
        return LineNumber;
    }

    public String getArticle() {
        return Article;
    }
}
