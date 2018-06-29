package com.zheng.cms.admin.util;

import com.zheng.common.util.RedisUtil;
import com.zheng.common.util.key.SnowflakeIdWorker;
import org.apache.shiro.session.Session;
import redis.clients.jedis.Jedis;

public class TokenUtil {



    // 局部会话key
    public final static String ZHENG_WX_CLIENT_SESSION_ID = "zheng-wx-client-session-id";
    // 单点同一个code所有局部会话key
    public final static String ZHENG_WX_CLIENT_SESSION_IDS = "zheng-wx-client-session-ids";

    /**
     * 通过appId和appsecret 获取OpenId
     * @param appId
     * @param appsecret
     * @param code
     * @return
     */
    public static String getOpenIdFromWx(String appId,String appsecret,String code){

        return "abcdefg";
    }


    /**
     * 获取token
     * @param openId
     * @return
     */
    public static String getTokenByOpenId(String openId){

        return "abcdef666";
    }



    public static String getToken(Session session,String userName){

        int timeOut = (int) session.getTimeout() / 1000;

        String createToken = CommonUtil.getRandomString(4);

        SnowflakeIdWorker idWorker0 = new SnowflakeIdWorker(1, 0);
        createToken = createToken + idWorker0.nextId();
        RedisUtil.set(ZHENG_WX_CLIENT_SESSION_ID + "_" + createToken, userName, timeOut);
        Jedis jedis = RedisUtil.getJedis();
        jedis.expire(TokenUtil.ZHENG_WX_CLIENT_SESSION_ID + "_" + createToken, timeOut);
        jedis.close();
        return  createToken;
    }
}
