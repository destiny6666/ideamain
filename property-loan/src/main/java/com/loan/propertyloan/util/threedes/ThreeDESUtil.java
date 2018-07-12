package com.loan.propertyloan.util.threedes;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;


public class ThreeDESUtil {
    public static final String KEY = "cf410f84904a44cc8a7f48fc4134e8f9";
    public static final boolean ISENABLED=true;

    /**
     * DESCBC加密
     *
     * @param src
     *            数据源
     * @param key
     *            密钥，长度必须是8的倍数
     * @return 返回加密后的数据 Base64编码
     * @throws Exception
     */
    // 3DESECB加密,key必须是长度大于等于 3*8 = 24 位
    public static String encryptThreeDESECB(final String src, final String key) throws Exception {
        final DESedeKeySpec dks = new DESedeKeySpec(key.getBytes("UTF-8"));
        final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        final SecretKey securekey = keyFactory.generateSecret(dks);

        final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, securekey);
        final byte[] b = cipher.doFinal(src.getBytes());
        
        String res=Base64.getEncoder().encodeToString(b);

        return res;

    }

    /**
     * DESCBC解密
     *
     * @param src
     *            加密之后的数据
     * @param key
     *            密钥，长度必须是8的倍数
     * @return 明码
     * @throws Exception
     */
    // 3DESECB解密,key必须是长度大于等于 3*8 = 24 位
    public static String decryptThreeDESECB(final String src, final String key) throws Exception {
        // --通过base64,将字符串转成byte数组
       //final byte[] bytesrc = Base64.getDecoder().decode(src);
       final byte[] bytesrc=Base64.getMimeDecoder().decode(src);
    	
    	//byte[] bytesrc=src.getBytes();
    	
        // --解密的key
        final DESedeKeySpec dks = new DESedeKeySpec(key.getBytes("UTF-8"));
        final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        final SecretKey securekey = keyFactory.generateSecret(dks);

        // --Chipher对象解密
        final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, securekey);
        final byte[] retByte = cipher.doFinal(bytesrc);

        return new String(retByte);
    }
    
    public static void main(String[] args) throws Exception {
        final String key = ThreeDESUtil.KEY;
        // 加密流程
        String telePhone = "{\"id\":29}";
       // telePhone_encrypt = ThreeDESUtil.encryptThreeDESECB(URLEncoder.encode(telePhone, "UTF-8"), key);
        String telePhone_encrypt2=ThreeDESUtil.encryptThreeDESECB(telePhone, key);
        System.out.println(telePhone_encrypt2);
        
        // 解密流程
        String tele_decrypt = ThreeDESUtil.decryptThreeDESECB("8hd/SyOpCYD/rL5I9g45IQ==", key);
        System.out.println("模拟代码解密:" + tele_decrypt);
    }

}