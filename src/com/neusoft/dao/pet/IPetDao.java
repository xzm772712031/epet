package com.neusoft.dao.pet;

import com.neusoft.vo.pet.Pet;

public interface IPetDao {
	public int addPet(Pet pet);
	public int delete(Pet pet);
	public int update(Pet pet);
}
