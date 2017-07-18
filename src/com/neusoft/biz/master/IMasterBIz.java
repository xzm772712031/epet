package com.neusoft.biz.master;

import java.util.List;

import com.neusoft.vo.master.Master;

public interface IMasterBIz {
	public Master Login(String name,String pwd);
	public List showlist();
    public Master search(int id);
    public int delete(int id);
    public int update(Master master);
    public int add(Master master);
}
