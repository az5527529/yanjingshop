package com.action;


import java.sql.Timestamp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.hql.ast.ErrorReporter;

import com.entity.Goods;
import com.entity.Order1;
import com.entity.Shop;
import com.entity.Userinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.GoodsService;
import com.service.OrderService;
import com.service.ShopService;
import com.service.UserinfoService;
import com.tool.Info;
import com.tool.PageInfo;

public class OrderAction extends ActionSupport {
	private OrderService orderService;
	private GoodsService goodsService;
	private UserinfoService userinfoService;
	private ShopService shopService;

	private Shop shop;
	private Shop shop1;
	private Order1 order;
	private Order1 order1;
	private Goods f;
	private Userinfo u;
	private Userinfo u1;
	private PageInfo page;
	private List<Order1> olist;
	private List<Shop> slist;
	private int oid;
	private int id;
	private int uid;
	private double total;
	private int p;


	
//	充值列表
	public String chongZhi(){
		Map<String, Object> session =ActionContext.getContext().getSession();
		Userinfo u=(Userinfo)session.get("user");
		if(u==null){
			return ERROR;
		}else{
			Shop ss=new Shop();
			ss.setState("充值");
			ss.setUserinfo(u);
			hql=shopService.getHql(ss);
			slist=shopService.getShop(hql, 1,shopService.getCount(hql));
			return SUCCESS;
		}
	}
	
	// 充值
	public String doChongZhi() {
		Map<String, Object> session =ActionContext.getContext().getSession();
		Userinfo u1=(Userinfo)session.get("user");
		if(u1==null){
			return ERROR;
		}else{
			u=userinfoService.getById(u1.getUid());
		return SUCCESS;
		}
	}
	// 充值
	public String updateMoney() {
		Map<String, Object> session =ActionContext.getContext().getSession();
		Userinfo u1=(Userinfo)session.get("user");
		  Timestamp time=new Timestamp(System.currentTimeMillis());
		if(u1==null){
			return ERROR;
		}else{
			shop.setIsdel("1");
			shop.setState("充值");
			shop.setOid(time.toString().substring(0, 19));
			Userinfo uu=userinfoService.getById(u1.getUid());
			uu.setMoney(uu.getMoney()+shop.getNum());
			uu.setUid(u1.getUid());
			userinfoService.updateUserinfo(uu);
			shopService.addShop(shop);
			u=userinfoService.getById(u1.getUid());
			session.put("user", uu);
			ActionContext.getContext().setSession(session);
		//	Map<String,Object> session1 = .getSession();e

//			session.put("user", user);
		//	return SUCCESS;
		return SUCCESS;
		}
	}
//	更新订单数量
	public String updateShopNum() {
		shop1 = shopService.getById(id);
		shop1.setNum(shop.getNum());
		shop1.setSid(id);
		shopService.updateShop(shop1);
		return SUCCESS;
	}
	// 处理添加订单
	public String doAddOrder() {
		order = orderService.getById(id);

		return SUCCESS;
	}

