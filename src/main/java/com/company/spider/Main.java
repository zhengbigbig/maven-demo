package com.company.spider;

import com.company.spider.model.NewsWithRelated;
import com.company.spider.model.UrlNewsReader;
import com.company.spider.model.Viewable;
import com.company.spider.view.ListViewer;

import java.util.*;

public class Main {

    // 本地存储新闻内容，如何在终端显示

    // 1. 抽象出 对象
    // 2. 设计 对象应该具有的属性，状态和行为
    // 3. 思考 对象之间交互
    // 4. 开始写代码

    static final int maximumURL = 10;

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        // 广度优先搜索
        Queue<NewsWithRelated> newsQueue = new LinkedList<NewsWithRelated>();

        String startUrl = "https://readhub.me/topic/5bMmlAm75lD";
        NewsWithRelated startNews = UrlNewsReader.read(startUrl);

        int count = 0;
        Set<String> visited = new HashSet<>(); // 标记已经访问过的url
        visited.add(startUrl);
        newsQueue.add(startNews);
        ArrayList<Viewable> results = new ArrayList<>();  // 存储扫描到的内容（多态）
        while (!newsQueue.isEmpty() && count <= maximumURL) {
            NewsWithRelated current = newsQueue.poll();
            results.add(current);
            count += 1;
            for (Map.Entry<String, String> entry : current.getRelateds().entrySet()) {
                String url = entry.getValue();
                NewsWithRelated next = UrlNewsReader.read(url);
                if (!visited.contains(url)) {
                    newsQueue.add(next);
                    visited.add(url);
                }
            }
        }
        long endTime=System.currentTimeMillis();

        new ListViewer(results).display();

        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}

