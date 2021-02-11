//package com.myblog.blog.util;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTCreator;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//
//import java.util.Calendar;
//import java.util.Map;
//
//
//
//
//public class JWTUtils {
//    // 盐值
//    private static String TOKEN = "huangqin❤";
//
//    public static String getToken(Map<String, String> map) {
//        JWTCreator.Builder builder = JWT.create();
//        map.forEach((k, v) -> {
//            builder.withClaim(k, v);
//        });
//        // 指定7天过期
//        Calendar instance = Calendar.getInstance();
//        instance.add(Calendar.DATE, 7);
//        builder.withExpiresAt(instance.getTime());
//        return builder.sign(Algorithm.HMAC256(TOKEN)).toString();
//    }
//
//    public static void verify(String token) {
//        JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
//    }
//
//    public static DecodedJWT getUsername(String token) {
//        return JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
//    }
//}
