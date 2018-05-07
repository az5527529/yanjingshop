package com.dao.impi;

import java.sql.SQLException;
import java.util.List;





import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.GuangGaoDao;
import com.entity.Guanggaopic;

public class GuangGaoDaoImpi implements GuangGaoDao {
    private HibernateTemplate hibernateTemplate;
    
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Guanggaopic> getAll() {
		return hibernateTemplate.find("from Guanggaopic g where g.isdel!='0' and g.type='新闻' ");
	}

	@Override
	public Guanggaopic getById(int id) {
		return hibernateTemplate.get(Guanggaopic.class, id);
	}

	@Override
	public void addGuangGao(Guanggaopic gg) {
		hibernateTemplate.save(gg);
	}

	@Override
	public void deleteGuangGao(Guanggaopic gg) {
		hibernateTemplate.delete(gg);
	}

	@Override
	public void updateGuangGao(Guanggaopic gg) {
		hibernateTemplate.update(gg);
	}

	@Override
	public List<Guanggaopic> getByPage(final String hql,final int pageno,final int pageSize) {
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
	public String getHql(Guanggaopic g) {
		StringBuffer sb = new StringBuffer(
				"select gg from Guanggaopic gg where gg.isdel!='0'  ");

		if (g != null && !g.equals("")) {
			if(g.getName()!=null&&!g.getName().equals("")){
				sb.append(" and gg.name like  '%" + g.getName() + "%' ");

			}
			if(g.getType()!=null&&!g.getType().equals("")){
				sb.append(" and gg.type like '%" + g.getType() + "%' ");

			}
			}
		return sb.toString();
	}

	@Override
	public Integer getCount(String hql) {
		return hibernateTemplate.find(hql).size();
	}

}
