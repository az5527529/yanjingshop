package com.dao.impi;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.ShopDao;
import com.entity.Shop;

public class ShopDaoImpi implements ShopDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void addShop(Shop s) {
		hibernateTemplate.save(s);
	}

	@Override
	public void updateShop(Shop s) {
		hibernateTemplate.update(s);
	}

	@Override
	public String getHql(Shop s) {
		StringBuffer sb = new StringBuffer("select fl from Shop fl where fl.isdel!='0' ");

		if (s != null && !s.equals("")) {
			if (s.getState() != null && !s.getState().equals("")) {
				sb.append(" and fl.state= '" + s.getState() + "' ");
			}
			if (s.getUserinfo()!= null && !s.getUserinfo().equals("")) {
				if (s.getUserinfo().getUid()!= null && !s.getUserinfo().getUid().equals("")) {
				sb.append(" and fl.userinfo.uid= '" + s.getUserinfo().getUid() + "' ");
				}
			}
			if (s.getOid() != null && !s.getOid().equals("")) {
				sb.append(" and fl.oid= '" + s.getOid() + "' ");
			}
			if (s.getSid() != null && !s.getSid().equals("")) {
				sb.append(" and fl.sid= '" + s.getSid() + "' ");
			}
		}
		return sb.toString();

	}

	@Override
	public Integer getCount(String hql) {
		return hibernateTemplate.find(hql).size();
	}

	@Override
	public Shop getById(int id) {
		return hibernateTemplate.get(Shop.class, id);
	}

	@Override
	public List<Shop> getShop(final String hql,final int pageno,final int pageSize) {
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
	public void deleteShop(Shop s) {
		hibernateTemplate.delete(s);
	}

}
