/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: ResourceService
 * Author:   user
 * Date:     2018/7/2 17:53
 * Description: 资源Service
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.service;

import com.loan.propertyloan.entity.SysResource;
import org.apache.ibatis.annotations.Param;

/**
 * 〈一句话功能简述〉<br> 
 * 〈资源Service〉
 *
 * @author user
 * @create 2018/7/2
 * @since 1.0.0
 */
public interface  ResourceService {
    SysResource getResourceTree();
    int insert(@Param("name") String name, @Param("pid") Integer pid);
}