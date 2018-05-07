package com.dao;

import java.util.List;







import com.entity.Ftype;





public interface FtypeDao {

	public void addFtype(Ftype f);
	
	public Ftype checkname(String uname);
	
	public List<Ftype> getAllFtype();

	public void updateFtype(Ftype f);

	public Ftype getById(int id);

	public void deleteFtype(Ftype c);

	public Integer getCount(String hql);

	public String getHql(Ftype f);

	public List<Ftype> getFtype(String hql,int pageno,int pageSize);

}
