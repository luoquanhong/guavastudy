package com;

import com.google.common.base.Joiner;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class JoinerTestClass {


    List<String> testList = null;

    Joiner globalJoinerWith = Joiner.on("&&");

    @Before
    public void setUp(){
        testList = Arrays.asList("red", "yellow", "green", "apple", "orange");
    }

    /**
     * Joiner的初步测试，运用其中的on的方法连接list
     */
    @Test
    public void testCase_Joiner(){
        String resultList = Joiner.on("#").join(testList);
        assertThat(resultList, equalTo("red#yellow#green#apple#orange")) ;
    }

    /**
     * 测试Joiner的append方法，使用StringBuilder作为承接, 连接的是list
     */
    @Test
    public void testCase_Joiner_Append(){
        StringBuilder sb = globalJoinerWith.appendTo(new StringBuilder(), testList);
        System.out.println(sb);
    }


    /**
     * 测试Joiner的append方法，使用StringBuilder作为承接, 连接的是array类型
     */
    @Test
    public void testCase_Joiner_AppendWithA(){
        Object[] parts = new Object[]{"red", "blue", 10, "yellow"};
        String[] strings = new String[]{"red", "blue", "black", "yellow"};
        StringBuilder sb = globalJoinerWith.appendTo(new StringBuilder(), parts);
        System.out.println(sb);
    }
}
