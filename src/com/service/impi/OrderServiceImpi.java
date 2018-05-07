package com.service.impi;

import java.sql.Date;
import java.util.List;

import com.dao.OrderDao;
import com.entity.Order1;
import com.service.OrderService;

public class OrderServiceImpi implements OrderService {
    private OrderDao od;
    
	public OrderDao getOd() {
		return od;
	}

	public void setOd(OrderDao od) {
		this.od = od;
	}

	@Override
	public void addOrder(Order1 o) {
		od.addOrder1(o);
	}

	@Override
	public void updateOrder(Order1 o) {
		od.updateOrder1(o);
	}

	@Override
	public String getHql(Order1 o) {
		return od.getHql(o);
	}

	@Override
	public List<Order1> getOrder(String hql, int pageno, int pageSize) {
		return od.getOrder(hql, pageno, pageSize);
	}

	@Override
	public void deleteOrder(Order1 o) {
		od.deleteOrder(o);
	}

	@Override
	public Order1 getById(int id) {
		return od.getById(id);
	}

	@Override
	public Integer getCount(String hql) {
		return od.getCount(hql);
	}

	@Override
	public String getHql2(Order1 o) {
		return od.getHql2(o);
	}

	@Override
	public List<Object[]> getTongJi(Date d1, Date d2) {
		return od.getTongJi(d1, d2);
	}

}
