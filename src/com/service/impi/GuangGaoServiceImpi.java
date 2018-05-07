package com.service.impi;

import java.util.List;

import com.dao.GuangGaoDao;
import com.entity.Guanggaopic;
import com.service.GuangGaoService;

public class GuangGaoServiceImpi implements GuangGaoService {
     private GuangGaoDao ggd;
     
	public GuangGaoDao getGgd() {
		return ggd;
	}

	public void setGgd(GuangGaoDao ggd) {
		this.ggd = ggd;
	}

	@Override
	public void addGuangGao(Guanggaopic gg) {
		ggd.addGuangGao(gg);
	}

	@Override
	public void deleteGuangGao(Guanggaopic gg) {
		ggd.deleteGuangGao(gg);
	}

	@Override
	public List<Guanggaopic> getAll() {
		return ggd.getAll();
	}

	@Override
	public Guanggaopic getById(int id) {
		return ggd.getById(id);
	}

	@Override
	public void updateGuangGao(Guanggaopic gg) {
		ggd.updateGuangGao(gg);
	}

	@Override
	public List<Guanggaopic> getByPage(String hql, int pageno, int pageSize) {
		return ggd.getByPage(hql, pageno, pageSize);
	}

	@Override
	public String getHql(Guanggaopic g) {
		return ggd.getHql(g);
	}

	@Override
	public Integer getCount(String hql) {
		return ggd.getCount(hql);
	}

}
