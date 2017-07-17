package com.neusoft.biz.pet.impl;

import com.neusoft.biz.pet.IPetBiz;
import com.neusoft.dao.pet.IPetDao;
import com.neusoft.dao.pet.impl.PetDaoImpl;
import com.neusoft.vo.pet.Pet;

public class PetBizImpl implements IPetBiz {
    IPetDao petdao = new PetDaoImpl();
	@Override
	public int addPet(Pet pet) {
		int count = petdao.addPet(pet);
		if(count!=0) {
			return count;
		}
		return 0;
	}
	@Override
	public int deletePet(Pet pet) {
		int count = petdao.delete(pet);
		if(count!=0) {
			return count;
		}
		return 0;
	}

}
