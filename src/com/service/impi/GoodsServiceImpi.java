package com.service.impi;

import java.util.List;


import com.dao.GoodsDao;
import com.entity.Goods;
import com.service.GoodsService;

public class GoodsServiceImpi implements GoodsService {
    private GoodsDao fd;
    
    	public void setFd(GoodsDao fd) {
		this.fd = fd;
	}

	@Override
	public void add(Goods f) {
		fd.add(f);
	}
	public GoodsDao getFd() {
		return fd;
	}

	@Override
	public void update(Goods f) {
		fd.update(f);
	}

	@Override
	public String getHql(Goods f) {
		return fd.getHql(f);
	}

	@Override
	public List<Goods> get(String hql, int pageno, int pageSize) {
		return fd.get(hql, pageno, pageSize);
	}

	@Override
	public void delete(Goods f) {
		fd.delete(f);
	}

	@Override
	public Integer getCount(String hql) {
		return fd.getCount(hql);
	}

	@Override
	public Goods getById(int id) {
		return fd.getById(id);
	}

	@Override
	public List<Goods> getTop10() {
		return fd.getTop10();
	}

}
