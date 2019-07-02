package com.company.spider.junit;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;

import static org.easymock.EasyMock.expect;


public class TestableHelperTest extends EasyMockSupport {

    private BufferedInputStream in;
    private File des;

    @Before
    public void setup(){
        in = createStrictMock(BufferedInputStream.class);
        des = new File("src/test/resources/output2.txt");
    }

    @Test
    public void shouldCopy() throws IOException {

        byte[] buf = new byte[512];

        expect(in.read(buf)).andReturn(10);
        expect(in.read(buf)).andReturn(10);
        expect(in.read(buf)).andReturn(-1);

        replayAll();

        TestableHelper.copy(in, des);

        verifyAll();
    }
}