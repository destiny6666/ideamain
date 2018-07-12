package com.loan.propertyloan.interceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loan.propertyloan.util.threedes.ThreeDESUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
@Component
public class LoanInterceptor implements HandlerInterceptor{
	@Value("${isProduct}")
	private String isProduct;
	private Logger log=LoggerFactory.getLogger(LoanInterceptor.class);
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object o, Exception e)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object o, ModelAndView model)
			throws Exception {

	}
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {
		// 获得在下面代码中要用的request,response,session对象
		String ciphertext = "";
		System.out.println("加密:  "+req.getParameter("ciphertext"));
		if (req.getParameter("ciphertext") != null) {
			ciphertext = req.getParameter("ciphertext").toString().replace(" ", "+");
		}
		log.info("加密参数"+ciphertext);
		log.info("访问路径："+req.getServletPath());
		log.info("访问IP："+req.getRemoteAddr());
		String res = ThreeDESUtil.decryptThreeDESECB(ciphertext, ThreeDESUtil.KEY);
		if (isProduct.equals("false")) {
			log.info("解密后参数：" + res);
		}
		resp.setContentType("application/json;charset=utf-8");
		String path = req.getRequestURI();
		//把解密数据setAttribute
		req.setAttribute("ciphertext", res);
		String xEquipment = req.getHeader("X-Equipment");;
		System.out.println("请求头:  "+xEquipment);
		log.info("请求头"+xEquipment);
		//对api页面进行过滤
		if(req.getServletPath().indexOf("v2")>=0||req.getServletPath().indexOf("swagger")>=0||req.getServletPath().indexOf("/webjars")>=0||req.getServletPath().indexOf("/errorRequest")>=0||req.getServletPath().indexOf("html")>=0||req.getServletPath().indexOf("loanArticle")>=0){
					return true;
		}
		//如果是生产模式的话，对请求进行拦截
		else if(isProduct.equals("true")){
			if (xEquipment != null) {
				if (xEquipment.indexOf("/ifsage") > 0) {
					return true;
				} else {
					resp.sendRedirect("/creditAPP/errorRequest");
					return false;
				}
			} else {
				resp.sendRedirect("/creditAPP/errorRequest");
				return false;
			}
		}
		//如果是开发、test模式的话，不进行拦截，方便开发人员进行测试
		else{
			return true;
		}
	}
}