	// 结算
	// 添加订单
		public String addOrder() {
			System.out.println("adddd");
			u = (Userinfo) ActionContext.getContext().getSession().get("user");
			if (u == null) {
				return ERROR;
			} else {
				Double dd=u.getMoney();
				Double dd2=order.getSum();
				System.out.println("dd=="+dd+"dd2===="+dd2);
				if(dd<dd2){
					return "error1";
				}else{
				hql = "select s from Shop s where s.state='购物车'  and isdel='1' and s.userinfo.uid='"
						+ u.getUid() + "' ";
				String ono="";
				slist=shopService.getShop(hql, 1, shopService.getCount(hql));
			    Timestamp time=new Timestamp(System.currentTimeMillis());
					u.setMoney(u.getMoney()-order.getSum());
					u.setUid(u.getUid());
					ono=Info.getAutoNo();
					Goods gg=new Goods();
					for(Shop ss:slist){
						
						shop1=shopService.getById(ss.getSid());
						gg=goodsService.getById(shop1.getGoods().getId());
                       if(gg.getKcnum()<shop1.getNum()){
						return "error_kc";	
						}else{
							gg.setKcnum(gg.getKcnum()-shop1.getNum());
							gg.setXnum(gg.getXnum()+shop1.getNum());
							gg.setId(shop1.getGoods().getId());
							shop1.setOid(ono);
							shop1.setState("已支付");
							shop1.setSid(ss.getSid());
							goodsService.update(gg);
							shopService.updateShop(shop1);
						}
						
					}
					Order1 oo=new Order1();
					oo.setSum(order.getSum());
					oo.setDate(time);
					oo.setOno(ono);
					oo.setOstate("已支付，待发货");
					oo.setUserinfo(u);
					oo.setIsdel("1");
					userinfoService.updateUserinfo(u);
					orderService.addOrder(oo);
					return SUCCESS;
					
				}
			}
		}
	/*// 添加订单
	public String addOrder() {
		System.out.println("adddd");
		u = (Userinfo) ActionContext.getContext().getSession().get("user");

		if (u == null) {
			return ERROR;
		} else {

			shop1 = shopService.getById(id);

			shop1.setNum(shop.getNum());
			System.out.println("num=" + shop.getNum());
			shopService.updateShop(shop1);
			shop = shopService.getById(id);
			System.out.println("dddd");
			return SUCCESS;
		}
	}
*/
	// 添加到购物 车
	public String addShop() {
		u = (Userinfo) ActionContext.getContext().getSession().get("user");

		if (u == null) {
			return ERROR;
		} else {
			id=shop.getGoods().getId();
			System.out.println("id="+id);
			shop.setUserinfo(u);
			shop.setIsdel("1");
			shop.setState("购物车");
			shop.setNum(1);
			shopService.addShop(shop);
			hql="select s from Shop s where s.state='购物车' and s.isdel='1' and s.userinfo.uid='"+u.getUid()+"' and s.goods.id='"+id+"' ";
			shop1=shopService.getShop(hql, 1, 1).get(0);
			if (shop1 != null) {
				shop1.setNum(shop1.getNum() + 1);
			} else {
				System.out.println("error");
				shop1.setNum(0);
			}
			shop1.setIsdel("1");
			shopService.updateShop(shop1);
			hql = "select s from Shop s where s.state='购物车' and s.userinfo.uid='"
					+ u.getUid() + "' ";

			if (page == null) {
				page = new PageInfo();

			}
			page.setPageList(shopService.getShop(hql, page.getPageIndex(),
					page.PAGESIZE));
			page.setCount(shopService.getCount(hql));
			return SUCCESS;
		}

	}

	// 查看购物 车
	public String showShop() {
		u = (Userinfo) ActionContext.getContext().getSession().get("user");
		if (u == null) {
			return ERROR;
		} else {

			hql = "select s from Shop s where s.state='购物车' and s.isdel!='0' and s.userinfo.uid='"
					+ u.getUid() + "' ";

			/*if (page == null) {
				page = new PageInfo();

			}
			page.setPageList(shopService.getShop(hql, page.getPageIndex(),
					page.PAGESIZE));
			page.setCount(shopService.getCount(hql));*/
			slist=shopService.getShop(hql, 1, shopService.getCount(hql));
			return SUCCESS;

		}

	}
//   删除购物车
	public String deleteShop(){
		shop=shopService.getById(shop.getSid());
		shop.setIsdel("0");
		shopService.updateShop(shop);
		return SUCCESS;
	}
	// 更新订单
	public String updateOrder() {
		id = order.getShop().getSid();
		Timestamp time=new Timestamp(System.currentTimeMillis());
		order.setDate(time);
		order.setIsdel("1");
		orderService.addOrder(order);
		hql = "select o from Order1 o where o.shop.sid='" + id + "' ";
		order = orderService.getOrder(hql, 1, 1).get(0);
		if (order != null) {
			hql = "select o from Order1 o where o.shop.sid='" + id + "' ";
			order = orderService.getOrder(hql, 1, 1).get(0);

		} else {
			orderService.addOrder(order);
		}
		return SUCCESS;
	}

