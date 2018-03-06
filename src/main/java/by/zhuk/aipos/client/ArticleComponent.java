package by.zhuk.aipos.client;


import by.zhuk.aipos.thrift.ArticleThrift;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ArticleComponent extends JComponent {
    private Logger logger = LoggerFactory.getLogger(ArticleComponent.class);

    private JPanel articles;
    private JTextArea content;
    private ArticleThrift selectedArticle;
    private ArticleClient client;

    public ArticleComponent() {
        articles = new JPanel();
        articles.setLayout(new GridLayout(15, 1, 0, 0));
        content = new JTextArea();
        content.setBackground(Color.decode("#2C001E"));
        content.setForeground(Color.WHITE);
        content.setEnabled(false);
        setLayout(new GridLayout(1, 2, 0, 0));
        setBorder(BorderFactory.createLineBorder(Color.black));
        add(articles);
        add(content);
    }

    public ArticleThrift getSelectedArticle() {
        return selectedArticle;
    }

    public void updatePanel() {
        articles.removeAll();
        createPanel();
        revalidate();
        repaint();

    }

    private void createPanel() {
        List<String> articlesList = null;
        try {
            articlesList = client.getArticlesName();
            if (selectedArticle == null) {
                selectedArticle = client.getArticle(articlesList.get(0));
            } else {
                selectedArticle = client.getArticle(selectedArticle.getName());
            }
            updateContent();
        } catch (TException e) {
            logger.error("", e);
        }
        if (articlesList == null) {
            return;
        }
        for (String article : articlesList) {
            JButton button = new JButton(article);
            button.addActionListener(actionEvent -> {
                try {
                    selectedArticle = client.getArticle(article);
                } catch (TException e) {
                    logger.error("", e);
                }
                updateContent();
            });
            articles.add(button);
        }
    }

    public void updateContent() {
        content.setText("");
        String into = selectedArticle.getInto();
        content.append("Intro\n\n");
        content.append(into);
        content.append("\nMain\n\n");
        String body = selectedArticle.getBody();
        content.append(body);
        content.append("\nExamples\n\n");

        String codeExample = selectedArticle.getCodeExample();
        content.append(codeExample);
    }


    public void setClient(ArticleClient client) {
        this.client = client;
    }
}