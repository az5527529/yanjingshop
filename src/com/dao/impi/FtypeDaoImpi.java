package com.dao.impi;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.FtypeDao;
import com.entity.Ftype;
import com.entity.Userinfo;

public class FtypeDaoImpi implements FtypeDao {
    private HibernateTemplate hibernateTemplate;
    
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void addFtype(Ftype f) {
	 hibernateTemplate.save(f);

	}

	@Override
	public List<Ftype> getAllFtype() {
		return hibernateTemplate.find("from Ftype where isdel!='0'");
	}

	@Override
	public void updateFtype(Ftype f) {
	  hibernateTemplate.update(f);
		
	}

	@Override
	public void deleteFtype(Ftype c) {
		
		hibernateTemplate.delete(c);
	}

	@Override
	public Ftype getById(int id) {
		return hibernateTemplate.get(Ftype.class, id);
	}

	@Override
	public Integer getCount(String hql) {
		return hibernateTemplate.find(hql).size();
	}

	@Override
	public String getHql(Ftype f) {
		StringBuffer sb=new StringBuffer("select c from Ftype c  where c.isdel='1' ");
		if(f!=null&&!f.equals("")){
			if(f.getFtype()!=null){
				sb.append(" and c.ftype='"+f.getFtype()+"' ");
				
			}
			
		}
		return sb.toString();
	}

	@Override
	public List<Ftype> getFtype(final String hql,final int pageno,final int pageSize) {
	    
			return hibernateTemplate.executeFind(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query=session.createQuery(hql);
					query.setFirstResult((pageno-1)*pageSize);
					query.setMaxResults(pageSize);
					return query.list();
				}
			});
	}

	@Override
	public Ftype checkname(String uname) {
		String hql="select f from Ftype f where  f.isdel!='0' and f.ftype=?  ";
		Object[] obj = { uname };
		List<Ftype> list = hibernateTemplate.find(hql, obj);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

}
