package by.zhuk.aipos.client;


import by.zhuk.aipos.thrift.ArticleThrift;
import by.zhuk.aipos.thrift.ArticleThriftService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.ArrayList;
import java.util.List;

public class ArticleClient extends Thread implements ArticleThriftService.Iface {

    private final MainWindow mainWindow;
    private TTransport transport;

    private ArticleThriftService.Client client;

    private int port;

    private String host;


    public ArticleClient(String host, int port, MainWindow mainWindow) {
        this.host = host;
        this.port = port;
        this.mainWindow = mainWindow;
    }

    public void run() {
        // MainWindow.logger.info("Start client");
        try {
            transport = new TFramedTransport(new TSocket(host, port));
            TProtocol protocol = new TBinaryProtocol(transport);
            client = new ArticleThriftService.Client(protocol);
            transport.open();
            //mainWindow.updateTable();
        } catch (TException e) {

            System.exit(-1);
        }
    }

    public void transportClose() {
        try {
            transport.close();
        } catch (Exception e) {

        }
        System.exit(0);
    }


    @Override
    public void saveArticle(ArticleThrift articleThrift) throws TException {

    }

    @Override
    public ArticleThrift getArticle(String name) throws TException {
        return null;
    }

    @Override
    public void deleteArticle(String name) throws TException {
        client.deleteArticle(name);
    }

    @Override
    public List<String> getArticlesName() throws TException {
        return client.getArticlesName();
    }
}
