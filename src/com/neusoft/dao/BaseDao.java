package com.neusoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据操作超类
 * @author xzm
 *
 */
public class BaseDao {
	//编写数据库驱动的地址常量
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	//编写数据库URL地址常量
	private static final String URL="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	//编写数据库登陆名常量
	private static final String UNAME="system";
	//编写数据库登陆密码常量
	private static final String UPWD="ok";
	
		static{
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		private Connection conn = null;//数据库连接对象
		protected ResultSet res = null;//数据库查询结果集对象
		private PreparedStatement pstmt = null;//sql命令预处理对象
		
		//编写创建数据库连接对象的方法
		private void getConn(){
			try {
				conn = DriverManager.getConnection(URL, UNAME, UPWD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void closeAll(){
			if(null!=res){
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null!=pstmt){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null!=conn){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	
		public ResultSet commandQuery(String sql,Object[] params){
			//调用数据库连接的方法
			this.getConn();
			//创建预处理对象
			try {
				pstmt = conn.prepareStatement(sql);
				//预处理参数
				if(params!=null){
					for (int i = 0; i < params.length; i++) {
						pstmt.setObject(i+1, params[i]);
					}
				}
				//使用预处理对象的查询方法执行查询
				res = pstmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return res;
		}
		
		public int commandUpdate(String sql,Object[] params){
			int count = 0;
			//调用数据库连接的方法
			this.getConn();
			//创建预处理对象
			try {
				pstmt = conn.prepareStatement(sql);
				//预处理条件参数
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1, params[i]);
				}
				count = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				this.closeAll();
			}
			return count;
		}
}

		

