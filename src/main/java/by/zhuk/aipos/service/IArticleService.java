package by.zhuk.aipos.service;


import by.zhuk.aipos.model.Article;

import java.util.List;

public interface IArticleService {

    void save(Article student);

    void delete(String name);

    Article find(String name);

    List<String> getArticlesName();

}