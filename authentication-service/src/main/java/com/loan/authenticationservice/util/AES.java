package com.loan.authenticationservice.util;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 *
 */
public class AES {
	private static final Logger logger = LoggerFactory.getLogger(AES.class);
	private static final String key="Y&s@d#P$34&#$g%^#!@$%&^%2$FH%SRf";
	private static final String defaultCharse="UTF-8";
	public static final String ALGORITHM = "AES";
	
    // 加密
    public static String Encrypt(String sSrc) throws Exception {
        if (key == null) {
        	logger.info("Key为空null");
            return null;
        }
        // 判断Key是否为32位
        if (key.length() != 32) {
        	logger.info("Key长度不是32位");
            return null;
        }
        byte[] raw = key.getBytes(defaultCharse);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM);//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(defaultCharse));
        return new Base64().encodeToString(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    public static String Decrypt(String sSrc) throws Exception {
        try {
        	 if (key == null) {
             	logger.info("Key为空null");
                 return null;
             }
             // 判断Key是否为32位
             if (key.length() != 32) {
             	logger.info("Key长度不是32位");
                 return null;
             }
            byte[] raw = key.getBytes(defaultCharse);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,defaultCharse);
                return originalString;
            } catch (Exception e) {
            	e.printStackTrace();
            	logger.info(e.toString());
                return null;
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        	logger.info(ex.toString());
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        /*
         * 此处使用AES-256-ECB加密模式，key需要为32位。
         */
        // 需要加密的字串
        String cSrc = "{\"IsBlackUser\":true,\"Msg\":\"身份证：522723199309210012 的客户为车贷业务黑名单：敏感客户类型\",\"OtherData\":\"rererewrewrewwrwerewrewrwr\"}";
        System.out.println(cSrc);
        // 加密
        String enString = AES.Encrypt(cSrc);
        System.out.println("加密后的字串是：" + enString);

        // 解密
        enString="BS/YZ08kmU050Eozny/lEAgNHgrRBIikkEcwOyjFMsDiHaux4UwfAQ/rxK13/5LD5TTDtx7yyMntDsBIVWOws28yKn0JaTYAhqjrHoT0KpnMEckhIHYx/4m+E8eAt5jmpax+MQsITVhHikjPDDbyaYkQhMRItcRS8eF5f5wKSlXliRLhQNmyMN//Z/MdQs5vsM9ADKS9sIpRhJN4wIUWxA==";
        String DeString = AES.Decrypt(enString);
//        String DeString="BS/YZ08kmU050Eozny/lEAgNHgrRBIikkEcwOyjFMsDiHaux4UwfAQ/rxK13/5LD5TTDtx7yyMntDsBIVWOws28yKn0JaTYAhqjrHoT0KpnMEckhIHYx/4m+E8eAt5jmpax+MQsITVhHikjPDDbyaYkQhMRItcRS8eF5f5wKSlXliRLhQNmyMN//Z/MdQs5vsM9ADKS9sIpRhJN4wIUWxA==";
        System.out.println("解密后的字串是：" + DeString);
    }
}

