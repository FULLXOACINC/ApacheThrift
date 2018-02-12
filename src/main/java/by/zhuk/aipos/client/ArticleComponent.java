package by.zhuk.aipos.client;

import by.zhuk.aipos.thrift.ArticleThrift;

import javax.swing.*;
import java.awt.*;

public class ArticleComponent extends JComponent{
    private JPanel panal;
    private ArticleThrift selectedStudent;

    public ArticleComponent(MainWindow mainWindow) {
        panal = new JPanel();
        panal.setLayout(new GridLayout(1, 2, 0, 0));
        panal.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public ArticleThrift getSelectedStudent() {
        return selectedStudent;
    }

    public void updatePanel() {

    }
}