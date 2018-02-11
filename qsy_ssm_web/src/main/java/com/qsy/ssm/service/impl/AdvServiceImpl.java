package com.qsy.ssm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsy.ssm.mapper.AdvsMapper;
import com.qsy.ssm.model.Advs;
import com.qsy.ssm.model.AdvsExample;
import com.qsy.ssm.service.IAdvServiceImpl;

@Service
public class AdvServiceImpl implements IAdvServiceImpl {

	@Autowired
	private AdvsMapper advsMapper;
	
	@Override
	public List<Advs> getListAdv() {
		AdvsExample example = new AdvsExample();
		example.createCriteria().andFlagEqualTo(true);
		List<Advs> list = advsMapper.selectByExample(example);
		return list;
	}

	@Override
	public void addAdv(Advs advs) {
		advs.setCreateDate(new Date());
		advs.setFlag(true);
		advsMapper.insertSelective(advs);
	}

	@Override
	public void delSingleAdv(Integer id) {
		Advs advs = new Advs();
		advs.setFlag(false);
		advs.setId(id);
		AdvsExample example = new AdvsExample();
		example.createCriteria().andIdEqualTo(id);
		advsMapper.updateByExampleSelective(advs,example);
	}

	@Override
	public void delAllAdv(String ids) {
		String[] split = ids.split(",");
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<split.length;i++){
			int id = Integer.parseInt(split[i]);
			list.add(id);
		}
		Advs advs = new Advs();
		advs.setFlag(false);
		AdvsExample example = new AdvsExample();
		example.createCriteria().andIdIn(list);
		advsMapper.updateByExampleSelective(advs,example);
	}

	@Override
	public Advs SingleAdv(Integer id) {
		
		return advsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateAdv(Advs advs) {
		advs.setUpdateDate(new Date());
		AdvsExample example = new AdvsExample();
		example.createCriteria().andIdEqualTo(advs.getId()).andFlagEqualTo(true);
		advsMapper.updateByExampleSelective(advs, example );
	}

	@Override
	public List<Advs> advcJsonp() {
		
		AdvsExample example = new AdvsExample();
		example.createCriteria().andFlagEqualTo(true);
		return advsMapper.selectByExample(example);
	}

}
