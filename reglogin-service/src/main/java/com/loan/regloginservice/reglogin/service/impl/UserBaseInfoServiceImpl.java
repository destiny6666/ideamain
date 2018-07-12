package com.loan.regloginservice.reglogin.service.impl;

import javax.annotation.Resource;

import com.loan.regloginservice.reglogin.dao.UserBaseInfoMapper;
import com.loan.regloginservice.reglogin.entity.UserBaseInfo;
import com.loan.regloginservice.reglogin.service.UserBaseInfoService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserBaseInfoServiceImpl implements UserBaseInfoService {
@Resource
private UserBaseInfoMapper userBaseInfoMapper;
	@Override
	public UserBaseInfo loadByPhoneNum(String phoneNum) {
		// TODO Auto-generated method stub
		return userBaseInfoMapper.loadByPhoneNum(phoneNum);
	}

	@Override
	public int insert(UserBaseInfo userBaseInfo) {
		// TODO Auto-generated method stub
		return userBaseInfoMapper.insert(userBaseInfo);
	}

}
