package com.loan.authenticationservice.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class CardIdCheck {
	public static Map<String,Object> isLegal(String name,String cardNo) throws IOException {
		Map<String,Object> map=new HashMap<String,Object>();
		boolean result = false;
		String resCode="";
		String pathUrl = "http://192.168.100.50:18888/creditZX/pengyuan/PersonInfo";
		String s = sendPost(pathUrl,
				"name="+name+"&documentNo="+cardNo+"&queryReasonID=101&refID="+getRandomString(20)+"&returnStyle=xml;html;pdfsingle");
		System.out.println(s);
		JSONObject jo= JSON.parseObject(s);
		boolean isSuccess=jo.getBoolean("status");
		if(isSuccess){
			resCode=JSON.parseObject(jo.get("PersonInfoQueryResult").toString()).getString("result");
			if(resCode.equals("1")){
				result=true;
			}
			else{
				result=false;
			}
		}
		else{
			result=false;
		}
		map.put("result", result);
		map.put("resCode", resCode);
		return map;
	}
	public static String getRandomString(int length) { //length表示生成字符串的长度  
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 }  
	public static String sendGet(String url, String param) {
		String result = "";
		try {
			String urlName = url + "?" + URLEncoder.encode(param);//
			URL U = new URL(urlName);
			HttpURLConnection connection = (HttpURLConnection)U.openConnection();
			connection.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			in.close();
		} catch (Exception e) {
//			System.out.println("Helloword！！" + e);
			e.printStackTrace();
		}
		return result;
	}

	public static String sendPost(String url, String param) throws IOException {
		String result = "";
//		try {
			URL httpurl = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) httpurl.openConnection();
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			PrintWriter out = new PrintWriter(httpConn.getOutputStream());
			out.print(param);
			out.flush();
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			in.close();
//		} catch (Exception e) {
////			System.out.println("Helloword！" + e);
//			e.printStackTrace();
//		}
		return result;
	}

	public static void main(String[] args) throws IOException {
//		System.out.println(isLegal("杨博尧", "612722198405293576").toString());
		System.out.println(isLegal("贾钰琴", "14232719910504174X").toString());
//		String s=sendGet("http://192.168.100.50:18888/creditZX/pengyuan/PersonInfo", "name=贾玉清&documentNo=14232719910504174X&queryReasonID=101&refID=n3cje0gotsv6bkg7byst&returnStyle=xml");
//		System.out.println(s);
	}
}
