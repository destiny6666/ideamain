package com.loan.regloginservice.reglogin.util;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class PasswordUtil{
    //密码重置
    public static Map<String,String> getPassword(String password){
        String passSalt = getPassSalt();
        String enpassword = hexMD5(password + passSalt).toUpperCase();
        Map<String,String> map=new HashMap<String,String>();
        map.put("passSalt", passSalt);
        map.put("password", enpassword);
        return map;
    }
    public static String getPasswordBySalt(String salt,String password){
    	return hexMD5(password + salt).toUpperCase();
    }
    public  static String hexMD5(String s) {
        //16进制下数字到字符的映射数组
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getPassSalt() {
        String[] code = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String result = "";
        for (int i = 0; i < 8; i++) {
            Random random = new Random(UUID.randomUUID().hashCode());
            result += code[random.nextInt(62)];
        }
        return result;
    }
}
