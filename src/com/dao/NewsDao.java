package com.dao;

import java.util.List;


import com.entity.News;




public interface NewsDao {

		public void addNews(News f);

		public void updateNews(News f);

		public String getHql(News f);

		public Integer getCount(String hql);

		public News getById(int id);

		public List<News> getNews(String hql,int pageno,int pageSize);

		public void deleteNews(News f);

		public List<News> getAllNews();

		
}
