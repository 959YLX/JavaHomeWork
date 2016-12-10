package com.ylx.Analyse;

import com.ylx.UI.AnalysePanel;

/**
 * Created by ylx on 16/12/10.
 */
public class AnalyseTask {

    private String FilePath = null;
    private PersonBean[] personsInfo = null;
    private AnalysePanel processPanel = null;

    public void setProcessPanel(AnalysePanel processPanel) {
        this.processPanel = processPanel;
    }

    public void setFilePath(String filePath) {
        FilePath = filePath;
    }

    public void setPersonsInfo(PersonBean[] personsInfo) {
        this.personsInfo = personsInfo;
    }

    public PersonBean[] getPersonsInfo() {
        return personsInfo;
    }

    public String getFilePath() {
        return FilePath;
    }

    public AnalysePanel getProcessPanel() {
        return processPanel;
    }
}
