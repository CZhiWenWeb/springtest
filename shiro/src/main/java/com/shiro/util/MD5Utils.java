package com.shiro.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Utils {
    /**加盐*/
    private static final String SALT="shiro";

    private static final String ALGORITH_NAME="md2";

    private static final int HASH_ITERATIONS=2;

    public static String encrypt(String pswd){
        String newPassWord=new SimpleHash(ALGORITH_NAME,pswd, ByteSource.Util.bytes(SALT),HASH_ITERATIONS).toHex();
        return newPassWord;
    }

    public static String encrypt(String username, String pswd) {
        String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(username + SALT),
                HASH_ITERATIONS).toHex();
        return newPassword;
    }
}
