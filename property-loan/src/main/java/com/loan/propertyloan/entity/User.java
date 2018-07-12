/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: UserTest
 * Author:   user
 * Date:     2018/6/29 14:11
 * Description: 用户测试实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户测试实体类〉
 *
 * @author user
 * @create 2018/6/29
 * @since 1.0.0
 */
@Data
@Entity
@Table(name="sys_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private boolean sex;
    private String address;
//    @ManyToOne
//    @JoinColumn(name = "org_id")
    private Integer orgId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creatTime;

    public User(String userName, boolean sex, String address, Integer orgId, Date creatTime) {
        this.userName = userName;
        this.sex = sex;
        this.address = address;
        this.orgId = orgId;
        this.creatTime = creatTime;
    }
}