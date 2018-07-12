/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: UserBaseInfoService
 * Author:   user
 * Date:     2018/7/11 11:42
 * Description: 认证表单接口API
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package authentication;

import authentication.entity.UserBaseInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈认证表单接口API〉
 *
 * @author user
 * @create 2018/7/11
 * @since 1.0.0
 */
@RequestMapping("authentication")
public interface UserBaseInfoServiceAPI {
    @RequestMapping("/getAuthenticationStatus")
    public String getAuthenticationStatus(@RequestParam("request") HttpServletRequest request, @RequestParam("response")HttpServletResponse response, @RequestParam("userId")Integer userId) throws IOException;
    @RequestMapping("/getUserById")
    public String getUserById(@RequestParam("request")HttpServletRequest request, @RequestParam("response")HttpServletResponse response,@RequestParam("userId")Integer userId) throws IOException ;
    @RequestMapping("/updateCardId")
    public String  updateCardId(@RequestParam("request")HttpServletRequest request, @RequestParam("response")HttpServletResponse response, @RequestParam("ubi")UserBaseInfo ubi, @RequestParam("isProduct")boolean isProduct) throws IOException ;
    @RequestMapping("/updateContactMessage")
    public String  updateContactMessage(@RequestParam("request")HttpServletRequest request, @RequestParam("response")HttpServletResponse response,@RequestParam("ubi1")UserBaseInfo ubi1) throws IOException;
    @RequestMapping("/updateWorkMessage")
    public String updateWorkMessage(@RequestParam("request")HttpServletRequest request,@RequestParam("response") HttpServletResponse response,@RequestParam("ubi1")UserBaseInfo ubi1) throws IOException ;
    @RequestMapping("/checkCardIsLegal")
    public String checkCardIsLegal(@RequestParam("request")HttpServletRequest request, @RequestParam("response")HttpServletResponse response, @RequestParam("jsonString")String jsonString,@RequestParam("isProduct")boolean isProduct) throws IOException ;
    @RequestMapping("/toChinaMobile")
    public String  toChinaMobile(@RequestParam("request")HttpServletRequest request,@RequestParam("response") HttpServletResponse response,@RequestParam("userId") Integer userId,@RequestParam("taskId")String taskId) throws IOException;

}