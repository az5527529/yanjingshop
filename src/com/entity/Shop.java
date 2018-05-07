package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Shop entity. @author MyEclipse Persistence Tools
 */

public class Shop implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Goods goods;
	private Userinfo userinfo;
	private String state;
	private Integer num;
	private String isdel;
	private String oid;
	private Set order1s = new HashSet(0);

	// Constructors

	/** default constructor */
	public Shop() {
	}

	/** full constructor */

	// Property accessors

	public Shop(Integer sid, Goods goods, Userinfo userinfo, String state, Integer num, String isdel, String oid,
			Set order1s) {
		super();
		this.sid = sid;
		this.goods = goods;
		this.userinfo = userinfo;
		this.state = state;
		this.num = num;
		this.isdel = isdel;
		this.oid = oid;
		this.order1s = order1s;
	}

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
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

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Set getOrder1s() {
		return this.order1s;
	}

	public void setOrder1s(Set order1s) {
		this.order1s = order1s;
	}

	public String getIsdel() {
		return isdel;
	}

	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	
}