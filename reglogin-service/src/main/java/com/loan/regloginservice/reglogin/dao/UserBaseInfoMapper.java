package com.loan.regloginservice.reglogin.dao;

import com.loan.regloginservice.reglogin.entity.UserBaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserBaseInfoMapper {
	public UserBaseInfo loadByPhoneNum(String phoneNum);
	//动态添加用户
	public int insert(UserBaseInfo userBaseInfo);

}
