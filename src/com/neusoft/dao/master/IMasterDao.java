package com.neusoft.dao.master;

import java.util.List;

import com.neusoft.vo.master.Master;

public interface IMasterDao {
	public Master getMaster(String name,String pwd);
	public Master search(int id);
	public int addMaster(Master master);
	public List<Master> showMaster();
	public int delMaster(int masterId);
	public int updateMaster(Master master);
	
	
}
