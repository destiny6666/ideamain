package com.loan.authenticationservice.service.impl;

import javax.annotation.Resource;

import authentication.entity.UserBaseInfo;
import com.loan.authenticationservice.dao.UserBaseInfoMapper;
import com.loan.authenticationservice.service.UserBaseInfoService;
import org.springframework.stereotype.Service;
@Service("userBaseInfoService")
public class UserBaseInfoServiceImpl implements UserBaseInfoService {
@Resource
private UserBaseInfoMapper userBaseInfoMapper;
	@Override
	public UserBaseInfo loadById(Integer id) {
		// TODO Auto-generated method stub
		return userBaseInfoMapper.loadById(id);
	}

	@Override
	public int update(UserBaseInfo userBaseInfo) {
		// TODO Auto-generated method stub
		return userBaseInfoMapper.update(userBaseInfo);
	}

	@Override
	public Integer updatePhoneReportUrl(Integer id, String phoneReportUrl) {
		return userBaseInfoMapper.updatePhoneReportUrl(id,phoneReportUrl);
	}
}
