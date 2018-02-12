package by.zhuk.aipos.thrift;

import org.apache.thrift.TException;

import java.util.List;

public class ArticleThriftServiceImpl implements ArticleThriftService.Iface{
    @Override
    public void saveArticle(ArticleThrift articleThrift) throws TException {

    }

    @Override
    public ArticleThrift getArticle(String name) throws TException {
        return null;
    }

    @Override
    public void deleteArticle(String name) throws TException {

    }

    @Override
    public List<String> getArticlesName() throws TException {
        return null;
    }
}