package com.example.order.util;

import org.springframework.util.DigestUtils;

public class MD5 {

    public static String digest(String text,String key){
        byte[] keyBytes=(text+key).getBytes();
        String digest= DigestUtils.md5DigestAsHex(keyBytes);
        return digest;
    }

    public static boolean verify(String text,String key,String digest){

        String secrete =digest(text,key);
        if(secrete.equalsIgnoreCase(digest)){
            return true;
        }
        return false;
    }


}
