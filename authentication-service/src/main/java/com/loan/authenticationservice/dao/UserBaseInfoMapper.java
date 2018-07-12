package com.loan.authenticationservice.dao;

import authentication.entity.UserBaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserBaseInfoMapper {
	public UserBaseInfo loadById(Integer id);
	public int update(UserBaseInfo userBaseInfo);
	//修改手机认证报告链接
	public Integer updatePhoneReportUrl(@Param("id")Integer id, @Param("phoneReportUrl")String phoneReportUrl);
}
