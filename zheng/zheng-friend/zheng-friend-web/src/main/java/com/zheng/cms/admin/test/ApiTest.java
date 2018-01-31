package com.zheng.cms.admin.test;

import com.zheng.cms.admin.util.SmsUtil;
import com.zheng.friend.dao.model.FUserBaseMsg;
import com.zheng.friend.dao.model.FUserViewRecord;
import com.zheng.friend.dao.vo.FUserViewRecordVo;
import com.zheng.friend.rpc.api.FUserBaseMsgService;
import com.zheng.friend.rpc.api.FUserViewRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dubbo-consumer.xml"})
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
////        System.out.println(vo.getUserId());
////        System.out.println(vo.getLastLoginTime());
//        FUserViewRecord record = new FUserViewRecord();
//
//        record.setfUserId(5);
//        record.setbUserId(6);
//
//        fUserViewRecordService.insert(record);


        // record.setViewTime(new Date());
     //   fUserViewRecordService.insertSelective(record);

        try {
            SmsUtil.getSMS("18825208133","9998");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
