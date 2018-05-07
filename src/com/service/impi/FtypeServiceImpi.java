package com.service.impi;

import java.util.List;

import com.dao.FtypeDao;
import com.entity.Ftype;
import com.service.FtypeService;

public class FtypeServiceImpi implements FtypeService {
	private FtypeDao fd;

	public FtypeDao getFd() {
		return fd;
	}

	public void setFd(FtypeDao fd) {
		this.fd = fd;
	}

	@Override
	public void addFtype(Ftype f) {
		fd.addFtype(f);
	}

	@Override
	public List<Ftype> getAllFtype() {
		return fd.getAllFtype();
	}

	@Override
	public void updateFtype(Ftype f) {
		fd.updateFtype(f);
	}

	@Override
	public void deleteFtype(Ftype c) {
		fd.deleteFtype(c);
	}

	@Override
	public Ftype getById(int id) {
		return fd.getById(id);
	}

	@Override
	public Integer getCount(String hql) {
		return fd.getCount(hql);
	}

	@Override
	public String getHql(Ftype f) {
		return fd.getHql(f);
	}

	@Override
	public List<Ftype> getFtype(String hql, int pageno, int pageSize) {
		return fd.getFtype(hql, pageno, pageSize);
	}

	@Override
	public Ftype checkname(String uname) {
		return fd.checkname(uname);
	}

}
