package by.zhuk.aipos.server;

import by.zhuk.aipos.service.ArticleService;
import by.zhuk.aipos.service.IArticleService;
import by.zhuk.aipos.thrift.ArticleThriftService;
import by.zhuk.aipos.thrift.ArticleThriftServiceImpl;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;

import javax.swing.*;
import java.awt.*;

public class ArticleServer {



    private static IArticleService articleService;

    private final static int PORT = 8080;
    private static JTextArea textArea;

    public ArticleServer() {
        articleService = new ArticleService() ;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Server");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea = new JTextArea();
        textArea.setBackground(Color.decode("#2C001E"));
        textArea.setForeground(Color.WHITE);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);
        frame.setVisible(true);
        ArticleServer studentServer = new ArticleServer();
        studentServer.start();
    }

    private void start() {
        try {
            TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(PORT);
            ArticleThriftService.Processor<ArticleThriftServiceImpl> processor = new ArticleThriftService.Processor<>(new ArticleThriftServiceImpl());

            TServer server = new TNonblockingServer(new TNonblockingServer.Args(serverTransport).
                    processor(processor));
            textArea.append("SERVER START");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }


    public static IArticleService getArticleService() {
        return articleService;
    }


}