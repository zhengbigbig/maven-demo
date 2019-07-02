//package com.company.spider.model;
//// 测试用例应该是在一个包里
//// private
//// 空:default -- 同一个包里面
//// public
//
//import org.easymock.EasyMockSupport;
//import static org.easymock.EasyMock.expect;
//import static org.junit.Assert.assertEquals;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import java.io.*;
//
//
//public class JsonNewsTestableReaderTest extends EasyMockSupport {
//    private TextNewsTestableReader textNewsTestableReader;
//    private BufferedReader newsReader;
//
//    // 初始化创建对象
//    @Before
//    public void setup(){
//        newsReader = createStrictMock(BufferedReader.class);
//        textNewsTestableReader = new TextNewsTestableReader(newsReader);
//    }
//
//    // 注解  用到这个注解junit框架运行测试时候将会运行这段逻辑
//    // 为每一个方法的可能调用例子写一个测试！
//    @Test
//    public void shouldReadNews() throws Exception{
//        // 创建我们需要测试的类的对象，然后传入输入，检查相应的结果是否符合预期
//        expect(newsReader.readLine()).andReturn("title");
//        expect(newsReader.readLine()).andReturn("\n");
//        expect(newsReader.readLine()).andReturn("content");
//
//        replayAll();
//        News news = textNewsTestableReader.readNews();
//        verifyAll();
//
//        assertEquals("title",news.getTitle());
//        assertEquals("content",news.getContent());
//    }
//
//    @After
//    public void teardown(){
//        // 清理一个测试的副作用
//    }
//}
