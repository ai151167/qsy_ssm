package com.qsy.ssm.service;

import java.util.List;

import com.qsy.ssm.model.Advs;

public interface IAdvServiceImpl {

	List<Advs> getListAdv();

	void addAdv(Advs advs);

	void delSingleAdv(Integer id);

	void delAllAdv(String ids);

	Advs SingleAdv(Integer id);

	void updateAdv(Advs advs);

	List<Advs> advcJsonp();

}
