package com.service.impi;

import java.util.List;

import com.dao.ShopDao;
import com.entity.Shop;
import com.service.ShopService;

public class ShopServiceImpi implements ShopService {
       private ShopDao sd;
       
	public ShopDao getSd() {
		return sd;
	}

	public void setSd(ShopDao sd) {
		this.sd = sd;
	}

	@Override
	public void addShop(Shop s) {
		sd.addShop(s);
	}

	@Override
	public void updateShop(Shop s) {
		sd.updateShop(s);
	}

	@Override
	public String getHql(Shop s) {
		return sd.getHql(s);
	}

	@Override
	public Integer getCount(String hql) {
		return sd.getCount(hql);
	}

	@Override
	public Shop getById(int id) {
		return sd.getById(id);
	}

	@Override
	public List<Shop> getShop(String hql, int pageno, int pageSize) {
		return sd.getShop(hql, pageno, pageSize);
	}

	@Override
	public void deleteShop(Shop s) {
		sd.deleteShop(s);
	}

}
