package com.loan.propertyloan.core.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.loan.propertyloan.core.service.LoanLoginService;
import com.loan.propertyloan.core.service.LoanRegService;
import com.loan.propertyloan.util.Descbc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>描述:</b>登录注册
 * <br><b>作者:</b> 刘洪宇
 * <br><b>版本:</b>v2.0
 * <br><b>ProjectName:</b> creditAPP
 * <br><b>PackageName:</b> com.loan.core.controller
 * <br><b>ClassName:</b> LoginController
 * <br><b>Date:</b> 2017年10月19日 上午10:06:24
 */
@Api(value = "RegController", tags = {"RegController"}, description = "注册")
@Controller
@RequestMapping("/reg")
public class RegController {
    @Resource
    private LoanRegService loanRegServicService;

    @RequestMapping(value="todo",method=RequestMethod.POST)
    @ApiOperation(value = "注册", httpMethod = "POST", notes =
            "	  描述:注册\r\n" +
                    "	  HTTP Method: POST \r\n" +
                    "	  接口地址:http://host:port/property-loan/login/register\r\n" +
                    "	  \r\n" +
                    "	  @param request\r\n" +
                    "	  @param response\r\n" +
                    "  	  @param ciphertext\r\n"+
                    "     3des加密后的{\"phoneNum\":\"手机号\",\"password\":\"密码\"}\r\n" +
                    "	  @throws IOException\r\n" +
                    "	      注册成功:\r\n" +
                    "	  \"remarks\": \"No remarks\" \r\n" +
                    "	  \"returnReason\": \"OK\" 成功 \r\n" +
                    "	  \"returnStatus\": 200 返回成功 \r\n" +
                    "	  \"returnTotal\": returnInformation的个数 \r\n" +
                    "	  \"returnInformation\": \r\n" +
                    "	  			{\r\n" +
                    "	 				\"isSuccess\":true\r\n" +
                    "	 				\"userId\":{用户id}\r\n" +
                    "	 				\"userPhone\":{用户手机号}\r\n" +
                    "	 			}\r\n" +
                    "	      注册失败:\r\n" +
                    "	  \"returnStatus\"=1\r\n" +
                    "  	  \"returnReason\"=\"错误信息\" \r\n" +
                    "  	  \"remarks\"=\"No remarks\" \r\n" +
                    "  	  \"returnTotal\"=0 \r\n" +

                    "	  Author:刘洪宇 \r\n" +
                    "	  Date: 2017年10月23日 下午3:34:56")
    public void register(String ciphertext, HttpServletRequest req, HttpServletResponse resp) throws Exception{
        resp.setContentType("application/json;charset=utf-8");
        String jsonString =req.getAttribute("ciphertext").toString();
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String phonenum = jsonObject.getString("phoneNum").replace(" ", "");
        String password = jsonObject.getString("password");
        String result = loanRegServicService.register( phonenum, password, req, resp);
        resp.getWriter().write(result);
    }
}
