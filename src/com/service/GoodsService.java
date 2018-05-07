package com.service;

import java.util.List;
import com.entity.Goods;

public interface GoodsService {

	public void add(Goods f);

	public void update(Goods f);

	public String getHql(Goods f);

	public Integer getCount(String hql);

	public Goods getById(int id);

	public List<Goods> get(String hql,int pageno,int pageSize);

	public void delete(Goods f);

	public List<Goods> getTop10();


}
