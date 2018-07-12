/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: UserController
 * Author:   user
 * Date:     2018/7/3 15:01
 * Description: 用戶Controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.controller;

import com.loan.propertyloan.Repository.UserRepository;
import com.loan.propertyloan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈用戶Controller〉
 *
 * @author user
 * @create 2018/7/3
 * @since 1.0.0
 */
@Controller
@RequestMapping("admin/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    //根据组织获取用户
    @RequestMapping("/getUserByOrg")
    public List<User> getUserByOrg(){
        List<User> users=userRepository.findByOrgId(1);
        return users;
    }
}