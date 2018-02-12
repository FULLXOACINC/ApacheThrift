package by.zhuk.aipos.client;


import by.zhuk.aipos.client.ArticleClient;
import by.zhuk.aipos.client.ArticleComponent;
import by.zhuk.aipos.client.ExitAdapter;
import by.zhuk.aipos.model.Article;
import by.zhuk.aipos.thrift.ArticleThrift;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.thrift.TException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MainWindow {

    public static Logger logger = LogManager.getLogger(MainWindow.class);

    private JFrame frame;

    private String host;

    private int port;

    private ArticleClient articleClient;

    private ArticleComponent articleComponent;
    private final static String IMG_PATCH = "img/";

    public MainWindow() {
        frame = new JFrame("Thrifts Student Client");
        host = "127.0.0.1";
        port = 8080;
        frame.setLayout(new BorderLayout());
        frame.add(createToolBar(), BorderLayout.NORTH);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new ExitAdapter(this));
        articleComponent = new ArticleComponent(this);
        frame.add(articleComponent, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void updateTable() {
        logger.info("Update table");
        articleComponent.updatePanel();
    }

    private JToolBar createToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.add(makeButton(new JButton(), "ADD.png", actionEvent -> addArticle()));
        toolBar.add(makeButton(new JButton(), "DELETE.png", actionEvent -> deleteArticle()));
        return toolBar;
    }

    private void addArticle() {
        logger.info("Add new student");
//        ArticleDialog dialog = new StudentDialog(this, "Add new Student");
//        dialog.show();
//        updateTable();
    }

    private void deleteArticle() {
        ArticleThrift articleThrift = articleComponent.getSelectedStudent();
        if (articleThrift != null) {
            logger.info("Remove student");
            int confirm = JOptionPane.showOptionDialog(
                    null, "Are You Sure to delete article " + articleThrift.getName() + "?",
                    "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirm == 0) {
                try {
                    getStudentClient().deleteArticle(articleThrift.getName());
                } catch (TException e) {
                    e.printStackTrace();
                }
                updateTable();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Select student in table!",
                    "Not valid",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.runClient();
    }

    private void runClient() {
        articleClient = new ArticleClient(host, port, this);
        articleClient.start();
    }

    public void transportClose() {
        articleClient.transportClose();
    }

    public ArticleClient getStudentClient() {
        return articleClient;
    }

    public JFrame getFrame() {
        return frame;
    }

    private JButton makeButton(JButton button, String imgString, ActionListener action) {
        button.addActionListener(action);
        String patch = IMG_PATCH + imgString;
        ImageIcon img = new ImageIcon(patch);
        button.setIcon(img);
        return button;
    }
}
