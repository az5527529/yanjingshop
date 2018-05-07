package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String uname;
	private String sex;
	private String address;
	private String pwd;
	private Integer level;
	private Integer ustate;
	private String tel;
	private Double money;
	private String mbanswer;
	private String question;
	private String email;
	private String pubtime;
	private String addr;
	private String img;
	private String birth;
	private String qq;
	private String tname;
	/* private String isdel; */
	/* private Set peisongs = new HashSet(0); */
	private Set shops = new HashSet(0);
	private Set order1s = new HashSet(0);

	/* private Set goodss = new HashSet(0); */

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** full constructor */

	// Property accessors

	

	public Integer getUid() {
		return this.uid;
	}

	public Userinfo(Integer uid, String uname, String sex, String address, String pwd, Integer level, Integer ustate,
			String tel, Double money, String mbanswer, String question, String email, String pubtime, String addr,
			String img, String birth, String qq, String tname, Set shops, Set order1s) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.sex = sex;
		this.address = address;
		this.pwd = pwd;
		this.level = level;
		this.ustate = ustate;
		this.tel = tel;
		this.money = money;
		this.mbanswer = mbanswer;
		this.question = question;
		this.email = email;
		this.pubtime = pubtime;
		this.addr = addr;
		this.img = img;
		this.birth = birth;
		this.qq = qq;
		this.tname = tname;
		this.shops = shops;
		this.order1s = order1s;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getUstate() {
		return this.ustate;
	}

	public void setUstate(Integer ustate) {
		this.ustate = ustate;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getMbanswer() {
		return this.mbanswer;
	}

	public void setMbanswer(String mbanswer) {
		this.mbanswer = mbanswer;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPubtime() {
		return pubtime;
	}

	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	/*
	 * public Set getPeisongs() { return this.peisongs; }
	 * 
	 * public void setPeisongs(Set peisongs) { this.peisongs = peisongs; }
	 */
	public Set getShops() {
		return this.shops;
	}

	public void setShops(Set shops) {
		this.shops = shops;
	}

	public Set getOrder1s() {
		return this.order1s;
	}

	public void setOrder1s(Set order1s) {
		this.order1s = order1s;
	}

	/*
	 * public Set getGoodss() { return goodss; }
	 * 
	 * public void setGoodss(Set goodss) { this.goodss = goodss; }
	 */
	/*
	 * public String getIsdel() { return isdel; }
	 * 
	 * public void setIsdel(String isdel) { this.isdel = isdel; }
	 */

}