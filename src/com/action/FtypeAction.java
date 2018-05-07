package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.entity.Ftype;
import com.opensymphony.xwork2.ActionSupport;
import com.service.FtypeService;
import com.tool.PageInfo;

public class FtypeAction extends ActionSupport {
	private FtypeService ftypeService;
	private Ftype ftype;
	private List<Ftype> flist;
	private int id;
	private PageInfo page;
	String hql = "";
    private String name;

	/*
	 * // ��ȡsession public void getSession() { user = (Information)
	 * ActionContext.getContext().getSession() .get("user"); did = (Integer)
	 * ActionContext.getContext().getSession().get("deptid"); }
	 */
	// 验证类别是否存在
	public void checkName() {
		ftype = ftypeService.checkname(name);
		JSONObject obj = new JSONObject();
		if (ftype != null) {
			obj.put("info", "ok");
		} else {

			obj.put("info", "1546");
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.getWriter().print(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public String addFtype() {
		System.out.println("===========" + ftype.getFtype());
		ftype.setIsdel("1");
		ftypeService.addFtype(ftype);
		return SUCCESS;
	}

	public String doUpdate() {
		ftype = ftypeService.getById(id);
		return SUCCESS;
	}

	public String updateFtype() {
		ftype.setIsdel("1");
		ftypeService.updateFtype(ftype);
		return SUCCESS;
	}

	public String deleteFtype() {
		ftype = ftypeService.getById(id);
		ftype.setIsdel("0");
		ftypeService.updateFtype(ftype);
		return SUCCESS;
	}

	public void publicInfo() {
		System.out.println("1112211122");
		flist = ftypeService.getAllFtype();

		if (page == null) {
			page = new PageInfo();
		}

		page.setCount(ftypeService.getCount(hql));
		page.setPageList(ftypeService.getFtype(hql, page.getPageIndex(), page.PAGESIZE));
	}

	public String getAllFtype() {
		hql = ftypeService.getHql(null);
		publicInfo();
		return SUCCESS;
	}

	public String getByFtype() {
		hql = ftypeService.getHql(ftype);
		publicInfo();
		return SUCCESS;
	}
	public FtypeService getFtypeService() {
		return ftypeService;
	}

	public Ftype getFtype() {
		return ftype;
	}

	public List<Ftype> getFlist() {
		return flist;
	}

	public int getId() {
		return id;
	}

	public PageInfo getPage() {
		return page;
	}

	public void setPage(PageInfo page) {
		this.page = page;
	}

	public void setFlist(List<Ftype> flist) {
		this.flist = flist;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFtypeService(FtypeService ftypeService) {
		this.ftypeService = ftypeService;
	}

	public void setFtype(Ftype ftype) {
		this.ftype = ftype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	

}
