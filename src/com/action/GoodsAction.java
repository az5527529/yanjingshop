package com.action;

import java.io.File;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.Text;

import com.entity.Goods;
import com.entity.Ftype;
import com.entity.Guanggaopic;
import com.entity.Order1;
import com.entity.Userinfo;
import com.mysql.fabric.xmlrpc.base.Array;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.GoodsService;
import com.service.FtypeService;
import com.service.GuangGaoService;
import com.service.OrderService;
import com.service.UserinfoService;
import com.tool.Info;
import com.tool.PageInfo;

public class GoodsAction extends ActionSupport {
	private GoodsService goodsService;
	private FtypeService ftypeService;
	private OrderService orderService;
	private GuangGaoService guangGaoService;
	private UserinfoService userinfoService;

	private Userinfo ui;
	private Guanggaopic gg;
	private Guanggaopic gg1;
	private Goods goods;
	private Goods f1;
	private Goods f2;
	private Goods f3;
	private Goods f4;
	private Goods f5;
	private PageInfo page;
	private Ftype ftype;
	private List<Order1> olist;
	private List<HashMap> rslist;
	private List<Integer> nlist;
	private Order1 o;
	private int p;
	private int gid;
	private Date starttime;
	private Date endtime;
	private String xmlstr;
	private String note;

	private List<Goods> flist;
	private List<Goods> glist;
	private List<Ftype> ftlist;
	private List<Guanggaopic> gglist;
	private List<Guanggaopic> gpiclist;

	private int id;
	private int did;
	private int pid;
	private int fid;
	private String uname;

	String hql = "";

	public void publicInfo() {
		ftlist = ftypeService.getAllFtype();
		System.out.println("ftlist=" + ftlist);
		// plist = peisongService.getPeisong();
		if (page == null) {
			page = new PageInfo();
		}
	}

	// 处理添加信息
	public String doAdd() {
		publicInfo();
		return SUCCESS;
	}
	
	public String tongGuo() {
		goods=goodsService.getById(id);
		goods.setIsdel("通过审核");
		goods.setId(id);
		goodsService.update(goods);
		return SUCCESS;
	}
	

