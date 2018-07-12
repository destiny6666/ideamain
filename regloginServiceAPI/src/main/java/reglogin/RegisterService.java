/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: RegisterService
 * Author:   user
 * Date:     2018/7/10 16:12
 * Description: 注册Service接口实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package reglogin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈注册Service接口实现〉
 *
 * @author user
 * @create 2018/7/10
 * @since 1.0.0
 */
@RequestMapping("/register")
public interface RegisterService {
@RequestMapping("toReg")
public String  register(@RequestParam("phonenum")String phonenum, @RequestParam("password")String password, @RequestParam("req") HttpServletRequest req, @RequestParam("resp")HttpServletResponse resp) throws Exception;
}