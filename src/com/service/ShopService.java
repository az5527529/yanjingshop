package com.service;

import java.util.List;

import com.entity.Shop;

public interface ShopService {
//  添加订单信息
	public void addShop(Shop s);
//	修改订单信息
	public void updateShop(Shop s);
//	获取Hql语句
	public String getHql(Shop s);
//	获取所有信息的条数
	public Integer getCount(String hql);
//	通过id来获取对象
	public Shop getById(int id);
//	多条件查询订单的信息
	public List<Shop> getShop(String hql,int pageno,int pageSize);
//	删除花的信息
	public void deleteShop(Shop s);
}
