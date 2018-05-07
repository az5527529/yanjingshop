package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Ftype entity. @author MyEclipse Persistence Tools
 */

public class Ftype implements java.io.Serializable {

	// Fields

	private Integer fid;
	private String ftype;
	private String isdel;
	private Set goodss = new HashSet(0);

	// Constructors

	/** default constructor */
	public Ftype() {
	}

	/** full constructor */
	
	// Property accessors

	public Ftype( String ftype, String isdel, Set goodss) {
		this.ftype = ftype;
		this.isdel = isdel;
		this.goodss = goodss;
	}

	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getFtype() {
		return this.ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public Set getgoodss() {
		return this.goodss;
	}

	public void setgoodss(Set goodss) {
		this.goodss = goodss;
	}

	public String getIsdel() {
		return isdel;
	}

	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

	public Set getGoodss() {
		return goodss;
	}

	public void setGoodss(Set goodss) {
		this.goodss = goodss;
	}

	
}