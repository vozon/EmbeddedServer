package com.mdmp.server.demo.dao;

import java.sql.ResultSet;

import org.junit.Test;

import junit.framework.TestCase;

public class DataDaoImplTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testDataDao(){
		DataDao h = new DataDaoImpl();
		
		String s = "select * from ju_users";

		String insert = "insert into ju_users(ju_userID,TaobaoID,ju_userName,ju_userPWD) values("+8329+","+34243+",'mm','789')";
		String update = "update ju_users set ju_userPWD =123 where ju_userName= 'mm'";
		String delete = "delete from ju_users where ju_userName= 'mm'";

		if (h.insertSQL(insert) == true) {
			System.out.println("insert successfully");
			ResultSet resultSet = h.selectSQL(s);
			h.layoutStyle2(resultSet);
		}
		if (h.updateSQL(update) == true) {
			System.out.println("update successfully");
			ResultSet resultSet = h.selectSQL(s);	
			h.layoutStyle2(resultSet);
		}
		if (h.insertSQL(delete) == true) {
			System.out.println("delete successfully");
			ResultSet resultSet = h.selectSQL(s);
			h.layoutStyle2(resultSet);
		}
	}
}
