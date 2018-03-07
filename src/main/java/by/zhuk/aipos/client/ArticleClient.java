package by.zhuk.aipos.client;


import by.zhuk.aipos.thrift.ArticleThrift;
import by.zhuk.aipos.thrift.ArticleThriftService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ArticleClient implements ArticleThriftService.Iface, Runnable {
    private Logger logger = LoggerFactory.getLogger(ArticleClient.class);
    private TTransport transport;

    private ArticleThriftService.Client client;

    private int port;

    private String host;


    public ArticleClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            transport = new TFramedTransport(new TSocket(host, port));
            TProtocol protocol = new TBinaryProtocol(transport);
            client = new ArticleThriftService.Client(protocol);
            transport.open();
        } catch (TException e) {
            logger.error("Absence server",e);
        }
    }

    public void transportEnd() {
        try {
            transport.close();
        } catch (Exception e) {
            logger.error("Absence server",e);
        }
        System.exit(0);
    }

    @Override
    public void saveArticle(ArticleThrift articleThrift) throws TException {
        client.saveArticle(articleThrift);
    }

    @Override
    public ArticleThrift getArticle(String name) throws TException {
        return client.getArticle(name);
    }

    @Override
    public void deleteArticle(String name) throws TException {
        client.deleteArticle(name);
    }

    @Override
    public void updateArticle(ArticleThrift articleThrift) throws TException {
        client.updateArticle(articleThrift);
    }

    @Override
    public List<String> getArticlesName() throws TException {
        return client.getArticlesName();
    }

    public void reconnect() {
        try {
            transport.close();
        } catch (Exception e) {
            logger.error("Absence server",e);
            return;
        }
        run();
    }
}
