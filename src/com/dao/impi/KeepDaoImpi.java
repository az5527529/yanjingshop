package com.dao.impi;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.KeepDao;
import com.entity.Keep;

public class KeepDaoImpi implements KeepDao {
	 private HibernateTemplate hibernateTemplate;
	    
		public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}

		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
	@Override
	public void addKeep(Keep f) {
		hibernateTemplate.save(f);
	}

	@Override
	public void updateKeep(Keep f) {
		hibernateTemplate.update(f);
	}

	@Override
	public String getHql(Keep f) {
		return null;
	}

	@Override
	public Integer getCount(String hql) {
		return null;
	}

	@Override
	public Keep getById(int id) {
		return hibernateTemplate.get(Keep.class, id);
	}

	@Override
	public List<Keep> getKeep(String hql, int pageno, int pageSize) {
		return null;
	}

	@Override
	public void deleteKeep(Keep f) {
		hibernateTemplate.delete(f);
	}

	@Override
	public List<Keep> getByUid(int uid) {
		return hibernateTemplate.find("from Keep where uid='"+uid+"' and  isdel!='0' ");
	}

}
