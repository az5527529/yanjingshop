package com.dao;

import java.sql.Date;
import java.util.List;








import com.entity.Order1;


public interface OrderDao {
//  ��Ӷ�����Ϣ
	public void addOrder1(Order1 o);
//	�޸Ķ�����Ϣ
	public void updateOrder1(Order1 o);
//	ͨ��id����ȡ����
	public Order1 getById(int id);
//	��ȡHql���
	public String getHql(Order1 o);
//	��ȡHql���
	public String getHql2(Order1 o);
//	��ȡ������Ϣ������
	public Integer getCount(String hql);
//	��������ѯ��Ϣ
	public List<Order1> getOrder(String hql,int pageno,int pageSize);
//	ɾ����Ϣ
	public void deleteOrder(Order1 o);
//	ͳ�Ʒ���
	public List<Object[]> getTongJi(Date d1,Date d2);
	
}
