package com.neusoft.dao.master.impl;

import com.neusoft.dao.master.IMasterDao;
import com.neusoft.vo.master.Master;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.dao.BaseDao;
public class MasterDaoImpl extends BaseDao implements IMasterDao {
	@Override
	public Master getMaster(String name, String pwd) {
			Master master = null;		
			String sql="select * from master where name = ? and password = ?";
			Object[] params={name,pwd};
			res = super.commandQuery(sql, params);
			try {	
				if(res.next()){
					master = new Master();
					master.setId(res.getInt("id"));
					master.setName(res.getString("name"));
					master.setPassword(res.getString("password"));
					master.setMoney(res.getInt("money"));	
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				this.closeAll();
			}
			return master;
		}

	@Override
	public List<Master> showMaster() {
		Master master = null;
		List<Master> masterList = new ArrayList<Master>();
		String sql = "SELECT * FROM MASTER";
		Object[] params ={};
		res = super.commandQuery(sql, params);
		try {
			while(res.next()){
				master = new Master();
				master.setId(res.getInt("id"));
				master.setName(res.getNString("name"));
				master.setMoney(res.getInt("money"));
				masterList.add(master);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		
		return masterList;
		
		
	}

	@Override
	public int addMaster(Master master) {
		int count = 0;
		String sql = "INSERT INTO master(id,name,password,money) VALUES (master_id.nextval,?,?,?) ";
		Object[] params = {master.getName(),master.getPassword(),master.getMoney()};
		count = super.commandUpdate(sql, params);
		
			return count;
		
	}

	@Override
	public int delMaster(int masterId) {
		int count = 0;
		String sql = "DElETE FROM Master WHERE id = ? ";
		Object[] params = {masterId};
		count = super.commandUpdate(sql, params);
		
			return count;
		
	}

	@Override
	public int updateMaster(Master master) {
		int count = 0;
		String sql = "UPDATE Master SET name = ?,password=?,money=? WHERE id = ? ";
		Object[] params = {master.getName(),master.getPassword(),master.getMoney(),master.getId()};
		count = super.commandUpdate(sql, params);
		
			return count;
		
	}

}
