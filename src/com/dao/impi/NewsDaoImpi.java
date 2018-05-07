package com.dao.impi;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.NewsDao;
import com.entity.News;

public class NewsDaoImpi implements NewsDao {
	  private HibernateTemplate hibernateTemplate;
	    
		public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}

		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
	@Override
	public void addNews(News f) {
		hibernateTemplate.save(f);
	}

	@Override
	public void updateNews(News f) {
		hibernateTemplate.update(f);
		
	}

	@Override
	public String getHql(News f) {
		return null;
	}

	@Override
	public Integer getCount(String hql) {
		return null;
	}

	@Override
	public News getById(int id) {
		return null;
	}

	@Override
	public List<News> getNews(String hql, int pageno, int pageSize) {
		return null;
	}

	@Override
	public void deleteNews(News f) {
		hibernateTemplate.delete(f);
	}

	@Override
	public List<News> getAllNews() {
		hibernateTemplate.find("from News where isdel!='0'");
		return null;
	}

}
