package com.neusoft.test;

import java.util.Scanner;

import com.neusoft.biz.pet.IPetBiz;
import com.neusoft.biz.pet.impl.PetBizImpl;
import com.neusoft.vo.pet.Pet;

public class Test3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		IPetBiz petBiz = new PetBizImpl();
		Pet pet =null;
		System.out.print("请输入要删除宠物昵称：");
		String ss = input.next();
		pet = new Pet();
		pet.setName(ss);
		petBiz.deletePet(pet);
		
	}

}
