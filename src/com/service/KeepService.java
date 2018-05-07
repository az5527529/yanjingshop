package com.service;

import java.util.List;


import com.entity.Keep;




public interface KeepService {
//      添加信息
		public void addKeep(Keep f);
//		修改信息
		public void updateKeep(Keep f);
//		获取Hql语句
		public String getHql(Keep f);
//		获取所有信息的条数
		public Integer getCount(String hql);
//		通过id来获取对象
		public Keep getById(int id);

		public List<Keep> getKeep(String hql,int pageno,int pageSize);
//		删除信息
		public void deleteKeep(Keep f);

		public List<Keep> getByUid(int uid);

		
}
