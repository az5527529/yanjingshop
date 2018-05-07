package com.dao;

import java.sql.Date;
import java.util.List;








import com.entity.Order1;


public interface OrderDao {
//  添加订单信息
	public void addOrder1(Order1 o);
//	修改订单信息
	public void updateOrder1(Order1 o);
//	通过id来获取对象
	public Order1 getById(int id);
//	获取Hql语句
	public String getHql(Order1 o);
//	获取Hql语句
	public String getHql2(Order1 o);
//	获取所有信息的条数
	public Integer getCount(String hql);
//	多条件查询信息
	public List<Order1> getOrder(String hql,int pageno,int pageSize);
//	删除信息
	public void deleteOrder(Order1 o);
//	统计分析
	public List<Object[]> getTongJi(Date d1,Date d2);
	
}
