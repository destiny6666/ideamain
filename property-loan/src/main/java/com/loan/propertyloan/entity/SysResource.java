/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: SysResource
 * Author:   user
 * Date:     2018/7/2 17:46
 * Description: 系统资源表格
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

/**
 * 〈一句话功能简述〉<br>
 * 〈系统资源类〉
 *
 * @author user
 * @create 2018/7/2
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "sys_resource")
public class SysResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer pid;
    @Transient
    private List<SysResource> childsResource;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public SysResource(String name, Integer pid, Date createTime) {
        this.name = name;
        this.pid = pid;
        this.createTime = createTime;
    }
}