/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: LoanAuthenticationService
 * Author:   user
 * Date:     2018/7/11 12:43
 * Description: authenticationAPI接口继承
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.propertyloan.core.service;

import authentication.UserBaseInfoServiceAPI;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 〈一句话功能简述〉<br> 
 * 〈authenticationAPI接口继承〉
 *
 * @author user
 * @create 2018/7/11
 * @since 1.0.0
 */
@FeignClient(value = "authentication-service")
public interface LoanAuthenticationService extends UserBaseInfoServiceAPI {

}