package com.loan.authenticationservice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import authentication.UserBaseInfoServiceAPI;
import authentication.entity.UserBaseInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.loan.authenticationservice.service.UserBaseInfoService;
import com.loan.authenticationservice.util.CardIdCheck;
import com.loan.authenticationservice.util.HttpRequest;
import com.loan.authenticationservice.util.RabbitMQ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import returnUtil.ReturnEntityUtils;

@RestController
public class UserBaseInfoController implements UserBaseInfoServiceAPI {
	@Resource//12321234
	private UserBaseInfoService userBaseInfoService;
	@Resource
	private RabbitMQ rabbitMQ;
	//123
	@Value("${carServerUrl}")
	private String carServerUrl;
	private Logger log=LoggerFactory.getLogger(UserBaseInfoController.class);
	@Override
	public String  getAuthenticationStatus(HttpServletRequest request, HttpServletResponse response, Integer userId) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		if(userId!=null&&userId!=0){
				UserBaseInfo userBaseInfo = userBaseInfoService.loadById(userId);
				if(userBaseInfo.getCardIsEnd()!=null){
					map.put("cardIsEnd", userBaseInfo.getCardIsEnd());
				}
				else{
					map.put("cardIsEnd", false);
				}
				if(userBaseInfo.getContactIsEnd()!=null){
					map.put("contactIsEnd", userBaseInfo.getContactIsEnd());
				}
				else{
					map.put("contactIsEnd", false);
				}
				if(userBaseInfo.getWorkIsEnd()!=null){
					map.put("workIsEnd", userBaseInfo.getWorkIsEnd());
				}
				else{
					map.put("workIsEnd", false);
				}
				if(userBaseInfo.getBankIsEnd()!=null){
					map.put("bankIsEnd", userBaseInfo.getBankIsEnd());
				}
				else{
					map.put("bankIsEnd", false);
				}
				if(userBaseInfo.getPhoneIsEnd()!=null){
					map.put("phoneIsEnd", userBaseInfo.getPhoneIsEnd());
				}
				else{
					map.put("phoneIsEnd", false);
				}
			}
		else{
			map.put("cardIsEnd", false);
			map.put("contactIsEnd", false);
			map.put("workIsEnd", false);
			map.put("bankIsEnd", false);
			map.put("phoneIsEnd", false);
		}
		return JSON.toJSONString(ReturnEntityUtils.SUCCESS_RETURN.put(map));
	}
	@Override
	public String getUserById(HttpServletRequest request, HttpServletResponse response,Integer userId) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
			if(userId!=null&&userId!=0){
				UserBaseInfo userBaseInfo = userBaseInfoService.loadById(userId);
				userBaseInfo.setSalt(null);
				userBaseInfo.setPassword(null);
				map.put("user", userBaseInfo);
		}
		String result=JSON.toJSONString(ReturnEntityUtils.SUCCESS_RETURN.put(map));
			return result;
	}
	@Override
	public String  updateCardId(HttpServletRequest request, HttpServletResponse response,UserBaseInfo ubi,boolean isProduct) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		ubi.setSex(checkSex(ubi.getCardId()));
		String xEquipment = request.getHeader("X-Equipment");
		if (xEquipment != null) {
			if (xEquipment.indexOf("IOS/ifsage") > 0){
				ubi.setUserOrigin(3);
			}
			else if(xEquipment.indexOf("Android/ifsage") > 0){
				ubi.setUserOrigin(4);
			}
		}
			UserBaseInfo userBaseInfo = userBaseInfoService.loadById(ubi.getId());
			try {
				ubi.setCardIsEnd(true);
				userBaseInfoService.update(UserBaseInfo.merge(userBaseInfo, ubi));
				//判断是否为黑名单用户
				String data=HttpRequest.getData(carServerUrl+"/UserIsBlackList", "idNum="+ubi.getCardId());
				if(!isProduct){
					log.info("后台接口解密后:"+data);
				}
				if(data!=null){
					JSONObject jo2=JSON.parseObject(data);
					Boolean isBlack=jo2.getBoolean("IsBlackUser");
					if(isBlack){
						map.put("isBlack", true);
					}
					else{
						map.put("isBlack", false);
					}
					map.put("success", true);	
				}
				else{
					map.put("success", false);
				}
			} catch (Exception e) {
				// TODO: handle exception
				map.put("success", false);
			}
			return JSON.toJSONString(ReturnEntityUtils.SUCCESS_RETURN.put(map));
	}
	@Override
	public String  updateContactMessage(HttpServletRequest request, HttpServletResponse response,UserBaseInfo ubi1) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		UserBaseInfo ubi2 = userBaseInfoService.loadById(ubi1.getId());
		UserBaseInfo userBaseInfo = UserBaseInfo.merge(ubi2, ubi1);
		try {
			userBaseInfo.setContactIsEnd(true);
			userBaseInfoService.update(userBaseInfo);
			map.put("success", true);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("success", false);
		}
		return JSON.toJSONString(ReturnEntityUtils.SUCCESS_RETURN.put(map));
	}
	@Override
	public String updateWorkMessage(HttpServletRequest request, HttpServletResponse response,UserBaseInfo ubi1) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		UserBaseInfo ubi2 = userBaseInfoService.loadById(ubi1.getId());
		UserBaseInfo userBaseInfo = UserBaseInfo.merge(ubi2, ubi1);
		try {
			ubi2.setWorkIsEnd(true);
			userBaseInfoService.update(userBaseInfo);
			map.put("success", true);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("success", false);
		}
		return JSON.toJSONString(ReturnEntityUtils.SUCCESS_RETURN.put(map));
	}
	@Override
	public String  checkCardIsLegal(HttpServletRequest request, HttpServletResponse response, String jsonString,boolean isProduct) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		if (isProduct) {
			JSONObject jo = JSON.parseObject(jsonString);
			String username = jo.getString("name");
			String cardId = jo.getString("cardId");
			Map<String, Object> m = CardIdCheck.isLegal(username, cardId);
			boolean result = (boolean) m.get("result");
			if (result) {
				map.put("isLegal", true);
			} else {
				map.put("isLegal", false);
				map.put("reason", "姓名与身份证号不符");
			}
		}
		else{
			//測試：
			map.put("isLegal", true);
		}
		return JSON.toJSONString(ReturnEntityUtils.SUCCESS_RETURN.put(map));
	}
	@Override
	public String  toChinaMobile(HttpServletRequest request, HttpServletResponse response, Integer userId,String taskId) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
			//手机认证成功
			UserBaseInfo ubi=userBaseInfoService.loadById(userId);
			ubi.setIsEnd(1);
			ubi.setPhoneIsEnd(true);
			userBaseInfoService.update(ubi);
			//认证通过
			userBaseInfoService.updatePhoneReportUrl(userId, "https://portal.shujumohe.com/nolayout/customerReport/"+taskId);
			//推送信息
			String beanName="com.loan.rabbit.task.ChinaMobile";
			String methodName="chinaMobileV3";//调用的方法
			//参数
			// Map<String,Object> param=new HashMap<String, Object>();
			String param="{\"taskId\":\""+taskId+"\",\"userId\":"+userId+"}";
			rabbitMQ.pushMessageToMQ(beanName, methodName, param);
			return JSON.toJSONString(ReturnEntityUtils.SUCCESS_RETURN.put(map));
	}
	//true:男  false：女
	public boolean checkSex(String cardId){
		boolean sexr=true;
		String sex = cardId.substring(16, 17);
		if(Integer.parseInt(sex)%2==0){
			sexr = false;
		}
		return sexr;
	}
}
