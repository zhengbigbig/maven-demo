package com.company.spider.activiy;

import java.io.IOException;
import com.company.spider.model.*;

public class SpiderThread extends Thread {
    // 开启多线程去进行爬取
    private String url;
    private SearchSate searchSate;

    public SpiderThread(SearchSate searchSate, String url) {
        this.url = url;
        this.searchSate = searchSate;
        //System.out.println("Start reading URL: " + this.url);
        start();
    }

    @Override
    public void run() {
        try {
            NewsWithRelated next = UrlNewsReader.read(url);  // 涉及网络访问，耗时
            searchSate.visit(next);  // 在访问后得到的扔到queue里面
        } catch (IOException e) {
            System.out.println("Ignored an error page: " + url);
        }
    }
}