	// 添加信息
	public String addGoods() {
		// 文件上传
		String path = ServletActionContext.getServletContext().getRealPath("/") + "admin/upload/";
		System.out.println(path);
		File file = new File(path + fileName);
		String t = new Timestamp(System.currentTimeMillis()).toString();
		StringBuffer str = new StringBuffer("sp");
		Userinfo user = (Userinfo) ActionContext.getContext().getSession().get("cuser");
		goods.setUid(user.getUid());
		goods.setIsdel("待审核");
		String gid = Info.getID();
		goods.setGid(gid);
		if (fileName == null) {
			goods.setImg("zanwu.jpg");
		} else {
			try {
				FileUtils.copyFile(files, file);
				goods.setImg(fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Timestamp time = new Timestamp(System.currentTimeMillis());
		goods.setDatetime(time);
		goods.setMiaoshu(note);
		System.out.println("文件上传成功！");
		goodsService.add(goods);
		return SUCCESS;
	}

	// 添加广告图片信息
	public String addGuangGaoPic() {
		// 文件上传
		String path = ServletActionContext.getServletContext().getRealPath("/") + "admin/upload/";
		System.out.println(path);
		File file = new File(path + fileName);
		if (fileName == null || fileName.equals("")) {
			gg.setGgpic("zanwu.jpg");
		} else {
			try {
				FileUtils.copyFile(files, file);
				System.out.println("fileName" + files);
				gg.setGgpic(fileName);

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		System.out.println("文件上传成功！");
		gg.setIsdel("1");
		guangGaoService.addGuangGao(gg);
		return SUCCESS;
	}


	// 显示广告图片信息
	public String showGuangGaoPic() {
		gglist = guangGaoService.getAll();
		return SUCCESS;
	}

	public void gglist() {
		if (page == null) {
			page = new PageInfo();
		}
		page.setCount(guangGaoService.getCount(hql));
		page.setPageList(guangGaoService.getByPage(hql, page.getPageIndex(), page.PAGESIZE));
	}


	public String updateGuangGao() {
		gg = guangGaoService.getById(gg.getGgid());
		return SUCCESS;
	}

	public String updateGuangGao3() {
		gg1 = guangGaoService.getById(gg.getGgid());
		gg1.setName(gg.getName());
		gg1.setNote(gg.getNote());
		guangGaoService.updateGuangGao(gg1);
		return SUCCESS;
	}

	public String updateGuangGao2() {
		// 文件上传
		String path = ServletActionContext.getServletContext().getRealPath("/") + "admin/upload/";
		System.out.println(path);
		File file = new File(path + fileName);
		if (files == null || files.equals("")) {
			gg1 = guangGaoService.getById(gg.getGgid());
			fileName = gg1.getGgpic();
		} else {
			try {
				FileUtils.copyFile(files, file);
				System.out.println("fileName" + files);

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		System.out.println("文件上传成功！");
		gg.setGgpic(fileName);
		gg.setIsdel("1");
		guangGaoService.updateGuangGao(gg);
		return SUCCESS;
	}

	// 删除广告图片信息
	public String deleteGuangGaoPic() {
		gg = guangGaoService.getById(gg.getGgid());
		gg.setIsdel("0");
		guangGaoService.updateGuangGao(gg);
		return SUCCESS;
	}

	public void cand() {
		publicInfo();
		page.setCount(goodsService.getCount(hql));
		page.setPageList(goodsService.get(hql, page.getPageIndex(), page.PAGESIZE));
	}

	// 信息并分页
	public String goodsList() {
		Userinfo u = (Userinfo) ActionContext.getContext().getSession().get("cuser");
		String name = (String) ActionContext.getContext().getSession().get("qname");

		if (name == null || name.equals("")) {
			return ERROR;
		}
		System.out.println("uname===" + u.getUname());
		System.out.println("uname==++==" + name);
		System.out.println("uname==" + name);
		if (!name.equals("admin")) {
			Userinfo u1 = userinfoService.getByName(name);
			u1.setUid(u1.getUid());
			Goods g = new Goods();
			g.setUid(u1.getUid());
			hql = goodsService.getHql(g);
		} else {
			hql = goodsService.getHql(null);
		}
		ftlist = ftypeService.getAllFtype();
		cand();
		return SUCCESS;
	}

	// 查询信息并分页
	public String goodsQuery() {
		Userinfo user = (Userinfo) ActionContext.getContext().getSession().get("cuser");
		if (user.equals("admin")) {
			hql = goodsService.getHql(goods);
		} else {
			/* goods.setUsr(user); */
			hql = goodsService.getHql(goods);
		}
		cand();
		return SUCCESS;
	}

	public String doUpdateGoods() {
		publicInfo();
		goods = goodsService.getById(id);
		System.out.println("id=" + goods);
		return SUCCESS;
	}

	// 修改信息
	public String updateGoods() {
		// 文件上传
		String path = ServletActionContext.getServletContext().getRealPath("/") + "admin/upload/";
		System.out.println(path + "---" + fileName);

		File file = new File(path + fileName);
		if (fileName == null || fileName.equals("")) {
			f1 = goodsService.getById(goods.getId());
			fileName = f1.getImg();
		} else {
			try {

				FileUtils.copyFile(files, file);

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		Timestamp time = new Timestamp(System.currentTimeMillis());
		goods.setDatetime(time);
		goods.setImg(fileName);
		System.out.println("文件上传成功！");
		goodsService.update(goods);
		return SUCCESS;
	}

	// 删除信息
	public String deleteGoods() {
		goods = goodsService.getById(id);
		goods.setIsdel("0");
		goodsService.delete(goods);
		return SUCCESS;
	}

	// 处理前台首页信息
	public String doShowIndex() {
		// 首页显示的广告
		hql = guangGaoService.getHql(null);
		gglist = guangGaoService.getByPage(hql, 1, 8);
		gpiclist = guangGaoService.getByPage(hql, 1, 5);

		// 首页显示的种类
		ftlist = ftypeService.getAllFtype();
		/* plist = peisongService.getPeisong(); */
		hql = "select f from Goods f where f.isdel='通过审核'  order by f.datetime desc ";

		if (page == null) {
			page = new PageInfo();
		}
		// 显示最近添加的10种
		page.setPageList(goodsService.get(hql, 1, 10));
		glist =goodsService.get(hql, 1, 12);
		hql = "SELECT o FROM Order1 o WHERE o.ostate LIKE '%货%' GROUP BY o.goods.id ORDER BY SUM(o.amount)DESC ";
		olist = orderService.getOrder(hql, 1, 9);
		hql = "select f from Goods f where f.isdel='通过审核'  order by f.xnum desc ";
		flist = goodsService.get(hql, 1, 12);
		return SUCCESS;
	}

	// 显示单个信息
	public String showGoods() {
		goods = goodsService.getById(id);
		System.out.println("id=" + id);
		// o.getGoods().setId(Goods.getId());
		hql = "select o from Order1 o where o.goods.id='" + id + "' ";
		olist = orderService.getOrder(hql, 1, orderService.getCount(hql));
		/*
		 * Bbs bb=new Bbs(); bb.setGid(id); bb.setSta("1");
		 * hql=bbsService.getHql(bb); blist=bbsService.get(hql, 1,
		 * bbsService.getCount(hql));
		 */
		return SUCCESS;
	}

	// 显示某一类的信息的公共部分
	public void publicType() {
		if (page == null) {
			page = new PageInfo();
		}
		page.setCount(goodsService.getCount(hql));
		System.out.println("数量" + page.getCount());
		page.setPageList(goodsService.get(hql, page.getPageIndex(), page.PAGESIZE));
	}

	// 查询促销
	public String showListGoods() {
		hql = goodsService.getHql(goods);
		publicType();
		return SUCCESS;
	}

	// 查询同一类别
	public String showType() {
		f3.setIsdel("通过审核");
		hql = goodsService.getHql(f3);
		publicType();
		return SUCCESS;
	}

	// 查询价格
	public String showPrice() {
		hql = goodsService.getHql(f4);
		publicType();
		return SUCCESS;
	}

	// 查询推荐
	public String showJieRi() {
		hql = goodsService.getHql(f5);
		publicType();
		return SUCCESS;
	}

	// 查询所有
	public String showNew() {
		hql = "select f from Goods f where f.isshow='是' and f.isdel='通过审核' order by f.xnum desc ";
		publicType();
		return SUCCESS;
	}

	public String showNew2() {
		hql = "select f from Goods f where f.isdel='通过审核' order by f.datetime desc ";
		publicType();
		return SUCCESS;
	}

	public String showNew3() {
		hql = "select f from Goods f where f.ftype.fid='3' order by f.datetime desc ";
		publicType();
		return SUCCESS;
	}

	public String showNew4() {
		hql = "select f from Goods f where f.ftype.fid='4' order by f.datetime desc ";
		publicType();
		return SUCCESS;
	}

	public String searchh() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Userinfo u=(Userinfo)session.get("cuser");
		if(u.getLevel()==2){
			f1.setUid(u.getUid());
		}
		if (page == null) {
			page = new PageInfo();
		}
		hql = goodsService.getHql(f1);
		page.setCount(goodsService.getCount(hql));
		page.setPageList(goodsService.get(hql, page.getPageIndex(), page.PAGESIZE));
		p = 3;
		ftlist = ftypeService.getAllFtype();
		session.put("p", p);
		return SUCCESS;
	}
	// 首页搜索查询
	public String search() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (page == null) {
			page = new PageInfo();
		}
		f1.setIsdel("通过审核");
		hql = goodsService.getHql(f1);
		page.setCount(goodsService.getCount(hql));
		page.setPageList(goodsService.get(hql, page.getPageIndex(), page.PAGESIZE));
		p = 3;
		ftlist = ftypeService.getAllFtype();
		session.put("p", p);
		return SUCCESS;
	}

	public String searchPersion() {
		if (page == null) {
			page = new PageInfo();
		}
		System.out.println("f1=" + f1);
		hql = goodsService.getHql(f1);
		page.setCount(goodsService.getCount(hql));
		page.setPageList(goodsService.get(hql, page.getPageIndex(), page.PAGESIZE));
		p = 3;
		Map session = ActionContext.getContext().getSession();
		session.put("p", p);
		return SUCCESS;
	}

	// 统计分析
	public void selectTongji() {
		System.out.println("开始时间" + starttime);
		System.out.println("结束时间" + endtime);
		// hql="SELECT new Map( o.date as date1,SUM(o.amount) as sum1) FROM
		// Order1 o "+
		// " WHERE o.ostate LIKE '%货%' and date BETWEEN '"+starttime+"' AND
		// '"+endtime+
		// "' GROUP BY o.date ORDER BY o.date DESC";
		// olist=orderService.getOrder(hql, 1, orderService.getCount(hql));
		List<Object[]> objlist = orderService.getTongJi(starttime, endtime);
		System.out.println("aaaaaaaaaaa==" + objlist.size());
		xmlstr = "<graph showNames='1'  decimalPrecision='0'  > ";
		for (int i = 0; i < objlist.size(); i++) {
			Object[] oo = objlist.get(i);
			xmlstr += "<set name='" + oo[0] + "' value='" + oo[1] + "'/> ";
		}
		xmlstr += "</graph>";
		System.out.println("xml==" + xmlstr);
		// System.out.println("ccccccccccccccccccc=="+olist.size());
		// 把集合转换为jsonarray
		// JSONArray array=JSONArray.fromObject(olist);
		JSONObject obj = new JSONObject();
		obj.put("xmlstr", xmlstr);
		// obj.put("list", array);
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.getWriter().print(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String showGG() {
		gg = guangGaoService.getById(gg.getGgid());
		return SUCCESS;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<HashMap> getRslist() {
		return rslist;
	}

	public void setRslist(List<HashMap> rslist) {
		this.rslist = rslist;
	}

	public List<Integer> getNlist() {
		return nlist;
	}

	public void setNlist(List<Integer> nlist) {
		this.nlist = nlist;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public GuangGaoService getGuangGaoService() {
		return guangGaoService;
	}

	public void setGuangGaoService(GuangGaoService guangGaoService) {
		this.guangGaoService = guangGaoService;
	}

	public Guanggaopic getGg() {
		return gg;
	}

	public void setGg(Guanggaopic gg) {
		this.gg = gg;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public Goods getF5() {
		return f5;
	}

	public void setF5(Goods f5) {
		this.f5 = f5;
	}

	public Goods getF3() {
		return f3;
	}

	public void setF3(Goods f3) {
		this.f3 = f3;
	}

	public Goods getF4() {
		return f4;
	}

	public void setF4(Goods f4) {
		this.f4 = f4;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public List<Order1> getOlist() {
		return olist;
	}

	public void setOlist(List<Order1> olist) {
		this.olist = olist;
	}

	public Order1 getO() {
		return o;
	}

	public void setO(Order1 o) {
		this.o = o;
	}

	public Goods getF1() {
		return f1;
	}

	public void setF1(Goods f1) {
		this.f1 = f1;
	}

	public Goods getF2() {
		return f2;
	}

	public void setF2(Goods f2) {
		this.f2 = f2;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}


	public List<Guanggaopic> getGpiclist() {
		return gpiclist;
	}

	public void setGpiclist(List<Guanggaopic> gpiclist) {
		this.gpiclist = gpiclist;
	}

	public List<Guanggaopic> getGglist() {
		return gglist;
	}

	public void setGglist(List<Guanggaopic> gglist) {
		this.gglist = gglist;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getSid() {
		return fid;
	}

	public void setSid(int fid) {
		this.fid = fid;
	}

	// 文件上传
	private File files;
	private String fileName;


	public FtypeService getFtypeService() {
		return ftypeService;
	}

	public Ftype getFtype() {
		return ftype;
	}

	public List<Goods> getFlist() {
		return flist;
	}

	public List<Ftype> getFtlist() {
		return ftlist;
	}

	public void setFtypeService(FtypeService ftypeService) {
		this.ftypeService = ftypeService;
	}

	public void setFtype(Ftype ftype) {
		this.ftype = ftype;
	}

	public void setFlist(List<Goods> flist) {
		this.flist = flist;
	}

	public void setFtlist(List<Ftype> ftlist) {
		this.ftlist = ftlist;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public File getFiles() {
		return files;
	}

	public void setFiles(File files) {
		this.files = files;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFilesFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PageInfo getPage() {
		return page;
	}

	public void setPage(PageInfo page) {
		this.page = page;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public UserinfoService getUserinfoService() {
		return userinfoService;
	}

	public void setUserinfoService(UserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}

	public Userinfo getUi() {
		return ui;
	}

	public void setUi(Userinfo ui) {
		this.ui = ui;
	}

	public Guanggaopic getGg1() {
		return gg1;
	}

	public void setGg1(Guanggaopic gg1) {
		this.gg1 = gg1;
	}


	public List<Goods> getGlist() {
		return glist;
	}

	public void setGlist(List<Goods> glist) {
		this.glist = glist;
	}

}
