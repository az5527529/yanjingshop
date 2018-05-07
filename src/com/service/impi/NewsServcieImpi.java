package com.service.impi;

import java.util.List;

import com.dao.NewsDao;
import com.entity.News;
import com.service.NewsService;

public class NewsServcieImpi implements NewsService {
    private NewsDao nd;
    
	public NewsDao getNd() {
		return nd;
	}

	public void setNd(NewsDao nd) {
		this.nd = nd;
	}

	@Override
	public void addNews(News f) {
		nd.addNews(f);
	}

	@Override
	public void updateNews(News f) {
		nd.updateNews(f);
	}

	@Override
	public String getHql(News f) {
		return nd.getHql(f);
	}

	@Override
	public Integer getCount(String hql) {
		return nd.getCount(hql);
	}

	@Override
	public News getById(int id) {
		return nd.getById(id);
	}

	@Override
	public List<News> getNews(String hql, int pageno, int pageSize) {
		return nd.getNews(hql, pageno, pageSize);
	}

	@Override
	public void deleteNews(News f) {
		nd.deleteNews(f);
	}

	@Override
	public List<News> getAllNews() {
		return nd.getAllNews();
	}

}
