package com.dao.impi;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.GoodsDao;
import com.entity.Goods;

public class GoodsDaoImpi implements GoodsDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void add(Goods f) {
		hibernateTemplate.save(f);

	}

	@Override
	public void update(Goods f) {
		hibernateTemplate.update(f);

	}

	@Override
	public String getHql(Goods f) {
		StringBuffer sb = new StringBuffer("select fl from Goods fl where 1=1 ");

		if (f != null && !f.equals("")) {
			if (f.getFtype() != null && !f.getFtype().equals("")) {

				if ((f.getFtype().getFid()) != null && !(f.getFtype().getFid()).equals("")) {

					sb.append(" and fl.ftype.fid= '" + f.getFtype().getFid() + "' ");

				}
			}
			if (f.getName() != null && !f.getName().equals("")) {
				sb.append("and fl.name like '%" + f.getName() + "%'");
			}
			if (f.getIsdel() != null && !f.getIsdel().equals("")) {
				sb.append("and fl.isdel like '%" + f.getIsdel() + "%'");
			}

			if (f.getUid() != null && !f.getUid().equals("")) {

				sb.append(" and fl.uid= '" + f.getUid() + "' ");

			}

			if (f.getSeason() != null && !f.getSeason().equals("")) {
				sb.append(" and fl.season like '%" + f.getSeason() + "%' ");
			}
			if (f.getArea() != null && !f.getArea().equals("")) {
				sb.append(" and fl.area like '%" + f.getArea() + "%' ");
			}
			if (f.getIsshow() != null && !f.getIsshow().equals("")) {
				sb.append(" and fl.isshow like '%" + f.getIsshow() + "%' ");
			}
			System.out.println("goods1=" + sb.toString());
			return sb.toString();
		}
		sb.append(" order by fl.datetime desc ");
		System.out.println("goods2=" + sb.toString());
		return sb.toString();

	}

	@Override
	public List<Goods> get(final String hql, final int pageno, final int pageSize) {

		return hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((pageno - 1) * pageSize);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
	}

	@Override
	public void delete(Goods f) {
		hibernateTemplate.delete(f);

	}

	@Override
	public Integer getCount(String hql) {
		return hibernateTemplate.find(hql).size();
	}

	@Override
	public Goods getById(int id) {
		return hibernateTemplate.get(Goods.class, id);
	}

	@Override
	public List<Goods> getTop10() {
		return hibernateTemplate.find("select f from Goods f  where f.isdel!='0'  limit 0,10 ");
	}

}
