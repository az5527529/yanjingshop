package com.entity;

/**
 * Keep entity. @author MyEclipse Persistence Tools
 */

public class Keep implements java.io.Serializable {

	// Fields

	private Integer kid;
	private Goods goods;
	private Integer uid;
	private String isdel;

	// Constructors

	/** default constructor */
	public Keep() {
	}

	/** full constructor */
	public Keep(Goods goods, Integer uid, String isdel) {
		this.goods = goods;
		this.uid = uid;
		this.isdel = isdel;
	}

	// Property accessors

	public Integer getKid() {
		return this.kid;
	}

	public void setKid(Integer kid) {
		this.kid = kid;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getIsdel() {
		return this.isdel;
	}

	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

}