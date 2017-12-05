package com.zheng.friend.rpc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring/applicationContext-provider.xml","classpath:/META-INF/spring/applicationContext-jdbc.xml"})
public class ApiTest {



    @Test
    public void test01(){
        System.out.println("第一个测试方法*******");
    }


}
