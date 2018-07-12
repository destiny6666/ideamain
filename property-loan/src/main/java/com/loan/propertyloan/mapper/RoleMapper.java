/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: RoleMapper
 * Author:   user
 * Date:     2018/6/29 15:35
 * Description: 角色Mapper
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.mapper;

import com.loan.propertyloan.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

/**
 * 〈一句话功能简述〉<br>
 * 〈角色Mapper〉
 *
 * @author user
 * @create 2018/6/29
 * @since 1.0.0
 */
@Mapper
public interface RoleMapper {
    @Insert(value = "insert into role_test(role_name,user_id) values (#{role_name},#{user_id})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType =int.class )
    public int insert(Role role);
    @Select(value = "select * from role_test where id=#{id}")
    public Role getById(Integer id);
}