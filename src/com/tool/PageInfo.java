package com.tool;

import java.util.List;

//��ҳ�Ĺ�����
public class PageInfo {
	public static final int PAGESIZE=6;
	//ͳ��������
	private int count;
	//��ǰҳ����ݼ���
	private List pageList;
	//��ǰҳ��
	private int pageIndex=1;
	//�ܵ�ҳ��
	private int totalpages;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List getPageList() {
		return pageList;
	}
	public void setPageList(List pageList) {
		this.pageList = pageList;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}
	//������ҳ��
	public int getTotalpages(){
		
		this.totalpages=this.count/this.PAGESIZE;
		if(this.count%this.PAGESIZE!=0){
			
			this.totalpages++;
		}
		return this.totalpages;
		
	}

}
