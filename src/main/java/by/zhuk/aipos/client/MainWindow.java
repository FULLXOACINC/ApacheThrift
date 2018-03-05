package by.zhuk.aipos.client;


import by.zhuk.aipos.thrift.ArticleThrift;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.apache.thrift.TException;

public class MainWindow {

    public static Logger logger = LogManager.getLogger(MainWindow.class);

    private String host;

    private final int PORT = 8080;

    private ArticleClient articleClient;

    private ArticleComponent articleComponent;
    private final static String IMG_PATCH = "img/";

    public MainWindow() {
        JFrame frame = new JFrame("Thrifts Java Client");
        host = "127.0.0.1";

        frame.setLayout(new BorderLayout());
        frame.add(createToolBar(), BorderLayout.NORTH);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new ExitAdapter(this));
        articleComponent = new ArticleComponent();
        frame.add(articleComponent, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void updateTable() {
        logger.log(Level.INFO,"Update table");
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
        logger.info("Add new article");
        AddDialog dialog = new AddDialog(articleClient, "Add Article");
        dialog.show();
        articleComponent.updatePanel();
    }

    private void deleteArticle() {
        ArticleThrift articleThrift = articleComponent.getSelectedArticle();
        if (articleThrift != null) {
            logger.info("Remove article");
            int confirm = JOptionPane.showOptionDialog(
                    null, "Are You Sure to delete article " + articleThrift.getName() + "?",
                    "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirm == 0) {
                try {
                    getArticleClient().deleteArticle(articleThrift.getName());
                } catch (TException e) {
                    e.printStackTrace();
                }
                updateTable();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Select article in table!",
                    "Not valid",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.runClient();
    }

    private void runClient() {
        articleClient = new ArticleClient(host, PORT, articleComponent);
        articleClient.start();

    }

    public void transportClose() {
        articleClient.transportClose();
    }

    public ArticleClient getArticleClient() {
        return articleClient;
    }

    private JButton makeButton(JButton button, String imgString, ActionListener action) {
        button.addActionListener(action);
        String patch = IMG_PATCH + imgString;
        ImageIcon img = new ImageIcon(patch);
        button.setIcon(img);
        return button;
    }
}
