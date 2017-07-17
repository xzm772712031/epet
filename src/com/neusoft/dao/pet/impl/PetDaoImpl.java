package com.neusoft.dao.pet.impl;

import com.neusoft.dao.BaseDao;
import com.neusoft.dao.pet.IPetDao;
import com.neusoft.vo.pet.Pet;

public class PetDaoImpl extends BaseDao implements IPetDao {

	@Override
	public int addPet(Pet pet) {
		int count = 0;
		String sql = "insert into pet values (PET_ID.nextval,?,?,?,?) ";
		Object[] params={pet.getName(),pet.getHealth(),pet.getLove(),pet.getStrain()};
		count = super.commandUpdate(sql, params);
		if(count!=0){	
			return count;
			}
			return 0;
			
	}

	@Override
	public int delete(Pet pet) {
		int count = 0;
		String sql = "delete from pet where id = ? or name =?";
		Object[] params = {pet.getId(),pet.getName()};
		count = super.commandUpdate(sql, params);
		if(count!=0) {
			
			return count;
		}
		return 0;
	}

	@Override
	public int update(Pet pet) {
		// TODO Auto-generated method stub
		return 0;
	}

}
