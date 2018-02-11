package com.qsy.ssm.register.service;


import com.qsy.ssm.model.SysUser;

public interface IRegisterService {

	SysUser add(SysUser user);

	void activate(String uuid);

}