	// 开始结算订单
	public String updateOrder2() {
		order = orderService.getById(id);
		f = goodsService.getById(order.getGoods().getId());
		return SUCCESS;

	}

	// 结算结果
	public String updateOrder3() {
		order = orderService.getById(id);
		f = goodsService.getById(order.getGoods().getId());
		uid = order.getUserinfo().getUid();
		u = userinfoService.getById(uid);
		order.setIsdel("1");
			order.setOstate("已支付");
			order.setOid(id);
			orderService.updateOrder(order);
			shop = shopService.getById(order.getShop().getSid());
			shop.setState("已支付");
			shopService.updateShop(shop);
			order = orderService.getById(id);
			return SUCCESS;
		
		
	

	}

	// 显示订单的信息
	public String showOrder() {

		hql = "select o from Order1 o where o.ostate='待确认' ";
		order = orderService.getOrder(hql, 1, 1).get(0);
		return SUCCESS;
	}

	String hql = "";

	// 获取session
	public void getSession() {
		u = (Userinfo) ActionContext.getContext().getSession().get("user");
	}

	public void orderList() {

		if (page == null) {
			page = new PageInfo();

		}
		page.setPageList(orderService.getOrder(hql, page.getPageIndex(),
				page.PAGESIZE));
		page.setCount(orderService.getCount(hql));

	}

	// 查询订单
	public String getAllUSalary() {
		hql = orderService.getHql(order);
		orderList();
		return SUCCESS;

	}

	// 查询订单号
	public String getOrderId() {
		order = orderService.getById(order.getOid());
		System.out.println("order=" + order);
		if (order == null) {
			return ERROR;
		} else {

			return SUCCESS;
		}

	}

