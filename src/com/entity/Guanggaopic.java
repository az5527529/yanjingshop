package com.entity;

/**
 * Guanggaopic entity. @author MyEclipse Persistence Tools
 */

public class Guanggaopic implements java.io.Serializable {

	// Fields

	private Integer ggid;
	private String ggpic;
	private String name;
	private String note;
	private String isdel;
	private String type;

	// Constructors

	/** default constructor */
	public Guanggaopic() {
	}

	/** full constructor */
	public Guanggaopic(String ggpic, String name, String note,String isdel,String type) {
		this.ggpic = ggpic;
		this.name = name;
		this.note = note;
		this.isdel = isdel;
		this.isdel = type;
	}

	// Property accessors

	public Integer getGgid() {
		return this.ggid;
	}

	public void setGgid(Integer ggid) {
		this.ggid = ggid;
	}

	public String getGgpic() {
		return this.ggpic;
	}

	public void setGgpic(String ggpic) {
		this.ggpic = ggpic;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getIsdel() {
		return isdel;
	}

	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}