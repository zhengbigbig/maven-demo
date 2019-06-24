package com.company;

public abstract class NewsReader {

    public News readNews(String path){
        System.out.println("来自父类");
        return null;
    }
    // 具有这个功能  但具体的实现，在子类中确定

    // 1.文件、类
    // 纯文本、word、json、xml ->类
    // 2.网络  url-> 类
    // 3.标准输入 -> 类
    // 4.语音识别 -> 类

    //不同的 reader

}
