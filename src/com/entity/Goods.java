package com.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private Integer id;
	private Ftype ftype;
/*	private Userinfo usr;*/
	private Integer uid;
	private String price;
	private String season;
	private String isshow;
	private String img;
	private Integer pid;
	private String name;
	private String miaoshu;
	private String area;
	private Timestamp datetime;
	private Integer tuijian;
	private String gid;
	private Integer kcnum;
	private String isdel;
	private Integer xnum;
/*	private Set keeps = new HashSet(0);*/
	private Set order1s = new HashSet(0);
	private Set shops = new HashSet(0);

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** full constructor */

	public Goods(Integer id, Ftype ftype, Integer uid, String price, String season, String isshow, String img,
			Integer pid, String name, String miaoshu, String area, Timestamp datetime, Integer tuijian, String gid,
			Integer kcnum, String isdel, Integer xnum, Set order1s, Set shops) {
		super();
		this.id = id;
		this.ftype = ftype;
		this.uid = uid;
		this.price = price;
		this.season = season;
		this.isshow = isshow;
		this.img = img;
		this.pid = pid;
		this.name = name;
		this.miaoshu = miaoshu;
		this.area = area;
		this.datetime = datetime;
		this.tuijian = tuijian;
		this.gid = gid;
		this.kcnum = kcnum;
		this.isdel = isdel;
		this.xnum = xnum;
		this.order1s = order1s;
		this.shops = shops;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ftype getFtype() {
		return ftype;
	}

	public void setFtype(Ftype ftype) {
		this.ftype = ftype;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getIsshow() {
		return isshow;
	}

	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMiaoshu() {
		return miaoshu;
	}

	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public Integer getTuijian() {
		return tuijian;
	}

	public void setTuijian(Integer tuijian) {
		this.tuijian = tuijian;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public Integer getKcnum() {
		return kcnum;
	}

	public void setKcnum(Integer kcnum) {
		this.kcnum = kcnum;
	}

	public String getIsdel() {
		return isdel;
	}

	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

	public Integer getXnum() {
		return xnum;
	}

	public void setXnum(Integer xnum) {
		this.xnum = xnum;
	}

	public Set getOrder1s() {
		return order1s;
	}

	public void setOrder1s(Set order1s) {
		this.order1s = order1s;
	}

	public Set getShops() {
		return shops;
	}

	public void setShops(Set shops) {
		this.shops = shops;
	}

	// Property accessors

	
}