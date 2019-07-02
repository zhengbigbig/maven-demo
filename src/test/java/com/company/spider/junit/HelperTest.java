package com.company.spider.junit;

import org.easymock.EasyMockSupport;
import org.junit.Test;

import java.io.File;
import java.io.IOException;


public class HelperTest extends EasyMockSupport {
    @Test
    public void shouldCopy() throws IOException{
        File input = new File("src/test/resources/input.txt");
        File output = new File("src/test/resources/output.txt");

        Helper.copy(input,output);
    }

}
