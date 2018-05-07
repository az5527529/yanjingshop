package com.service.impi;

import java.util.List;

import com.dao.UserinfoDao;
import com.entity.Ftype;
import com.entity.Userinfo;
import com.service.UserinfoService;

public class UserinfoServiceImpi implements UserinfoService {
	private UserinfoDao ud;

	public UserinfoDao getUd() {
		return ud;
	}

	public void setUd(UserinfoDao ud) {
		this.ud = ud;
	}

	@Override
	public void addUserinfo(Userinfo u) {
		ud.addUserinfo(u);
	}

	@Override
	public void updateUserinfo(Userinfo u) {
		ud.updateUserinfo(u);
	}

	@Override
	public String getHql(Userinfo u) {
		return ud.getHql(u);
	}

	@Override
	public List<Userinfo> getUserinfo(String hql, int pageno, int pageSize) {
		return ud.getUserinfo(hql, pageno, pageSize);
	}

	@Override
	public Userinfo checkLogin(String uname, String password) {
		System.out.println("login");
		return ud.checkLogin(uname, password);
	}

	@Override
	public Userinfo checkname(String uname) {
		return ud.checkname(uname);
	}

	@Override
	public void updateUserinfoPwd(String pwd) {
		ud.updateUserinfoPwd(pwd);
	}

	@Override
	public Userinfo getById(int id) {
		return ud.getById(id);
	}

	@Override
	public void deleteUserinfo(Userinfo u) {
		ud.deleteUserinfo(u);
	}

	@Override
	public Integer getUserCount(String hql) {
		return ud.getUserCount(hql);
	}

	@Override
	public Userinfo getByName(String uname) {
		return ud.getByName(uname);
	}

}
