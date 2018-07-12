/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: User
 * Author:   user
 * Date:     2018/7/5 9:14
 * Description: 测试用户类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.redisservice.entity;

import lombok.Data;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试用户类〉
 *
 * @author user
 * @create 2018/7/5
 * @since 1.0.0
 */
@Data
public class User {
    private Integer id;
    private String name;
    private boolean sex;
    private Date createTime;

    public User(Integer id, String name, boolean sex, Date createTime) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.createTime = createTime;
    }
}