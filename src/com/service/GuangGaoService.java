package com.service;

import java.util.List;

import com.entity.Guanggaopic;

public interface GuangGaoService {
	   public void addGuangGao(Guanggaopic gg);
	   public void deleteGuangGao(Guanggaopic gg);
	   public void updateGuangGao(Guanggaopic gg);
	   public List<Guanggaopic> getAll();
	   public Guanggaopic getById(int id);
	   public List<Guanggaopic> getByPage(String hql,int pageno,int pageSize);
	   public String getHql(Guanggaopic g);
	   public Integer getCount(String hql);
}
