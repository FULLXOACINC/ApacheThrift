package by.zhuk.aipos.thrift;

import by.zhuk.aipos.server.ArticleServer;
import org.apache.commons.io.FileUtils;
import org.apache.thrift.TException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArticleThriftServiceImpl implements ArticleThriftService.Iface {
    private final static String PATH = "articles/";
    private final ArticleServer articleServer;

    public ArticleThriftServiceImpl(ArticleServer articleServer) {
        this.articleServer = articleServer;
    }

    @Override
    public void saveArticle(ArticleThrift articleThrift) throws TException {
        File file = new File(PATH + articleThrift.getName());
        boolean isCreate = file.mkdir();
        if (!isCreate) {
            articleServer.log("Can't save article " + articleThrift);
            return;
        }
        try (PrintWriter outIntro = new PrintWriter(PATH + articleThrift.getName() + "/intro");
             PrintWriter outBody = new PrintWriter(PATH + articleThrift.getName() + "/body");
             PrintWriter outExamples = new PrintWriter(PATH + articleThrift.getName() + "/examples")) {
            outIntro.println(articleThrift.getInto());
            outBody.println(articleThrift.getBody());
            outExamples.println(articleThrift.getCodeExample());
        } catch (FileNotFoundException e) {
            articleServer.log("ERROR " + e.getMessage());
            throw new TException(e);
        }
        articleServer.log("Save " + articleThrift);
    }

    @Override
    public ArticleThrift getArticle(String name) throws TException {
        ArticleThrift articleThrift = new ArticleThrift();
        String intro;
        String body;
        String codeExample;
        try {
            intro = readFile(PATH + name + "/intro");
            body = readFile(PATH + name + "/body");
            codeExample = readFile(PATH + name + "/examples");
        } catch (IOException e) {
            articleServer.log("ERROR " + e.getMessage());
            throw new TException(e);
        }
        articleThrift.setName(name);
        articleThrift.setInto(intro);
        articleThrift.setBody(body);
        articleThrift.setCodeExample(codeExample);

        articleServer.log("Get " + name);
        return articleThrift;
    }

    @Override
    public void deleteArticle(String name) throws TException {
        File directory = new File(PATH + name);
        try {
            FileUtils.deleteDirectory(directory);
        } catch (IOException e) {
            throw new TException(e);
        }
        articleServer.log("Delete " + name);
    }

    @Override
    public void updateArticle(ArticleThrift articleThrift) throws TException {
        deleteArticle(articleThrift.getName());
        saveArticle(articleThrift);
    }

    @Override
    public List<String> getArticlesName() {
        File[] directories = new File(PATH).listFiles(File::isDirectory);
        List<String> result = new ArrayList<>();
        if (directories != null) {
            for (File directory : directories) {
                result.add(directory.getName());
            }
        }
        Collections.sort(result);
        articleServer.log("Get all ");
        return result;
    }

    private String readFile(String file) throws IOException {
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        }
    }
}