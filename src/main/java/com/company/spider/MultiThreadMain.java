package com.company.spider;

import com.company.spider.activiy.SpiderThread;
import com.company.spider.model.NewsWithRelated;
import com.company.spider.model.SearchSate;
import com.company.spider.model.UrlNewsReader;
import com.company.spider.view.ListViewer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MultiThreadMain {

    // 本地存储新闻内容，如何在终端显示

    // 1. 抽象出 对象
    // 2. 设计 对象应该具有的属性，状态和行为
    // 3. 思考 对象之间交互
    // 4. 开始写代码

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();

        // 广度优先搜索
        SearchSate searchSate = new SearchSate(10);

        String startUrl = "https://readhub.me/topic/5bMmlAm75lD";
        NewsWithRelated startNews = UrlNewsReader.read(startUrl);

        searchSate.visit(startNews); // 起始搜索点放到队列里
        while (searchSate.hasTarget()) {
            NewsWithRelated current = searchSate.poll();

            // 把当前页面
            searchSate.addResult(current);
            List<SpiderThread> spiders = new ArrayList<SpiderThread>();

            // 处理相关页面
            for (Map.Entry<String, String> entry : current.getRelateds().entrySet()) {
                String url = entry.getValue();
                // 创建线程去把页面爬下来，然后更新queue 和 visited
                spiders.add(new SpiderThread(searchSate, url));
            }

            //等待所有线程完成页面的读取
            for (SpiderThread spider : spiders) {
                spider.join();  // 等待这个线程运行完成  使用join方法进行线程合并
            }
        }
        long endTime=System.currentTimeMillis();

        new ListViewer(searchSate.getResults()).display();

        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}
