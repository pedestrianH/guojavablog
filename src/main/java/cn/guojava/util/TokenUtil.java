package cn.guojava.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;


public class TokenUtil {
    //设置token的SIGN
    private static String SIGN = "!FYDTKI%";
//    "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTcxNzUzNzEsInVzZXJJZCI6MTEwLCJ1c2VybmFtZSI6Imd1b2phdmEifQ.SKR7_3bGMhnSyD9H5Wf43r8av0RahnJUOLWsbViGt70"
//生成token
    public static String getToken(Integer userId,String username){
        Calendar calendar =  Calendar.getInstance();
        calendar.add(Calendar.HOUR,1);
        String sign = JWT.create()
                .withClaim("userId", userId)
                .withClaim("username", username)
                .withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(SIGN));


        return sign;
    }
    //验证token
    public static void verify(String token){
        JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }
    //查询token
    public static DecodedJWT getTokenTnfo(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);

        return verify;
    }
}
