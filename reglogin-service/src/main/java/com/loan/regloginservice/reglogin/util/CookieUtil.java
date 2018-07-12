/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: CookieUtil
 * Author:   user
 * Date:     2018/7/10 16:19
 * Description: 登录注册所需cookie设置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.regloginservice.reglogin.util;

import com.alibaba.fastjson.JSON;
import threeDes.ThreeDESUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈登录注册所需cookie设置〉
 *
 * @author user
 * @create 2018/7/10
 * @since 1.0.0
 */
public class CookieUtil {
    //设置cookie
    public static void setCookie(Integer id, HttpServletRequest req, HttpServletResponse resp) throws Exception{
        // 保存当前用户id和请求头cookie
        String xEquipment = req.getHeader("X-Equipment");

        Map<String , Object> mapCookie = new HashMap<>();
        mapCookie.put("id", id);
        mapCookie.put("reqHeader", xEquipment);
        //cookie的json形式
        String cookieJSON = JSON.toJSONString(mapCookie);

        Cookie userCookie = new Cookie("sdfassdf123ewer",ThreeDESUtil.encryptThreeDESECB(cookieJSON, ThreeDESUtil.KEY));
        userCookie.setMaxAge(60*60*24*30*12);
        userCookie.setPath("/");
        resp.addCookie(userCookie);
    }
}