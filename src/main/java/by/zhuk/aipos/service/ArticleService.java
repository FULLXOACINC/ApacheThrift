package by.zhuk.aipos.service;


import by.zhuk.aipos.model.Article;
import by.zhuk.aipos.server.ArticleServer;

import java.util.List;

public class ArticleService implements IArticleService {
    private ArticleServer articleServer;

    public ArticleService(ArticleServer articleServer) {
        this.articleServer = articleServer;
    }

    @Override
    public void save(Article article) {
        ArticleServer.getArticleService().save(article);
        articleServer.log("Save " + article.getName());
    }

    @Override
    public void delete(String name) {
        ArticleServer.getArticleService().delete(name);
        articleServer.log("Delete " + name);
    }

    @Override
    public Article find(String name) {
        articleServer.log("Get " + name);
        return ArticleServer.getArticleService().find(name);

    }

    @Override
    public List<String> getArticlesName() {
        articleServer.log("Get all articles");
        return ArticleServer.getArticleService().getArticlesName();
    }
}
