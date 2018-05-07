package com.service;

import java.util.List;

import com.entity.Shop;

public interface ShopService {
//  ��Ӷ�����Ϣ
	public void addShop(Shop s);
//	�޸Ķ�����Ϣ
	public void updateShop(Shop s);
//	��ȡHql���
	public String getHql(Shop s);
//	��ȡ������Ϣ������
	public Integer getCount(String hql);
//	ͨ��id����ȡ����
	public Shop getById(int id);
//	��������ѯ��������Ϣ
	public List<Shop> getShop(String hql,int pageno,int pageSize);
//	ɾ��������Ϣ
	public void deleteShop(Shop s);
}
