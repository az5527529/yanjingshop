package com.action;

import java.sql.Timestamp;

import java.util.List;

import com.entity.Keep;
import com.entity.News;
import com.entity.Userinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.KeepService;
import com.service.NewsService;
import com.tool.PageInfo;

public class KeepAction extends ActionSupport {
	private KeepService keepServcie;
	private NewsService newsService;
	private Userinfo u;
	private PageInfo page;
	private List<Keep> klist;
	private Keep keep;
	private  News news;
	private List<News> nlist;
	private int id;
	
	public String addKeep() {
		u = (Userinfo) ActionContext.getContext().getSession().get("user");
		if(u==null){
			return ERROR;
		}else{
		keep.setIsdel("1");
		keep.setUid(u.getUid());
		keepServcie.addKeep(keep);
		return SUCCESS;
		}
	}

	public String deleteKeep() {
		keep = keepServcie.getById(id);
		keep.setIsdel("0");
		keepServcie.updateKeep(keep);
		return SUCCESS;
	}

	public String getAllKeep() {
		u = (Userinfo) ActionContext.getContext().getSession().get("user");
		klist = keepServcie.getByUid(keep.getUid());
		return SUCCESS;
	}

	
	public String addNews(){
		newsService.addNews(news);
		return SUCCESS;
	}
	
	public String showAllNews(){
		nlist=newsService.getAllNews();
		return SUCCESS;
	}
	
	public String showNews(){
		news=newsService.getById(news.getNid());
		return SUCCESS;
	}
	 
	public String deleteNews(){
		news=newsService.getById(news.getNid());
		news.setIsdel("0");
		newsService.updateNews(news);
		return SUCCESS;
	}
	public void setKeepServcie(KeepService keepServcie) {
		this.keepServcie = keepServcie;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}


	public KeepService getKeepServcie() {
		return keepServcie;
	}

	public NewsService getNewsService() {
		return newsService;
	}


	public Userinfo getU() {
		return u;
	}

	public void setU(Userinfo u) {
		this.u = u;
	}

	public List<Keep> getKlist() {
		return klist;
	}

	public void setKlist(List<Keep> klist) {
		this.klist = klist;
	}

	public Keep getKeep() {
		return keep;
	}

	public void setKeep(Keep keep) {
		this.keep = keep;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public List<News> getNlist() {
		return nlist;
	}

	public void setNlist(List<News> nlist) {
		this.nlist = nlist;
	}

	public PageInfo getPage() {
		return page;
	}
	public void setPage(PageInfo page) {
		this.page = page;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
     
}