	// 查询所有的订单(后台)
	public String orderShow() {
		Userinfo u=(Userinfo)ActionContext.getContext().getSession().get("cuser");
		/*if(u.getUname().equals("admin")){
			hql = "select o from Order1 o where o.ostate !='待确认' ";
		}else{
			hql = "select o from Order1 o where o.ostate !='待确认' and o.goods.userinfo.uid="+u.getUid()+" ";
		}*/
		hql = "select o from Order1 o where o.ostate !='待确认' order by o.date desc ";
		orderList();
		return SUCCESS;
	}
//   条件查询订单的信息
	public String queryOrder(){
		Userinfo u=(Userinfo)ActionContext.getContext().getSession().get("cuser");
	//	System.out.println("date==="+order.getDate().toString().substring(0,10));
	/*	String date=order.getDate().toString().substring(0,10);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/
		//Date date1=sdf.parse(date);
		//Timestamp.valueOf(date);
		/*System.out.println("datetime==="+Timestamp.valueOf(date));
		order.setDate(Timestamp.valueOf(date));*/
		hql=orderService.getHql2(order);
		Map session = ActionContext.getContext().getSession();
		int p=2;
		session.put("p", p);
		orderList();
		return SUCCESS;
	}
	// 管理员修改订单状态
	public String updateOrderState() {
		order = orderService.getById(order.getOid());
		order.setOstate("已发货");
		order.setIsdel("1");
		Timestamp time=new Timestamp(System.currentTimeMillis());
		order.setStime(time);
		orderService.updateOrder(order);
		return SUCCESS;
	}
	public String updateOrderTuiHuo(){
		order = orderService.getById(order.getOid());
		order.setOstate("退货");
		Timestamp time=new Timestamp(System.currentTimeMillis());
		order.setEtime(time);
		order.setIsdel("1");
		orderService.updateOrder(order);
		return SUCCESS;
	}
	
//	删除
	public String deleteOrder(){
		orderService.deleteOrder(order);
		return SUCCESS;
	}
	public String updateOrderTuiHuo1(){
		order = orderService.getById(order.getOid());
		order.setOstate("已退货");
		order.setAmount(0);
		order.setIsdel("1");
		u = userinfoService.getById(order.getUserinfo().getUid());
		String price=order.getGoods().getPrice();
		System.out.println("-----------------------------------------------------------");
		System.out.println("price-="+price);
		int amount=Integer.parseInt(price)*order.getAmount();
		System.out.println("-----------------------------------------------------------");
		System.out.println("amount-="+amount);
		//u.setLevel(u.getLevel()-amount);
		
		u.setMoney(u.getMoney()+amount);
		u.setUid(order.getUserinfo().getUid());
		userinfoService.updateUserinfo(u);
		orderService.updateOrder(order);
		return SUCCESS;
	}
	// 查询待确认收货的订单
	public String orderPJ() {
		u = (Userinfo) ActionContext.getContext().getSession().get("user");
		if (u == null) {
			return ERROR;
		} else {
			hql = "select o from Order1 o where o.userinfo.uid='"
					+ u.getUid() + "' and o.ostate like   '%货%' ";
			Integer a= orderService.getCount(hql);
			System.out.println("a="+a);
			/*if(a==0||a==null){
				return ERROR;
			}*/
			orderList();
			return SUCCESS;
		}

	}
	// 确认收货
		public String updateShouHuo() {
			order = orderService.getById(id);
			/*Peisong pp=peisongService.getById(order.getPid());
			pp.setMstatus("空闲中");
			pp.setId(order.getPid());*/
			order.setOstate("确认收货");
			Timestamp time=new Timestamp(System.currentTimeMillis());
			order.setEtime(time);
			orderService.updateOrder(order);
		/*	peisongService.updatePeisong(pp);*/
			return SUCCESS;
		}
	// 评价
	/*public String pj() {
		order = orderService.getById(id);
		Shop ss=new Shop();
		ss.setOid(order.getOno());
		hql=shopService.getHql(ss);
		slist=
		return SUCCESS;
	}*/

	// 保存评价
	public String updatePj() {
		u1 = (Userinfo) ActionContext.getContext().getSession().get("user");
		order1=orderService.getById(order.getOid());
		order1.setPj(order.getPj());
		orderService.updateOrder(order1);
		System.out.println("ui"+u1.getUid());
		u1.setUid(u1.getUid());
		u1.setUstate(1);
		userinfoService.updateUserinfo(u1);
		return SUCCESS;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public UserinfoService getUserinfoService() {
		return userinfoService;
	}

	public ShopService getShopService() {
		return shopService;
	}
	
	public Order1 getOrder1() {
		return order1;
	}

	public void setOrder1(Order1 order1) {
		this.order1 = order1;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}


	public Userinfo getU1() {
		return u1;
	}

	public void setU1(Userinfo u1) {
		this.u1 = u1;
	}

	public Shop getShop1() {
		return shop1;
	}

	public void setShop1(Shop shop1) {
		this.shop1 = shop1;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<Shop> getSlist() {
		return slist;
	}

	public void setSlist(List<Shop> slist) {
		this.slist = slist;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Order1 getOrder() {
		return order;
	}

	public Goods getF() {
		return f;
	}

	public Userinfo getU() {
		return u;
	}

	public PageInfo getPage() {
		return page;
	}

	public List<Order1> getOlist() {
		return olist;
	}

	public int getOid() {
		return oid;
	}

	public int getId() {
		return id;
	}

	public double getTotal() {
		return total;
	}

	public String getHql() {
		return hql;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setUserinfoService(UserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}

	public void setOrder(Order1 order) {
		this.order = order;
	}

	public void setF(Goods f) {
		this.f = f;
	}

	public void setU(Userinfo u) {
		this.u = u;
	}

	public void setPage(PageInfo page) {
		this.page = page;
	}

	public void setOlist(List<Order1> olist) {
		this.olist = olist;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}
	

}
