package by.zhuk.aipos.thrift;

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

    @Override
    public void saveArticle(ArticleThrift articleThrift) throws TException {
        File file = new File(PATH+articleThrift.getName());
        file.mkdir();
        try (PrintWriter out = new PrintWriter(PATH + articleThrift.getName() + "/intro")) {
            out.println(articleThrift.getInto());
        } catch (FileNotFoundException e) {
            throw new TException(e);
        }
        try (PrintWriter out = new PrintWriter(PATH + articleThrift.getName() + "/body")) {
            out.println(articleThrift.getBody());
        } catch (FileNotFoundException e) {
            throw new TException(e);
        }
        try (PrintWriter out = new PrintWriter(PATH + articleThrift.getName() + "/exemples")) {
            out.println(articleThrift.getCodeExample());
        } catch (FileNotFoundException e) {
            throw new TException(e);
        }
    }

    @Override
    public ArticleThrift getArticle(String name) throws TException {
        ArticleThrift articleThrift = new ArticleThrift();
        String intro;
        String body;
        String codeExemple;
        try {
            intro = readFile(PATH + name + "/intro");
            body = readFile(PATH + name + "/body");
            codeExemple = readFile(PATH + name + "/exemples");
        } catch (IOException e) {
            throw new TException(e);
        }
        articleThrift.setName(name);
        articleThrift.setInto(intro);
        articleThrift.setBody(body);
        articleThrift.setCodeExample(codeExemple);

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
    }

    @Override
    public List<String> getArticlesName() throws TException {
        File[] directories = new File(PATH).listFiles(File::isDirectory);
        List<String> result = new ArrayList<>();
        for (File directory : directories) {
            result.add(directory.getName());
        }
        Collections.sort(result);
        return result;
    }

    private String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }
}