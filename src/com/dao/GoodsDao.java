package com.dao;

import java.util.List;


import com.entity.Goods;




public interface GoodsDao {
//      添加信息
		public void add(Goods f);
//		修改信息
		public void update(Goods f);
//		获取Hql语句
		public String getHql(Goods f);
//		获取所有信息的条数
		public Integer getCount(String hql);
//		通过id来获取对象
		public Goods getById(int id);
//		多条件查询花的信息
		public List<Goods> get(String hql,int pageno,int pageSize);
//		删除信息
		public void delete(Goods f);
//		获取前十条数据
		public List<Goods> getTop10();

		
}
