package by.zhuk.aipos.model;

public class Article {
    private String name;
    private String into;
    private String body;
    private String codeExample;

    public Article(String name, String into, String body, String codeExample) {
        this.name = name;
        this.into = into;
        this.body = body;
        this.codeExample = codeExample;
    }

    public String getInto() {
        return into;
    }

    public String getBody() {
        return body;
    }

    public String getCodeExample() {
        return codeExample;
    }

    public void setInto(String into) {
        this.into = into;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCodeExample(String codeExample) {
        this.codeExample = codeExample;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "INTO \n"
                        + into + "\n"
                        + name.toUpperCase()+"\n"
                        + body + "\n"
                        + codeExample + "\n";
    }

}