package com.ylx.UI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

/**
 * Created by ylx on 16/12/7.
 */
class FileManage {

    private Component parent = null;
    private JFileChooser jFileChooser = null;

    FileManage(Component parent){
        if (parent != null) {
            this.parent = parent;
            init();
        }
    }

    private void init(){
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("文本文件", "txt");
        jFileChooser = new JFileChooser("~");
        jFileChooser.setDialogTitle("选择文件");
        jFileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        jFileChooser.setFileFilter(fileNameExtensionFilter);
    }

    File getOpenFile(){
        if (jFileChooser != null){
            jFileChooser.showOpenDialog(parent);
            return jFileChooser.getSelectedFile();
        }
        return null;
    }

}
