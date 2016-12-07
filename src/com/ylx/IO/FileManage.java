package com.ylx.IO;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

/**
 * Created by ylx on 16/12/7.
 */
public class FileManage {

    private Component parent = null;
    private JFileChooser jFileChooser = null;
    private FileNameExtensionFilter fileNameExtensionFilter = null;

    public FileManage(Component parent){
        if (parent != null) {
            this.parent = parent;
            init();
        }
    }

    private void init(){
        fileNameExtensionFilter = new FileNameExtensionFilter("文本文件","txt");
        jFileChooser = new JFileChooser("~");
        jFileChooser.setDialogTitle("选择文件");
        jFileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        jFileChooser.setFileFilter(fileNameExtensionFilter);
    }

    public File getOpenFile(){
        if (jFileChooser != null){
            jFileChooser.showOpenDialog(parent);
            File file = jFileChooser.getSelectedFile();
            return file;
        }
        return null;
    }

}
