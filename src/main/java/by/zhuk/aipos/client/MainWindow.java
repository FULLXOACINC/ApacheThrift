package by.zhuk.aipos.client;


import by.zhuk.aipos.thrift.ArticleThrift;
import org.apache.log4j.BasicConfigurator;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainWindow {

    private Logger logger = LoggerFactory.getLogger(MainWindow.class);

    private final String host = "127.0.0.1";

    private final int PORT = 8080;

    private ArticleClient articleClient;

    private ArticleComponent articleComponent;
    private final static String IMG_PATCH = "img/";

    private MainWindow() {
        JFrame frame = new JFrame("Thrifts Java Client");

        frame.setLayout(new BorderLayout());
        frame.add(createToolBar(), BorderLayout.NORTH);
        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new ExitAdapter(this));
        articleComponent = new ArticleComponent();
        frame.add(articleComponent, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void updateTable() {
        articleComponent.updatePanel();
    }

    private JToolBar createToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.add(makeButton(new JButton(), "ADD.png", actionEvent -> addArticle()));
        toolBar.add(makeButton(new JButton(), "DELETE.png", actionEvent -> deleteArticle()));
        toolBar.add(makeButton(new JButton(), "UPDATE.png", actionEvent -> updateArticle()));
        toolBar.add(makeButton(new JButton(), "RECONNECT.png", actionEvent -> reconnect()));

        return toolBar;
    }

    private void reconnect() {
        articleClient.reconnect();
    }

    private void addArticle() {
        logger.info("add Article");
        AddDialog dialog = new AddDialog(articleClient, "Add Article");
        dialog.show();
        articleComponent.updatePanel();
    }

    private void deleteArticle() {
        ArticleThrift articleThrift = articleComponent.getSelectedArticle();
        if (articleThrift != null) {
            int confirm = JOptionPane.showOptionDialog(
                    null, "Are You Sure to delete article " + articleThrift.getName() + "?",
                    "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirm == 0) {
                try {
                    getArticleClient().deleteArticle(articleThrift.getName());
                } catch (TException e) {
                    logger.error("Can not delete article", e);
                }
                updateTable();
            }
            logger.info("delete Article");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Select article !",
                    "Not valid",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateArticle() {
        ArticleThrift articleThrift = articleComponent.getSelectedArticle();
        if (articleThrift != null) {
            UpdateDialog dialog = new UpdateDialog(articleClient, "Update Article " + articleThrift.getName(), articleThrift);
            dialog.show();
            articleComponent.updatePanel();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Select article !",
                    "Not valid",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();
        MainWindow mainWindow = new MainWindow();
        mainWindow.runClient();
    }

    private void runClient() {
        articleClient = new ArticleClient(host, PORT);
        Thread thread = new Thread(articleClient);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            logger.error("Unknown error ",e);
        }
        articleComponent.setClient(articleClient);
        articleComponent.updatePanel();
    }

    private ArticleClient getArticleClient() {
        return articleClient;
    }

    private JButton makeButton(JButton button, String imgString, ActionListener action) {
        button.addActionListener(action);
        String patch = IMG_PATCH + imgString;
        ImageIcon img = new ImageIcon(patch);
        button.setIcon(img);
        return button;
    }


    public void transportEnd() {
        articleClient.transportEnd();
    }
}
