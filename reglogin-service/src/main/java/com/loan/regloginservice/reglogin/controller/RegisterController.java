package com.loan.regloginservice.reglogin.controller;

import com.alibaba.fastjson.JSON;
import com.loan.regloginservice.reglogin.entity.UserBaseInfo;
import com.loan.regloginservice.reglogin.service.PasswordService;
import com.loan.regloginservice.reglogin.service.UserBaseInfoService;
import org.springframework.web.bind.annotation.RestController;
import reglogin.RegisterService;
import returnUtil.ReturnEntityUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static com.loan.regloginservice.reglogin.util.CookieUtil.setCookie;

/**
 * 
* <b>描述:</b>登录注册
* <br><b>作者:</b> 刘洪宇
* <br><b>版本:</b>v2.0
* <br><b>ProjectName:</b> creditAPP
* <br><b>PackageName:</b> com.loan.core.controller
* <br><b>ClassName:</b> LoginController
* <br><b>Date:</b> 2017年10月19日 上午10:06:24
 */
@RestController
public class RegisterController implements RegisterService{
	@Resource
	private UserBaseInfoService userBaseInfoService;
	@Resource
	private PasswordService passwordService;
	@Override
	public String  register(String phonenum,String password, HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String result="";
		if (("".equals(phonenum) || phonenum == null) || ("".equals(password) || password == null)) {
			result=JSON.toJSONString(ReturnEntityUtils.ERROR_RETURN.set("参数错误"));
			return result;
		}
		
		if (userBaseInfoService.loadByPhoneNum(phonenum) == null) {
			UserBaseInfo userBaseInfo = new UserBaseInfo();
			userBaseInfo.setPhoneNum(phonenum);
			
			Map<String, String> map = passwordService.getPassword(password);// 获取加密后的密码，加密盐
			userBaseInfo.setSalt(map.get("passSalt"));
			userBaseInfo.setPassword(map.get("password"));
			userBaseInfoService.insert(userBaseInfo);
			
			//设置Cookie
			setCookie(userBaseInfo.getId(), req, resp);
			
			Map<String, Object> map1 = new HashMap<>();
			map1.put("isSuccess", "注册成功");
			map1.put("userId", userBaseInfo.getId());
			map1.put("userPhone", userBaseInfo.getPhoneNum());
			result=JSON.toJSONString(ReturnEntityUtils.SUCCESS_RETURN.put(map1));
		}else{
			result=JSON.toJSONString(ReturnEntityUtils.ERROR_RETURN.set("手机号已注册，请登录"));
		}
		return  result;
	}
}
