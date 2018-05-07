package com.entity;

import java.sql.Timestamp;

/**
 * Order1 entity. @author MyEclipse Persistence Tools
 */

public class Order1 implements java.io.Serializable {

	// Fields

	private Integer oid;
	private Shop shop;
	private Integer pid;
	private Goods goods;
	private Userinfo userinfo;
	private String pj;
	private String ostate;
	private Timestamp date;
	private Timestamp stime;
	private Timestamp etime;
	private Integer amount;
	private Integer jiesuan;
	private String uname;
	private String tel;
	private String address;
	private Double sum;
	private String qita1;
	private String isdel;
	private String ono;

	// Constructors

	/** default constructor */
	public Order1() {
	}

	public Order1(Integer oid, Shop shop, Integer pid, Goods goods, Userinfo userinfo, String pj, String ostate,
			Timestamp date, Timestamp stime, Timestamp etime, Integer amount, Integer jiesuan, String uname, String tel,
			String address, Double sum, String qita1, String isdel, String ono) {
		super();
		this.oid = oid;
		this.shop = shop;
		this.pid = pid;
		this.goods = goods;
		this.userinfo = userinfo;
		this.pj = pj;
		this.ostate = ostate;
		this.date = date;
		this.stime = stime;
		this.etime = etime;
		this.amount = amount;
		this.jiesuan = jiesuan;
		this.uname = uname;
		this.tel = tel;
		this.address = address;
		this.sum = sum;
		this.qita1 = qita1;
		this.isdel = isdel;
		this.ono = ono;
	}

	/** full constructor */
	
	
	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}


	

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getPj() {
		return this.pj;
	}

	public void setPj(String pj) {
		this.pj = pj;
	}

	public String getOstate() {
		return this.ostate;
	}

	public void setOstate(String ostate) {
		this.ostate = ostate;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getJiesuan() {
		return this.jiesuan;
	}

	public void setJiesuan(Integer jiesuan) {
		this.jiesuan = jiesuan;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getSum() {
		return this.sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public String getQita1() {
		return this.qita1;
	}

	public void setQita1(String qita1) {
		this.qita1 = qita1;
	}

	public Timestamp getStime() {
		return stime;
	}

	public void setStime(Timestamp stime) {
		this.stime = stime;
	}

	public Timestamp getEtime() {
		return etime;
	}

	public void setEtime(Timestamp etime) {
		this.etime = etime;
	}

	public String getIsdel() {
		return isdel;
	}

	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

	public String getOno() {
		return ono;
	}

	public void setOno(String ono) {
		this.ono = ono;
	}
	

}