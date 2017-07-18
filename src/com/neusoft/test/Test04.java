package com.neusoft.test;

import java.util.Scanner;

import com.neusoft.biz.master.IMasterBIz;
import com.neusoft.biz.master.impl.MasterBizImpl;
import com.neusoft.vo.master.Master;

public class Test04 {

	public static void main(String[] args) {
		IMasterBIz masterBiz = new MasterBizImpl();
		Master master = null;
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要添加的姓名");
		String name = input.next();
		System.out.println("请输入要添加的密码");
		String pwd = input.next();
		System.out.println("请输入要添加的money");
		int money = input.nextInt();
		master = new Master();
		master.setName(name);
		master.setPassword(pwd);
		master.setMoney(money);
		int count2 = masterBiz.add(master);
		if(count2!=0) {
			System.out.println("添加成功");
		}
		System.out.println("请输入要删除的id");
		int id = input.nextInt();
		int count = masterBiz.delete(id);
		if(count!=0) {
			System.out.println("删除成功");
		}
		System.out.println("");
		System.out.println("请输入要修改的id");
		int id2 = input.nextInt();
		System.out.println("请输入要修改的姓名");
		String name2 = input.next();
		System.out.println("请输入要修改的密码");
		String pwd2 = input.next();
		System.out.println("请输入要修改的money");
		int money2 = input.nextInt();
		master = new Master();
		master.setId(id2);
		master.setName(name2);
		master.setPassword(pwd2);
		master.setMoney(money2);
		int count4 = masterBiz.update(master);
		if(count4!=0) {
			System.out.println("添加成功");
		}
		System.out.println("请输入要查询的id");
		int id3 = input.nextInt();
		master = masterBiz.search(id3);
		System.out.println(master.getId());
		System.out.println(master.getName());
		System.out.println(master.getPassword());
		System.out.println(master.getMoney());
		
	}

}
