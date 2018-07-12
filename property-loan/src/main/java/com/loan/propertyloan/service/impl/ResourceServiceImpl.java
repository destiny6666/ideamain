/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: ResourceServiceImpl
 * Author:   user
 * Date:     2018/7/2 17:56
 * Description: 资源service实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.service.impl;

import com.loan.propertyloan.Repository.ResourceRepository;
import com.loan.propertyloan.entity.SysResource;
import com.loan.propertyloan.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈资源service实现〉
 *
 * @author user
 * @create 2018/7/2
 * @since 1.0.0
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public SysResource getResourceTree() {
        SysResource rootResource=resourceRepository.findById(1).get();
        getAllResourceTree(rootResource);
        return rootResource;
    }
    @Override
    public int insert(String name, Integer pid) {
        SysResource sysResource=new SysResource(name,pid,new Date());
        return resourceRepository.save(sysResource).getId();
    }

    private void getAllResourceTree(SysResource resource) {
        List<SysResource> resourceList = resourceRepository.findByPid(resource.getId());
        resource.setChildsResource(resourceList);
        for (SysResource sysResource:resourceList){
            getAllResourceTree(sysResource);
        }
    }
}