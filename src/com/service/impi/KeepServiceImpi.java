package com.service.impi;

import java.util.List;

import com.dao.KeepDao;
import com.entity.Keep;
import com.service.KeepService;

public class KeepServiceImpi implements KeepService {
   private KeepDao kd;
   
	public KeepDao getKd() {
	return kd;
}

public void setKd(KeepDao kd) {
	this.kd = kd;
}

	@Override
	public void addKeep(Keep f) { 
		kd.addKeep(f);
	}

	@Override
	public void updateKeep(Keep f) {
		kd.updateKeep(f);
	}

	@Override
	public String getHql(Keep f) {
		return kd.getHql(f);
	}

	@Override
	public Integer getCount(String hql) {
		return kd.getCount(hql);
	}

	@Override
	public Keep getById(int id) {
		return kd.getById(id);
	}

	@Override
	public List<Keep> getKeep(String hql, int pageno, int pageSize) {
		return kd.getKeep(hql, pageno, pageSize);
	}

	@Override
	public void deleteKeep(Keep f) {
		kd.deleteKeep(f);
	}

	@Override
	public List<Keep> getByUid(int uid) {
		return kd.getByUid(uid);
	}

}
