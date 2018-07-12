package com.loan.authenticationservice.util;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.codec.Hex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;



public class HttpRequest {  
	private static final Logger logger = LoggerFactory.getLogger(HttpRequest.class);
    /** 
     * 向指定URL发送GET方法的请求 
     *  
     * @param url 
     *            发送请求的URL 
     * @param param 
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。 
     * @return URL 所代表远程资源的响应结果 
     */  
    public static String sendGet(String url, String param) {  
        String result = "";  
        BufferedReader in = null;  
        try {  
            String urlNameString = url + "?" + param;  
            URL realUrl = new URL(urlNameString);  
            // 打开和URL之间的连接  
            URLConnection connection = realUrl.openConnection();  
            // 设置通用的请求属性  
            connection.setRequestProperty("accept", "*/*");  
            connection.setRequestProperty("connection", "Keep-Alive");  
            connection.setRequestProperty("user-agent",  
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");  
            // 建立实际的连接  
            connection.connect();  
            // 获取所有响应头字段  
            Map<String, List<String>> map = connection.getHeaderFields();  
            // 遍历所有的响应头字段  
            for (String key : map.keySet()) {  
                System.out.println(key + "--->" + map.get(key));  
            }  
            // 定义 BufferedReader输入流来读取URL的响应  
            in = new BufferedReader(new InputStreamReader(  
                    connection.getInputStream()));  
            String line;  
            while ((line = in.readLine()) != null) {  
                result += line;  
            }  
        } catch (Exception e) {  
            System.out.println("发送GET请求出现异常！" + e);  
            e.printStackTrace();  
        }  
        // 使用finally块来关闭输入流  
        finally {  
            try {  
                if (in != null) {  
                    in.close();  
                }  
            } catch (Exception e2) {  
                e2.printStackTrace();  
            }  
        }  
        return result;  
    }  
  
    /**  
     * 向指定 URL 发送POST方法的请求  
     * @param url 发送请求的 URL  
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。  
     * @return 所代表远程资源的响应结果  
     */  
    public static String sendPost(String url, String param) {  
        PrintWriter out = null;  
        BufferedReader in = null;  
        String result = "";  
        try {  
            URL realUrl = new URL(url);  
            // 打开和URL之间的连接  
            URLConnection conn = realUrl.openConnection();  
            // 设置通用的请求属性  
            conn.setRequestProperty("accept", "*/*");  
            conn.setRequestProperty("connection", "Keep-Alive");  
            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");  
            // 发送POST请求必须设置如下两行  
            conn.setDoOutput(true);  
            conn.setDoInput(true);  
            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
            String timestamp=sdf.format(new Date());
            

            conn.setRequestProperty("Timestamp",timestamp);
            conn.setRequestProperty("Sign", getSHAtr("Car$%@!&*%^8523:"+timestamp));
            //1.获取URLConnection对象对应的输出流  
            out = new PrintWriter(conn.getOutputStream());  
            //2.中文有乱码的需要将PrintWriter改为如下  
            //out=new OutputStreamWriter(conn.getOutputStream(),"UTF-8")  
            // 发送请求参数  
            out.print(param);  
            // flush输出流的缓冲  
            out.flush();  
            // 定义BufferedReader输入流来读取URL的响应  
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));  
            String line;  
            while ((line = in.readLine()) != null) {  
                result += line;  
            }  
        } catch (Exception e) {  
            System.out.println("发送 POST 请求出现异常！"+e);  
            e.printStackTrace();  
        }  
        //使用finally块来关闭输出流、输入流  
        finally{  
            try{  
                if(out!=null){  
                    out.close();  
                }  
                if(in!=null){  
                    in.close();  
                }  
            }  
            catch(IOException ex){  
                ex.printStackTrace();  
            }  
        }  
        System.out.println("post推送结果："+result);  
        return result;  
    }  
    /***
     *  利用Apache的工具类实现SHA-256加密
     * @param str 加密后的报文
     * @return
     */
    public static String getSHAtr(String str){
        MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA");
            byte[] hash = messageDigest.digest(str.getBytes());
            encdeStr = Hex.encode(hash).toString();//encodeHexString(hash)
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        return encdeStr;
    }
    //返回结果进行解密返回data值
    public static String getData(String url, String param) throws Exception{
    	String result=HttpRequest.sendPost(url, param);  
    	logger.info("后台接口获取数据："+result);
		JSONObject jo1= JSON.parseObject(result);
		if(jo1.getBoolean("success")){
			String data=jo1.getString("data");
			String DeString = AES.Decrypt(data);
			return DeString;}
		return null;
    }
    public static void main(String[] args) throws Exception {  
        //发送 GET 请求  
//        String s=HttpRequest.sendGet("http://192.168.100.29:8888/creditAPP/core/index/getActiveMessage", "ciphertext=k7C5BYI8DGbaXeMWRn6C6w==");  
//        System.out.println(s);  
//          
//        //发送 POST 请求  
//        String sr=HttpRequest.sendPost("http://192.168.100.161:8888/creditAPP/core/index/getActiveMessage", "ciphertext=k7C5BYI8DGbaXeMWRn6C6w==");  
        String sr=HttpRequest.getData("http://192.168.100.39:8026/Api/AppService/UserIsBlackList", "idNum=511124198910230010");  
        System.out.println(sr);
    }  
} 