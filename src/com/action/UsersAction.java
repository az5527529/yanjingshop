package com.action;

import java.io.IOException;


import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.entity.Userinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserinfoService;
import com.tool.PageInfo;

public class UsersAction extends ActionSupport {
	private UserinfoService userinfoService;
	private List<Userinfo> ulist;

	private Userinfo user;
	private Userinfo cuser;
	private PageInfo page;
	private String uname;
	private String pwd;
    private int p;
    private int id;
    
    
	
	String hql = "";

	// 修改用户密码
	public String updatePwd() {
		cuser=userinfoService.getById(user.getUid());
		cuser.setPwd(user.getPwd());
		cuser.setUid(user.getUid());
		userinfoService.updateUserinfo(cuser);
		return SUCCESS;
	}
//	处理个人信息修改
	public String showPersion() {
		Map<String,Object> session=ActionContext.getContext().getSession();
		Userinfo u=(Userinfo)session.get("user");
		if(u==null){
			return ERROR;
		}else{
			user=userinfoService.getById(u.getUid());
			return SUCCESS;
		}
	
	}
	
	public void list() {
		if (page == null) {
			page = new PageInfo();
		}
		page.setCount(userinfoService.getUserCount(hql));
		page.setPageList(userinfoService.getUserinfo(hql, page.getPageIndex(),
				page.PAGESIZE));
	}

	// 获取所有用户信息 并分页
	public String showList() {
		hql = "select u from Userinfo u where u.ustate!=0 and u.level!='2' order by u.uid desc";
		list();
		return SUCCESS;
	}
	public String showList2() {
		hql = "select u from Userinfo u where u.ustate!=0 and u.level='2' order by u.uid desc";
		list();
		return SUCCESS;
	}
	public String showPersonList() {
		Userinfo u=(Userinfo)ActionContext.getContext().getSession().get("cuser");
		if(u==null){
			return ERROR;
		}
		user=userinfoService.getById(u.getUid());
		return SUCCESS;
	}
	public String showClientList() {
		Userinfo user=new Userinfo();
		user.setLevel(1);
		hql="select u from Userinfo u where u.ustate!=0 and u.level!=3 and u.level!=2 order by u.uid desc";
		//hql = userinfoService.getHql(user);
		list();
		return SUCCESS;
	}
	
	public String queryClientList() {
		user.setLevel(3);
		hql = userinfoService.getHql(user);
		p=3;
		Map<String,Object> session = ActionContext.getContext().getSession();
		session.put("p", p);
		list();
		return SUCCESS;
	}

	// 查询并分页
	public String queryList() {
		user.setLevel(1);
		hql = userinfoService.getHql(user);
		p=1;
		Map<String,Object> session = ActionContext.getContext().getSession();
		session.put("p", p);
		list();
		return SUCCESS;
	}
	public String queryList2() {
		user.setLevel(2);
		hql = userinfoService.getHql(user);
		p=1;
		Map<String,Object> session = ActionContext.getContext().getSession();
		session.put("p", p);
		list();
		return SUCCESS;
	}
//	删除用户
	public String deleteUser(){
		user=userinfoService.getById(id);
		user.setUstate(0);
		userinfoService.updateUserinfo(user);
		return SUCCESS;
	}

	// 验证用户名是否存在
	public void checkName() {
		user = userinfoService.checkname(uname);
		JSONObject obj = new JSONObject();
		if (user != null) {
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

	// 新用户注册
	public String addUser() {
		user.setLevel(1);
		user.setUstate(1);
		user.setPubtime(new Timestamp(System.currentTimeMillis()).toString().substring(0,19));
		userinfoService.addUserinfo(user);
		//ps.setUserinfo(user);
		/*ps.setUaddress(user.getAddress());
		ps.setUname(user.getUname());
		peisongService.addPeisong(ps);*/
		return SUCCESS;
	}
	public String addUser2() {
		//user.setLevel(1);
		user.setPubtime(new Timestamp(System.currentTimeMillis()).toString().substring(0,19));
		user.setUstate(1);
		userinfoService.addUserinfo(user);
		return SUCCESS;
	}
	public String doUpdateUser(){
		user=userinfoService.getById(id);
		return SUCCESS;
	}
	//更新用户的信息
    public String updateUser(){
    	userinfoService.updateUserinfo(user);
    	return SUCCESS;
    }
    
    
    
	// 验证前台登陆
	public String loginFore() {
		user = userinfoService.checkLogin(user.getUname(), user.getPwd());
		if (user != null) {
			Map<String,Object> session = ActionContext.getContext().getSession();
			session.put("user", user);
			return SUCCESS;
		} else {
			return "error";
		}
	}
	// 验证后台登陆
	public String login() {
		System.out.println("---"+cuser.getUname());
		System.out.println("---"+cuser.getPwd());
		user = userinfoService.checkLogin(cuser.getUname(), cuser.getPwd());
		if (user != null&&user.getLevel()!=1) {
			Map<String,Object> session = ActionContext.getContext().getSession();
			session.put("cuser", user);
			session.put("qname", user.getUname());
			System.out.println("uname=--=="+session.get("qname"));
			
			return SUCCESS;
		} else  {
			
			return ERROR;
		}
	}



	// 注销
	public String exit() {
		System.out.println("cuser===="+ActionContext.getContext().getSession().get("cuser"));
		ActionContext.getContext().getSession().remove("user");
		ActionContext.getContext().getSession().remove("cuser");
		System.out.println("cuser222===="+ActionContext.getContext().getSession().get("cuser"));
		ActionContext.getContext().getSession().remove("p");
		while(ActionContext.getContext().getSession().get("cuser")!=null){
			ActionContext.getContext().getSession().remove("cuser");
		}
		return SUCCESS;
	}
//	找回密码
	public String getByPwd(){
		user=userinfoService.getByName(user.getUname());
		System.out.println("user="+user);
		if(user==null){
			return ERROR;
		}
		    return SUCCESS;
	}
//	判断密保答案是否正确
	public void getMiBao(){
		cuser=userinfoService.getById(user.getUid());
		System.out.println("--------------------"+cuser.getPwd());
		System.out.println("--------------------"+cuser.getQuestion());
		System.out.println("--------------------"+user.getQuestion());
		JSONObject obj = new JSONObject();
		if(cuser.getQuestion().equals(user.getQuestion())){
				obj.put("info", cuser.getPwd());
			}else{
				obj.put("info", "ng");
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			System.out.println("info"+obj);
			try {
				response.getWriter().print(obj);
				
			} catch (IOException e) {
				e.printStackTrace();
			}

		
		
	}
	

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public UserinfoService getUserinfoService() {
		return userinfoService;
	}

	public List<Userinfo> getUlist() {
		return ulist;
	}

	public Userinfo getUser() {
		return user;
	}

	public Userinfo getCuser() {
		return cuser;
	}

	public PageInfo getPage() {
		return page;
	}

	public String getUname() {
		return uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setUserinfoService(UserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}

	public void setUlist(List<Userinfo> ulist) {
		this.ulist = ulist;
	}

	public void setUser(Userinfo user) {
		this.user = user;
	}

	public void setPage(PageInfo page) {
		this.page = page;
	}

	public void setCuser(Userinfo cuser) {
		this.cuser = cuser;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

}
