package com.company;

public class UrlNewsReader extends NewsReader {
    @Override
    public News readNews(String path) {
        super.readNews(path);
        // 从文件读取，解析  具体实现实例
        return new News("abc", "test");
    }
}
