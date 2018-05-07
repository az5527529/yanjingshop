package com.service;

import java.util.List;

import com.entity.Goods;
import com.entity.Ftype;




public interface FtypeService {

	public void addFtype(Ftype f);

	public List<Ftype> getAllFtype();
	
	public Ftype checkname(String uname);

	public void updateFtype(Ftype f);

	public Ftype getById(int id);

	public void deleteFtype(Ftype c);

	public Integer getCount(String hql);

	public String getHql(Ftype f);

	public List<Ftype> getFtype(String hql,int pageno,int pageSize);

}
