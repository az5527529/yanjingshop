package com.dao.impi;


import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.OrderDao;
import com.entity.Order1;


public class OrderDaoImpi implements OrderDao {
     private HibernateTemplate hibernateTemplate;
     
   
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void addOrder1(Order1 o) {
		hibernateTemplate.save(o);
	}

	@Override
	public void updateOrder1(Order1 o) {
		hibernateTemplate.update(o);
		System.out.println("112ewe");
		
	}

	@Override
	public String getHql(Order1 o) {
		StringBuffer sb = new StringBuffer(
				"select o from Order1 o  where o.isdel!='0'");

		if (o != null && !o.equals("")) {
			if (o.getOid()!= null&&!o.getOid().equals("")) {
				sb.append(" and o.oid= '"
						+o.getOid()+ "' ");
			}
	
			if(o.getUserinfo()!=null&&!o.getUserinfo().equals("")){
				if (o.getUserinfo().getUid()!= null&&!o.getUserinfo().getUid().equals("")) {
				sb.append(" and o.userinfo.uid= '"
						+o.getUserinfo().getUid()+ "' ");
			}
				
			}
			if(o.getGoods()!=null&&!o.getGoods().equals("")){
				if (o.getGoods().getId()!= null&&!o.getGoods().getId().equals("")) {
				sb.append(" and o.goods.id= '"
						+o.getGoods().getId()+ "' ");
			}
			
			}
		/*	if(o.getGoods()!=null&&!o.getGoods().equals("")){
				if (o.getGoods().getUsr()!= null&&!o.getGoods().getUsr().equals("")) {
					if (o.getGoods().getUsr().getUid()!= null&&!o.getGoods().getUsr().getUid().equals("")) {
				sb.append(" and o.goods.userinfo.id= '"
						+o.getGoods().getUsr().getUid()+ "' ");
					}
		}	}
			*/
			
			if(o.getStime()!=null&&!o.getStime().equals("")){
				sb.append(" and o.stime like '%"
						+o.getStime()+ "%' ");
			}
			if(o.getEtime()!=null&&!o.getEtime().equals("")){
				sb.append(" and o.etime like '%"
						+o.getEtime()+ "%' ");
			}
		
		}
		return sb.toString();
	}

	@Override
	public List<Order1> getOrder(final String hql, final int pageno,final int pageSize) {
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
	public void deleteOrder(Order1 o) {
		hibernateTemplate.delete(o);
	}

	@Override
	public Order1 getById(int id) {
		return hibernateTemplate.get(Order1.class, id);
	}

	@Override
	public Integer getCount(String hql) {
		return hibernateTemplate.find(hql).size();
	}

	@Override
	public String getHql2(Order1 o) {
		StringBuffer sb = new StringBuffer(
				"select o from Order1 o where o.isdel!='0' ");

		if (o != null && !o.equals("")) {
		
			if (o.getOstate()!= null&&!o.getOstate().equals("")) {
				sb.append(" and o.ostate like '%"
						+o.getOstate()+ "%' ");
			}
			if (o.getOno()!= null&&!o.getOno().equals("")) {
				sb.append(" and o.ono like '%"
						+o.getOno()+ "%' ");
			}
			if(o.getUserinfo()!=null&&!o.getUserinfo().equals("")){
				if(o.getUserinfo().getUname()!=null&&!o.getUserinfo().getUname().equals("")){
					sb.append(" and o.userinfo.uname='"+o.getUserinfo().getUname()+"'");
				}
				
			}
			if(o.getDate()!=null&&!o.getDate().equals("")){
				sb.append(" and o.date like '%"
						+o.getDate().toString().substring(0, 10)+ "%' ");
			}
			if(o.getGoods()!=null&&!o.getGoods().equals("")){
				if (o.getGoods().getName()!= null&&!o.getGoods().getName().equals("")) {
					sb.append(" and o.goods.name like '%"
							+o.getGoods().getName()+ "%' ");
				}
			}
			sb.append(" order by o.date desc ");
			
			
		}
System.out.println("hql===="+sb);
		return sb.toString();

	}

	@Override
	public List<Object[]> getTongJi(Date d1, Date d2) {
		String hql="select date_format(o.date, '%Y-%c-%d') as rq,SUM(o.sum) from  Order1 o where o.isdel!='0' and  o.ostate like '%货%' and  o.date between '"+d1+"' and '"+d2+"'  group by  o.date order by o.date ";
		//String hql="select date_format(o.date, '%Y-%c-%d') as rq,SUM(o.shop.num*o.goods.pricle) from  Order1 o where o.isdel!='0' and  o.ostate like '%货%' and  o.date between '"+d1+"' and '"+d2+"'  group by  o.date order by o.date ";

		List<Object[]> list=hibernateTemplate.find(hql);
		return list;
	}

}
