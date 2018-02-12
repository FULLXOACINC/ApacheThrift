namespace java by.zhuk.aipos.thrift

struct ArticleThrift {
   1 : string name
   2 : string into
   3 : string body
   4 : string codeExample

}

service ArticleThriftService {

    void saveArticle(1 : ArticleThrift articleThrift),
    ArticleThrift getArticle(1 : string name),
    void deleteArticle(1 : string name),
    list<string> getArticlesName(),

}