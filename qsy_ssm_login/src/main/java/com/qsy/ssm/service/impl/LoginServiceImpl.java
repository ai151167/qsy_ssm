package com.qsy.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsy.ssm.mapper.SysUserMapper;
import com.qsy.ssm.model.SysUser;
import com.qsy.ssm.model.SysUserExample;
import com.qsy.ssm.service.ILoginService;
import com.qsy.utils.PasswordEncoder;

@Service
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser loginCheck(SysUser user) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsernameEqualTo(user.getUsername()).andFlagEqualTo(true).andActivateEqualTo(true);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if(list!=null){
			boolean check = PasswordEncoder.isPasswordInvalid(list.get(0).getPassword(), user.getPassword(), PasswordEncoder.SALT);
			if(check){
				list.get(0).setScore(list.get(0).getScore()+10);
				sysUserMapper.updateByPrimaryKeySelective(list.get(0));
				return list.get(0);
			}
		}
		return null;
	}
 
}
