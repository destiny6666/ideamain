package com.loan.regloginservice.reglogin.service;

import com.loan.regloginservice.reglogin.entity.UserBaseInfo;
import org.apache.ibatis.annotations.Param;

public interface UserBaseInfoService {
	public UserBaseInfo loadByPhoneNum(String phoneNum);
	// 动态添加用户
	public int insert(UserBaseInfo userBaseInfo);
}
