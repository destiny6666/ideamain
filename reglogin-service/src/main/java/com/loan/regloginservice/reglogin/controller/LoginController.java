package com.loan.regloginservice.reglogin.controller;

import com.alibaba.fastjson.JSON;
import com.loan.regloginservice.reglogin.entity.UserBaseInfo;
import com.loan.regloginservice.reglogin.service.UserBaseInfoService;
import com.loan.regloginservice.reglogin.util.CookieUtil;
import com.loan.regloginservice.reglogin.util.PasswordUtil;
import org.springframework.web.bind.annotation.RestController;
import reglogin.LoginSerivce;
import returnUtil.ReturnEntityUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

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
public class LoginController implements LoginSerivce {
	@Resource
	private UserBaseInfoService userBaseInfoService;
	@Override
	public String  loginCheck(String phonenum,String password,HttpServletRequest req, HttpServletResponse resp) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		String result="";
		if (("".equals(phonenum) || phonenum == null) || ("".equals(password) || password == null)) {
			result=JSON.toJSONString(ReturnEntityUtils.ERROR_RETURN.set("参数错误"));
			return result;
		}
		String message = "";
		// 如果此用户存在
		if (userBaseInfoService.loadByPhoneNum(phonenum) != null) {
			// 数据库所对应用户
			UserBaseInfo u = userBaseInfoService.loadByPhoneNum(phonenum);
			// 未激活
			if (("".equals(u.getSalt()) && "".equals(u.getPassword()))
					|| (u.getSalt() == null && u.getPassword() == null)) {
				message = "通过门店办理借款的用户，请激活账号";
				result=JSON.toJSONString(ReturnEntityUtils.ERROR_RETURN.set(message));
			}
			// 用户已激活
			else {
				String checkPassword = PasswordUtil.getPasswordBySalt(u.getSalt(), password);// 输入密码加密结果
				// 判断加密结果与数据库中的password是否一致
				if (checkPassword.equals(u.getPassword())) {// 一致
					//设置Cookie
					CookieUtil.setCookie(u.getId(), req, resp);
					
//					map.put("userType", 2);
					message = "登录成功！";
					map.put("isSuccess", true);
					map.put("message", message);
					map.put("userId", u.getId());
					map.put("userPhone", u.getPhoneNum());
					map.put("cardIsEnd", u.getCardIsEnd());
					result=JSON.toJSONString(ReturnEntityUtils.SUCCESS_RETURN.put(map));
				} else {// 不一致
					message = "账号或密码错误，请重新输入~";
					result=JSON.toJSONString(ReturnEntityUtils.ERROR_RETURN.set(message));
				}
			}

		}
		// 如果此用户不存在
		else {
			message = "该手机号码未注册，请先注册";
			result=JSON.toJSONString(ReturnEntityUtils.ERROR_RETURN.set(message));
		}
		return result;
	}
}
