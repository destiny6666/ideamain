/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: AuthenticationController
 * Author:   user
 * Date:     2018/7/11 12:42
 * Description: 认证controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.core.controller;

import authentication.entity.UserBaseInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.loan.propertyloan.core.service.LoanAuthenticationService;
import com.loan.propertyloan.util.Descbc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈认证controller〉
 *
 * @author user
 * @create 2018/7/11
 * @since 1.0.0
 */
@Api(value = "AuthenticationController", tags = {"AuthenticationController"}, description = "认证")
@RestController
public class AuthenticationController {
    @Resource
    private LoanAuthenticationService loanAuthenticationService;
    @Value("isProduct")
    private String isProduct;
    private Logger log=LoggerFactory.getLogger(AuthenticationController.class);
    @RequestMapping(value = "/getAuthenticationStatus")
    @ApiOperation(value = "获取获取用户身份认证状态", httpMethod = "GET", notes =
            "	  描述:获取用户身份认证状态\r\n" +
                    "	  HTTP Method: POST \r\n" +
                    "	  接口地址:http://host:port/property-loan/core/userBaseInfo/getAuthenticationStatus\r\n" +
                    "	  \r\n" +
                    "	  @param request\r\n" +
                    "	  @param response\r\n" +
                    "  	  @param ciphertext\r\n"+
                    "     3des加密后的{\"userId\":int-用户id}\r\n" +
                    "	  @throws IOException\r\n" +
                    "	  \"remarks\": \"No remarks\" \r\n" +
                    "	  \"returnReason\": \"OK\" 成功 \r\n" +
                    "	  \"returnStatus\": 200 返回成功 \r\n" +
                    "	  \"returnTotal\": returnInformation的个数 \r\n" +
                    "	  \"returnInformation\": \r\n" +
                    "	  {\"bankIsEnd\":boolean-银行认证是否完成true：完成 false：未完成,\r\n" +
                    "		\"cardIsEnd\":boolean-身份认证是否完成true：完成 false：未完成,\r\n" +
                    "		\"contactIsEnd\":boolean-联系认证是否完成true：完成 false：未完成,\r\n" +
                    "		\"phoneIsEnd\":boolean-手机号认证是否完成true：完成 false：未完成,\r\n" +
                    "		\"workIsEnd\":boolean-工作认证是否完成true：完成 false：未完成} \r\n" +
                    "	  Author:贾钰琴 \r\n" +
                    "	  Date: 2017年10月23日 下午3:34:56")
    public void getAuthenticationStatus(HttpServletRequest request, HttpServletResponse response, String ciphertext) throws Exception {
        response.setContentType("text/plain;charset=utf-8");
        String jsonString =request.getAttribute("ciphertext").toString();
        JSONObject jsonObject = JSON.parseObject(jsonString);
        Integer userId=Integer.parseInt(jsonObject.get("userId").toString());
        String result=loanAuthenticationService.getAuthenticationStatus(request,response,userId);
        response.getWriter().write(result);
    }
    @RequestMapping(value = "/getUserById")
    @ApiOperation(value = "通过Id获取用户信息-H5", httpMethod = "GET", notes =
            "	  描述:通过Id获取用户信息-H5\r\n" +
                    "	  HTTP Method: POST \r\n" +
                    "	  接口地址:http://host:port/property-loan/core/userBaseInfo/getUserById\r\n" +
                    "	  \r\n" +
                    "	  @param request\r\n" +
                    "	  @param response\r\n" +
                    "  	  @param ciphertext\r\n"+
                    "     3des加密后的{\"userId\":int-用户id}\r\n" +
                    "	  @throws IOException\r\n" +
                    "	  \"remarks\": \"No remarks\" \r\n" +
                    "	  \"returnReason\": \"OK\" 成功 \r\n" +
                    "	  \"returnStatus\": 200 返回成功 \r\n" +
                    "	  \"returnTotal\": returnInformation的个数 \r\n" +
                    "	  \"returnInformation\": \r\n" +
                    "	  {\"user\":{\"address\":String-联系地址,\"authenticationStatus\":0,\"autoLimit\":int-现金贷计算额度,\"bankCardNo\":\"String-银行卡号\",\"bankDepositCityId\":开户行id,\"bankDepositCode\":\"String-开户行地址编码（金账户）\",\"bankDepositProvinceId\":int-开户行省份id,\"bankId\":\"String-银行id\",\"bankIsEnd\":false,\"bankNextCityId\":int-县区id,\"bankReservedPhone\":\"String-银行预留手机号\",\"cardId\":\"String-身份证号\",\"cardIsEnd\":false,\"cardOffice\":\"String-签证机关\",\"cardPicUrl1\":\"String-身份证正面照\",\"cardPicUrl2\":\"String-身份证反面照\",\"cardPicUrl3\":\"String-身份证手持照\",\r\n" +
                    "		 \"checkedLimit\":\"审核额度\",\"cityId\":int-城市id,\"companyAddress\":\"String-公司详细地址\",\"companyCityId\":int-公司城市id,\r\n" +
                    "		 \"companyName\":\"String-公司名称\",\"companyNextCityId\":int-公司所在区县id,\"companyPost\":\"String-公司邮编\",\r\n" +
                    "		 \"companyProvinceId\":int-公司省份id,\"contactIsEnd\":false,\"contactPerson1\":\"String-联系人1姓名\",\r\n" +
                    "		 \"contactPerson2\":\"String-联系人2姓名\",\"contactPerson3\":\"String-联系人3姓名\",\"customerManager\":\"String-客户经理\",\r\n" +
                    "		 \"email\":\"String-邮箱\",\"failCause\":\"String-认证失败原因\",\"fuyouPhoneNum\":\"String-富友手机号\",\"id\":int-用户id,\r\n" +
                    "		 \"incomeAmountPerMonth\":\"String-每月收入\",\"industryId\":int-行业id,\"isEnd\":int-1:认证完成 0：认证未完成,\r\n" +
                    "		 \"isMarry\":int-0：未婚 1：已婚 2：离异,\"liveLong\":\"String-居住时长\",\"loanType\":int-当前借款类型（0：未借款 1、现金贷 2、信贷 3、车贷 ）,\r\n" +
                    "		 \"nextCityId\":int-联系县区id,\"nickName\":\"String-昵称\",\"password\":\"\",\"payPassword\":\"\",\"paySalt\":\"\",\"person1Phone\":\"String-联系人1联系方式\",\r\n" +
                    "		 \"person1Relation\":String-紧急联系人1与当事人关系,\"person2Phone\":\"String-联系人2联系方式\",\"person2Relation\":String-紧急联系人2与当事人关系,\r\n" +
                    "		 \"person3Phone\":不用管,\"person3Relation\":不用管了,\"phoneIsEnd\":Boolean-手机认证是否完成,\"phoneNum\":\"String-手机号\",\r\n" +
                    "		 \"phoneServerPwd\":\"String-手机号服务密码\",\"provinceId\":int-联系省份id,\"registerTime\":Date-注册时间,\"salt\":\"\",\"sex\":boolean-性别true：男 false ：女,\r\n" +
                    "		 \"usefulLife\":\"String-身份证有限期\",\"userHeadPicUrl\":\"String-用户头像\",\"userName\":\"String-用户姓名\",\"userOrigin\":int-用户来源,\"workFlowStatus\":0,\"workIsEnd\":工作信息是否认证 true：认证false：未认证,\"workLong\":\"String-工作时间\"} \r\n" +
                    "	  Author:贾钰琴 \r\n" +
                    "	  Date: 2017年10月23日 下午3:34:56")
    public void getUserById(HttpServletRequest request, HttpServletResponse response, String ciphertext,String jsonpcallback) throws Exception {
        response.setContentType("text/plain;charset=utf-8");
        String jsonString =request.getAttribute("ciphertext").toString();
        JSONObject jsonObject = JSON.parseObject(jsonString);
        Integer userId=Integer.parseInt(jsonObject.get("userId").toString());
        String result=loanAuthenticationService.getUserById(request,response,userId);
        response.getWriter().write(jsonpcallback + "(" +result + ")");
    }
    @RequestMapping("/updateCardId")
    @ApiOperation(value = "保存身份证并校验是否合法-身份认证表单信息提交", httpMethod = "PUT", notes =
            "	  描述:保存身份证并校验是否合法-身份认证表单信息提交\r\n" +
                    "	  HTTP Method: POST \r\n" +
                    "	  接口地址:http://host:port/property-loan/core/userBaseInfo/updateCardId\r\n" +
                    "	  \r\n" +
                    "	  @param request\r\n" +
                    "	  @param response\r\n" +
                    "  	  @param ciphertext\r\n"+
                    "     3des加密后的{\"id\":int-用户Id,\"userName\":\"String-姓名\",\"cardId\":\"String-身份证号\"," +
                    "	 	\"cardOffice\":\"String-签证机关\",\"usefulLife\":\"String-有限期限\",\"cardStayTime\":\"String-身份证页面停留时间 \"}\r\n" +
                    "	  @throws IOException\r\n" +
                    "	  \"remarks\": \"No remarks\" \r\n" +
                    "	  \"returnReason\": \"OK\" 成功 \r\n" +
                    "	  \"returnStatus\": 200 返回成功 \r\n" +
                    "	  \"returnTotal\": returnInformation的个数 \r\n" +
                    "	  \"returnInformation\": \r\n" +
                    "	  {\"success\":\"boolean-是否更新成功（true：成功  false：失败）-不用关注\",\"isBlack\":boolean-当success为true时有此字段，true为黑名单 } \r\n" +
                    "	  Author:贾钰琴 \r\n" +
                    "	  Date: 2017年10月23日 下午3:34:56")
    public void updateCardId(HttpServletRequest request, HttpServletResponse response, String ciphertext) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        UserBaseInfo ubi = (UserBaseInfo)JSON.parseObject( request.getAttribute("ciphertext").toString(),UserBaseInfo.class);
        boolean isproduct=false;
        if(isProduct.equals("true")){
            isproduct=true;
        }
        String result=loanAuthenticationService.updateCardId(request,response,ubi,isproduct);
        response.getWriter().write(result);
    }
    @RequestMapping("/updateContactMessage")
    @ApiOperation(value = "更新联系信息-联系人信息提交", httpMethod = "PUT", notes =
            "	  描述:更新联系信息-联系人信息提交\r\n" +
                    "	  HTTP Method: POST \r\n" +
                    "	  接口地址:http://host:port/property-loan/core/userBaseInfo/updateContactMessage\r\n" +
                    "	  \r\n" +
                    "	  @param request\r\n" +
                    "	  @param response\r\n" +
                    "  	  @param ciphertext\r\n"+
                    "     3des加密后的{\"id\":int-用户Id,\"provinceId\":\"int-省份Id\",\"cityId\":\"int-城市Id\",\"nextCityId\":\"int-县区Id\",\"address\"\r\n" +
                    "	 :\"String-详细地址\",\r\n" +
                    "	 \"liveLong\":\"String-现居住时长\",\"isMarry\":\"int-婚姻状况类型\",\r\n" +
                    "	  \"contactPerson1\":\"String-紧急联系人1姓名\",\"person1Relation\":\r\n" +
                    "	  \"Integer-紧急联系人1与当事人关系\",\"person1Phone\":\"String-紧急联系人1联系方式\",\r\n" +
                    "	  \"contactPerson2\":\"String -紧急联系人2姓名\"\r\n" +
                    "	  ,\"person2Relation\":\"int-紧急联系人2与当事人关系\",\"person2Phone\":\r\n" +
                    "	  \"String-紧急联系人2联系方式\",\"email\":\"String-电子邮箱\",\"contactStayTime\":\"String-联系人页面停留时间 \"}\r\n" +
                    "	  @throws IOException\r\n" +
                    "	  \"remarks\": \"No remarks\" \r\n" +
                    "	  \"returnReason\": \"OK\" 成功 \r\n" +
                    "	  \"returnStatus\": 200 返回成功 \r\n" +
                    "	  \"returnTotal\": returnInformation的个数 \r\n" +
                    "	  \"returnInformation\": \r\n" +
                    "	  {\"success\", boolean-true:成功 false:失败} \r\n" +
                    "	  Author:贾钰琴 \r\n" +
                    "	  Date: 2017年10月23日 下午3:34:56")
    public void updateContactMessage(HttpServletRequest request, HttpServletResponse response, String ciphertext,String jsonpcallback) throws IOException {
        response.setContentType("text/plain;charset=utf-8");
        UserBaseInfo ubi1 = (UserBaseInfo)JSON.parseObject( request.getAttribute("ciphertext").toString(),UserBaseInfo.class);
        String result=loanAuthenticationService.updateContactMessage(request,response,ubi1);
        response.getWriter()
                .write(jsonpcallback + "(" + result + ")");
    }

    @RequestMapping("/updateWorkMessage")
    @ApiOperation(value = "更新工作信息-工作信息提交", httpMethod = "PUT", notes =
            "	  描述:更新工作信息-工作信息提交\r\n" +
                    "	  HTTP Method: POST \r\n" +
                    "	  接口地址:http://host:port/property-loan/core/userBaseInfo/updateWorkMessage\r\n" +
                    "	  \r\n" +
                    "	  @param request\r\n" +
                    "	  @param response\r\n" +
                    "  	  @param ciphertext\r\n"+
                    "     3des加密后的{\"id\":int-用户Id, \"industryId\":\"int-行业id(即value值)\",\r\n" +
                    "	 \"companyPost\":\"String-公司职位\", \"companyName\":\"String-公司名称\",\r\n" +
                    "	 \"companyProvinceId\":\"int-公司所在省份id(即value值)\",\r\n" +
                    "	 \"companyCityId\":\"int-公司所在城市id(即value值)\",\r\n" +
                    "	 \"companyNextCityId\":\"int-公司所在区、县id(即value值)\",\r\n" +
                    "	 \"companyAddress\":\"String-公司所在地址\", \"workLong\":\"String-工作时长\",\r\n" +
                    "	 \"incomeAmountPerMonth\":\"String-月总收入\",\"workStayTime\":\"String-工作信息停留时间\"}\r\n" +
                    "	  @throws IOException\r\n" +
                    "	  \"remarks\": \"No remarks\" \r\n" +
                    "	  \"returnReason\": \"OK\" 成功 \r\n" +
                    "	  \"returnStatus\": 200 返回成功 \r\n" +
                    "	  \"returnTotal\": returnInformation的个数 \r\n" +
                    "	  \"returnInformation\": \r\n" +
                    "	  {\"success\":\"boolean-true:成功 false:失败\"} \r\n" +
                    "	  Author:贾钰琴 \r\n" +
                    "	  Date: 2017年10月23日 下午3:34:56")
    public void updateWorkMessage(HttpServletRequest request, HttpServletResponse response, String ciphertext,String jsonpcallback) throws IOException {
        response.setContentType("text/plain;charset=utf-8");
        UserBaseInfo ubi1 = (UserBaseInfo)JSON.parseObject( request.getAttribute("ciphertext").toString(),UserBaseInfo.class);
        String result=loanAuthenticationService.updateWorkMessage(request,response,ubi1);
        response.getWriter()
                .write(jsonpcallback + "(" + result + ")");
    }
    @RequestMapping("/toChinaMobile")
    @ApiOperation(value = "提供taskid查询结果", httpMethod = "POST", notes =
            "	  描述:通过Id获取用户信息-H5\r\n" +
                    "	  HTTP Method: POST \r\n" +
                    "	  接口地址:http://host:port/property-loan/core/userBaseInfo/toChinaMobile\r\n" +
                    "	  \r\n" +
                    "	  @param request\r\n" +
                    "	  @param response\r\n" +
                    "  	  @param ciphertext\r\n"+
                    "     3des加密后的{\"userId\":int-用户id,\"taskId\":\"String-页面截取的task_id\"}\r\n" +
                    "	  @throws IOException\r\n" +
                    "	  \"remarks\": \"No remarks\" \r\n" +
                    "	  \"returnReason\": \"OK\" 成功 \r\n" +
                    "	  \"returnStatus\": 200 返回成功 \r\n" +
                    "	  \"returnTotal\": returnInformation的个数 \r\n" +
                    "	  \"returnInformation\":{} \r\n" +
                    "	  Author:贾钰琴 \r\n" +
                    "	  Date: 2017年10月23日 下午3:34:56")
    public void toChinaMobile(HttpServletRequest request, HttpServletResponse response, String ciphertext,String jsonpcallback) throws IOException {
        response.setContentType("text/plain;charset=utf-8");
        JSONObject jo = JSON.parseObject(request.getAttribute("ciphertext").toString());
        Integer userId = Integer.parseInt(jo.get("userId").toString());
        String taskId = jo.getString("taskId");
        String result = loanAuthenticationService.toChinaMobile(request, response, userId, taskId);
        response.getWriter()
                .write(jsonpcallback + "(" + result + ")");
    }
    @RequestMapping("/checkCardIsLegal")
    @ApiOperation(value = "校验身份证是否合法", httpMethod = "GET", notes =
            "	  描述:保存身份证并校验是否合法-身份认证表单信息提交\r\n" +
                    "	  HTTP Method: POST \r\n" +
                    "	  接口地址:http://host:port/property-loan/core/userBaseInfo/checkCardIsLegal\r\n" +
                    "	  \r\n" +
                    "	  @param request\r\n" +
                    "	  @param response\r\n" +
                    "  	  @param ciphertext\r\n"+
                    "     3des加密后的{\"name\":\"String-姓名\",\"cardId\":\"String-身份证号\"}\r\n" +
                    "	  @throws IOException\r\n" +
                    "	  \"remarks\": \"No remarks\" \r\n" +
                    "	  \"returnReason\": \"OK\" 成功 \r\n" +
                    "	  \"returnStatus\": 200 返回成功 \r\n" +
                    "	  \"returnTotal\": returnInformation的个数 \r\n" +
                    "	  \"returnInformation\": \r\n" +
                    "	  {\"isLegal\":\"boolean-是否合法(true：合法，可进行下一步   false：不合法，需重新修改)\",\r\n" +
                    "	   \"reason\":\"String-身份证不合法原因（当isLegal为false时有此字段）\"}\r\n"+
                    "	  Author:贾钰琴 \r\n" +
                    "	  Date: 2017年10月23日 下午3:34:56")
    public void checkCardIsLegal(HttpServletRequest request, HttpServletResponse response, String ciphertext) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        String jsonString =request.getAttribute("ciphertext").toString();
        boolean isproduct=false;
        if (isProduct.equals("true")){
            isproduct=true;
        }
        String result=loanAuthenticationService.checkCardIsLegal(request,response,jsonString,isproduct);
        response.getWriter().write(result);
    }
}