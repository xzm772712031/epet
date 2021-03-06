package com.neusoft.biz.master.impl;

import java.util.List;

import com.neusoft.biz.master.IMasterBIz;
import com.neusoft.dao.master.IMasterDao;
import com.neusoft.dao.master.impl.MasterDaoImpl;
import com.neusoft.vo.master.Master;

public class MasterBizImpl implements IMasterBIz {
	IMasterDao masterDao = new MasterDaoImpl();

	public Master Login(String name, String pwd) {
		Master master = masterDao.getMaster(name, pwd);
		return master;
	}

	@Override
	public List showlist() {
		List masterList = masterDao.showMaster();
		if (masterList != null) {
			return masterList;
		} else {
			return null;
		}

	}

	@Override
	public Master search(int id) {
		Master master = masterDao.search(id);
		return master;
	}

	@Override
	public int delete(int id) {
		int count = masterDao.delMaster(id);
		if(count!=0) {
			return count;
		}	
		return 0;
	}

	@Override
	public int update(Master master) {
		int count = masterDao.updateMaster(master);
		if(count!=0) {
			return count;
		}	
		return 0;
	
	}

	@Override
	public int add(Master master) {
		int count = masterDao.addMaster(master);
		if(count!=0) {
			return count;
		}	
		return 0;
	}

}
