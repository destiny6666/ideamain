package com.loan.authenticationservice.service;

import authentication.entity.UserBaseInfo;
import org.apache.ibatis.annotations.Param;

public interface UserBaseInfoService {
	public UserBaseInfo loadById(Integer id);
	public int update(UserBaseInfo userBaseInfo);
	// 修改手机认证报告链接
	public Integer updatePhoneReportUrl(@Param("id") Integer id, @Param("phoneReportUrl") String phoneReportUrl);
}
