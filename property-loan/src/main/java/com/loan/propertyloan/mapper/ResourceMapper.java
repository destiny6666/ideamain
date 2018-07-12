/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: ResourceMapper
 * Author:   user
 * Date:     2018/7/2 17:48
 * Description: 资源mapper
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.mapper;

import com.loan.propertyloan.entity.SysResource;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈资源mapper〉
 *
 * @author user
 * @create 2018/7/2
 * @since 1.0.0
 */
@Mapper
public interface ResourceMapper {
    @Select("select id,name,pid from sys_resource where pid=#{pid}")
    List<SysResource> getResourceList(@Param("pid") Integer pid);

    //通过id获取资源详细信息
    @Select("select * from sys_resource where id=#{id}")
    SysResource loadById(@Param("id") Integer id);
    //插入资源
    @Insert("insert into sys_resource(name,pid) values (#{name},#{pid})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType =int.class )
    int insert(@Param("name") String name, @Param("pid") Integer pid);
}