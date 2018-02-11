package com.qsy.ssm.register.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.qsy.ssm.mapper.SysUserMapper;
import com.qsy.ssm.model.SysUser;
import com.qsy.ssm.model.SysUserExample;
import com.qsy.ssm.model.SysUserExample.Criteria;
import com.qsy.ssm.register.service.IRegisterService;
import com.qsy.utils.PasswordEncoder;

@Service
public class RegisterServiceImpl implements IRegisterService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private RabbitTemplate amqpTemplate;
	
	@Override
	public SysUser add(SysUser user) {
		user.setPassword(PasswordEncoder.encodePassword(user.getPassword(),PasswordEncoder.SALT));
		user.setAdmin(false);
		user.setCreatedTime(new Date());
		user.setFlag(true);
		user.setUpdatedTime(user.getCreatedTime());
		user.setUseruuid(UUID.randomUUID().toString());
		user.setActivate(false);
		user.setScore(0);
		sysUserMapper.insertSelective(user);
		
		synData(user);
		
		return user;
	}

	private void synData(SysUser user) {
		Gson gson = new Gson();
		String json = gson.toJson(user);
		amqpTemplate.convertAndSend("email", json);
	}

	@Override
	public void activate(String uuid) {
		SysUserExample example1 = new SysUserExample();
		example1.createCriteria().andUseruuidEqualTo(uuid);
		List<SysUser> example2 = sysUserMapper.selectByExample(example1);
		example2.get(0).setActivate(true);
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUseruuidEqualTo(uuid).andFlagEqualTo(true);
		sysUserMapper.updateByExampleSelective(example2.get(0), example);
	
	}

}
