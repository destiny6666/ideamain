/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: LoanLoginService
 * Author:   user
 * Date:     2018/7/10 16:30
 * Description: APP接口API接口继承
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.core.service;

import org.springframework.cloud.openfeign.FeignClient;
import reglogin.RegisterService;

/**
 * 〈一句话功能简述〉<br> 
 * 〈APP接口API接口继承〉
 *
 * @author user
 * @create 2018/7/10
 * @since 1.0.0
 */
@FeignClient(value = "reglogin-service")
public interface LoanRegService extends RegisterService {

}