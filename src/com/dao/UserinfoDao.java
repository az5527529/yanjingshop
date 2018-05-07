package com.dao;

import java.util.List;


import com.entity.Userinfo;



public interface UserinfoDao {

	public Userinfo checkLogin(String uname,String password);

	public Userinfo checkname(String uname);

	public void addUserinfo(Userinfo u);

	public void updateUserinfo(Userinfo u);

	public void updateUserinfoPwd(String pwd);

	public Userinfo getById(int id);

	public String getHql(Userinfo u);

	public List<Userinfo> getUserinfo(String hql,int pageno,int pageSize);

	public void deleteUserinfo(Userinfo u);

	public Integer getUserCount(String hql);

	public Userinfo getByName(String uname);
	
}
