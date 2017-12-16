package com.zheng.friend.rpc.test;

import com.zheng.friend.dao.model.FUserBaseMsg;
import com.zheng.friend.dao.model.FUserRequest;
import com.zheng.friend.dao.model.FUserViewRecord;
import com.zheng.friend.dao.vo.FUserViewRecordVo;
import com.zheng.friend.dao.vo.FuserDetailVo;
import com.zheng.friend.rpc.api.FUserBaseMsgService;
import com.zheng.friend.rpc.api.FUserViewRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring/applicationContext-provider.xml","classpath:/META-INF/spring/applicationContext-jdbc.xml"})
public class ApiTest {

    @Autowired
    FUserBaseMsgService fUserBaseMsgService;
    @Autowired
    FUserViewRecordService fUserViewRecordService;
    @Test
    public void test01(){

//
//        List<FUserViewRecordVo> userList = fUserBaseMsgService.selectViewRecordUsers(6);
//        if(null!=userList){
//            for(int i=0;i<userList.size();i++){
//                System.out.println(userList.get(i).getFwUserBaseMsg().getNikename());
//            }
//        }
//        System.out.println(vo.getUserId());
//        System.out.println(vo.getLastLoginTime());
        FUserBaseMsg record = new FUserBaseMsg();

        record.setUserId(9);
        record.setHeight(162.5f);
        fUserBaseMsgService.insert(record);


        // record.setViewTime(new Date());
     //   fUserViewRecordService.insertSelective(record);
    }


}
