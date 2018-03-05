package by.zhuk.aipos.client;

import by.zhuk.aipos.model.Article;
import by.zhuk.aipos.thrift.ArticleThrift;
import by.zhuk.aipos.thrift.ArticleThriftService;
import org.apache.thrift.TException;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticleComponent extends JComponent {
    private JPanel articles;
    private JTextArea content;
    private ArticleThrift selectedArticle;
    private ArticleClient client;

    public ArticleComponent() {
        articles = new JPanel();
        articles.setLayout(new GridLayout(10, 1, 0, 0));
        content = new JTextArea();
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
            selectedArticle = client.getArticle(articlesList.get(0));
            updateContent();
        } catch (TException e) {
            e.printStackTrace();
        }
        if(articlesList==null){
            return;
        }
        for (String article : articlesList) {
            JButton button = new JButton(article);
            button.addActionListener(actionEvent -> {
                try {
                    selectedArticle=client.getArticle(article);
                } catch (TException e) {
                    e.printStackTrace();
                }
                updateContent();
            });
            articles.add(button);
        }
    }

    private void updateContent() {
        content.setText("");
        String into =selectedArticle.getInto();
        content.append("INTRO\n");
        content.append(into);
        content.append("\n----------------\n");
        String body =selectedArticle.getBody();
        content.append(body);
        content.append("\n----------------\n");

        String codeExample =selectedArticle.getCodeExample();
        content.append(codeExample);
        content.append("\n----------------\n");
    }


    public void setClient(ArticleClient client) {
        this.client = client;
    }
}