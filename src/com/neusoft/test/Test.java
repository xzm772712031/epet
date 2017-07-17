package com.neusoft.test;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.neusoft.biz.master.IMasterBIz;
import com.neusoft.biz.master.impl.MasterBizImpl;
import com.neusoft.vo.master.Master;

public class Test {
	public static void main(String[] args) {
		IMasterBIz masterBiz = new MasterBizImpl();
		Master master = new Master();
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name = input.nextLine();
		System.out.println("请输入密码：");
		String pwd = input.nextLine();
		master = masterBiz.Login(name, pwd);
		if (master != null) {
			System.out.println("登录成功！");
		} else {
			System.out.println("密码或用户名错误！");
		}
		System.out.println("主人信息列表：");
		List masterList = masterBiz.showlist();
		Iterator it = masterList.iterator();
		while (it.hasNext()) {
			master = (Master) it.next();
			System.out.print(master.getId());
			System.out.print(" ");
			System.out.print(master.getName());
			System.out.print(" ");
			System.out.print(master.getMoney());
			System.out.println();
		}
	}
}
