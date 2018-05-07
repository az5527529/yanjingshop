package com.dao.impi;


import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.UserinfoDao;
import com.entity.Userinfo;

public class UserinfoDaoImpi implements UserinfoDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public Userinfo checkLogin(String uname, String password) {
		System.out.println("11111");
		String hql ="select u from Userinfo u where  u.ustate!=0  and u.uname=? and u.pwd=? ";
		
		Object[] obj = {uname,password};
		System.out.println("22222");
		List<Userinfo> list =hibernateTemplate.find(hql, obj);
		System.out.println("333");
		if (list.size() > 0) {
			System.out.println("list="+list.get(0));
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public void addUserinfo(Userinfo u) {
		hibernateTemplate.save(u);
	}

	@Override
	public void updateUserinfo(Userinfo u) {
		hibernateTemplate.update(u);
		
	}

	@Override
	public String getHql(Userinfo u) {
		StringBuffer sb = new StringBuffer(
				"select u from Userinfo u  where  u.ustate!=0 ");
		if (u != null && !u.equals("")) {
			if (u.getUname() != null) {
				sb.append(" and u.uname like '%" + u.getUname() + "%' ");
			}
			if(u.getLevel()!=null){
				sb.append(" and u.level="+u.getLevel()+" ");
			}

		}
		return sb.toString();
	}

	@Override
	public List<Userinfo> getUserinfo(final String hql, final int pageno,
			final int pageSize) {
		return hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((pageno - 1) * pageSize);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
	}

	@Override
	public Userinfo checkname(String uname) {
		String hql = "select u from Userinfo u where u.uname=? ";
		Object[] obj = { uname };
		List<Userinfo> list = hibernateTemplate.find(hql, obj);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public void updateUserinfoPwd(String pwd) {
		String hql = "update Userinfo u set u.pwd=? where id=? ";
		hibernateTemplate.update(pwd, hql);
	
	}

	@Override
	public Userinfo getById(int id) {
		return hibernateTemplate.get(Userinfo.class, id);
	}

	@Override
	public void deleteUserinfo(Userinfo u) {
		hibernateTemplate.delete(u);
	}

	@Override
	public Integer getUserCount(String hql) {
		return hibernateTemplate.find(hql).size();
	}

	@Override
	public Userinfo getByName(String uname) {
		String hql="select u from Userinfo u where u.uname=? ";
		Object[] obj = { uname };
		List<Userinfo> list = hibernateTemplate.find(hql, obj);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

}
