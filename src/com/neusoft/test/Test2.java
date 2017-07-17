package com.neusoft.test;

import java.util.Scanner;

import com.neusoft.biz.pet.IPetBiz;
import com.neusoft.biz.pet.impl.PetBizImpl;
import com.neusoft.vo.pet.Pet;

public class Test2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		IPetBiz petBiz = new PetBizImpl();
		Pet pet =null;
		System.out.print("请输入宠物昵称：");
		String name = input.next();
		System.out.print("请输入宠物健康值：");
		int health = input.nextInt();
		System.out.print("请输入宠物亲密度：");
		int love = input.nextInt();
        System.out.print("请输入宠物类别：");
		String strain = input.next();
		
	    pet = new Pet();
		pet.setName(name);
		pet.setHealth(health);
		pet.setLove(love);
		pet.setStrain(strain);
		int peter = petBiz.addPet(pet);
		if(peter!=0) {
			System.out.println("添加成功");
			
		}else if(peter==0) {
			
			System.out.println("添加失败");
		}
		
		

	}

}
