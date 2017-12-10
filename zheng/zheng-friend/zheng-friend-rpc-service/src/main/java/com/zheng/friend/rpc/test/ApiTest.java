package com.zheng.friend.rpc.test;

import com.zheng.friend.dao.vo.FuserDetailVo;
import com.zheng.friend.rpc.api.FUserBaseMsgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring/applicationContext-provider.xml","classpath:/META-INF/spring/applicationContext-jdbc.xml"})
public class ApiTest {

    @Autowired
    FUserBaseMsgService fUserBaseMsgService;

    @Test
    public void test01(){

        FuserDetailVo vo = fUserBaseMsgService.selectFUserDetailVoByUserId(4);
        List<FuserDetailVo> userList = fUserBaseMsgService.selectRecommendUsers(vo,0,20);
        if(null!=userList){
            for(int i=0;i<userList.size();i++){
                System.out.println(userList.get(i).getfUserBaseMsg().getNikename());
            }
        }
        //System.out.println(vo.getUserId());
       // System.out.println(vo.getLastLoginTime());
    }


}
