/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: UserRepository
 * Author:   user
 * Date:     2018/7/3 14:54
 * Description: 用户Repository
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.Repository;

import com.loan.propertyloan.entity.Org;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户Repository〉
 *
 * @author user
 * @create 2018/7/3
 * @since 1.0.0
 */
@Repository
public interface OrgRepository extends JpaRepository<Org,Integer> {

}