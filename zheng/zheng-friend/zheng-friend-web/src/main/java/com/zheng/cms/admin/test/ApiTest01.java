package com.zheng.cms.admin.test;

import com.zheng.friend.dao.vo.RecentMsgVo;
import com.zheng.friend.rpc.api.FMessageService;
import com.zheng.friend.rpc.api.FUserBaseMsgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dubbo-consumer.xml"})
public class ApiTest01 {

    @Autowired
    FUserBaseMsgService fUserBaseMsgService;
    @Autowired
    FMessageService fMessageService;


    @Test
    public void test01(){

//        FuserDetailVo vo = fUserBaseMsgService.selectFUserDetailVoByUserId(4);
//        List<FuserDetailVo> userList = fUserBaseMsgService.selectRecommendUsers(vo,0,20);
//        if(null!=userList){
//            for(int i=0;i<userList.size();i++){
//                System.out.println(userList.get(i).getfUserBaseMsg().getNikename());
//            }
//        }

       List<RecentMsgVo> list = fMessageService.selectMsgRecord(1,2);

        for(int i=0;i<list.size();i++){
                System.out.println(list.get(i).getId());
            }
        //System.out.println(vo.getUserId());
       // System.out.println(vo.getLastLoginTime());
    }


}
