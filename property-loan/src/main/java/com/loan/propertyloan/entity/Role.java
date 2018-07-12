/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: Role
 * Author:   user
 * Date:     2018/7/2 16:17
 * Description: 用户角色表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户角色表〉
 *
 * @author user
 * @create 2018/7/2
 * @since 1.0.0
 */
@Data
@Entity
@Table(name="sys_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Transient
    private List<User> userList;
    private String  role_name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ManyToMany(cascade = {},fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name="role_id")})
    private Set<User> users;
    @ManyToMany(cascade = {},fetch = FetchType.EAGER)
    @JoinTable(name = "role_resource",joinColumns = {@JoinColumn(name="role_id")},inverseJoinColumns = {@JoinColumn(name = "resource_id")})
    private Set<SysResource> resources;

    public Role(String role_name, Date createTime) {
        this.role_name = role_name;
        this.createTime = createTime;
    }
}