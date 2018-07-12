package com.loan.regloginservice.reglogin.service;

import java.util.Map;

public interface PasswordService {
	public Map<String,String> getPassword(String password);
	public String getPasswordBySalt(String salt, String password);
}
