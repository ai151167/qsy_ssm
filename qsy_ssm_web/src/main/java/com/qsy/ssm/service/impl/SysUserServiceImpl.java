package com.qsy.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsy.ssm.mapper.SysUserMapper;
import com.qsy.ssm.model.SysUser;
import com.qsy.ssm.model.SysUserExample;
import com.qsy.ssm.service.ISysUserService;
import com.qsy.utils.PasswordEncoder;


@Service
public class SysUserServiceImpl implements ISysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public SysUser checkIsOk(SysUser sysUser) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsernameEqualTo(sysUser.getUsername()).andFlagEqualTo(true);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if(list.size()!=0){
			boolean invalid = PasswordEncoder.isPasswordInvalid(list.get(0).getPassword(),sysUser.getPassword(),PasswordEncoder.SALT);
			if(invalid){
				return list.get(0);
			}
		}
		return null;
	}

	@Override
	public SysUser checkUserByPWDEncode(SysUser sysUser) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsernameEqualTo(sysUser.getUsername()).andFlagEqualTo(true);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		System.out.println(list.size());
		if(list!=null){
			boolean check = PasswordEncoder.isPasswordInvalid(list.get(0).getPassword(), sysUser.getPassword(), PasswordEncoder.SALT);
			if(check){
				list.get(0).setScore(list.get(0).getScore()+10);
				sysUserMapper.updateByPrimaryKeySelective(list.get(0));
				return list.get(0);
			}
		}
		return null;
	}

}
