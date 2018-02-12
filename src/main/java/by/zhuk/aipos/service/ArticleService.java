package by.zhuk.aipos.service;


import by.zhuk.aipos.model.Article;
import by.zhuk.aipos.server.ArticleServer;

import java.util.List;

public class ArticleService implements IArticleService {


    @Override
    public void save(Article article) {
        ArticleServer.getArticleService().save(article);
    }

    @Override
    public void delete(String name) {
        ArticleServer.getArticleService().delete(name);
    }

    @Override
    public Article find(String name) {
        return ArticleServer.getArticleService().find(name);
    }

    @Override
    public List<String> getArticlesName() {
        return ArticleServer.getArticleService().getArticlesName();
    }
}
