/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: Org
 * Author:   user
 * Date:     2018/7/3 15:03
 * Description: 组织实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈组织实体类〉
 *
 * @author user
 * @create 2018/7/3
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "sys_org")
public class Org {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String name;
}