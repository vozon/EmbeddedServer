package com.mdmp.server.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import com.mdmp.server.demo.domain.DataBean;

public class DataDaoImpl implements DataDao {
	private Connection conn = null;
	PreparedStatement statement = null;

	// execute selection language
	public ResultSet selectSQL(String sql) {
		ResultSet rs = null;
		try {
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	// execute insertion language
	public boolean insertSQL(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʱ������");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("����ʱ������");
			e.printStackTrace();
		}
		return false;
	}

	// execute delete language
	public boolean deleteSQL(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʱ������");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("����ʱ������");
			e.printStackTrace();
		}
		return false;
	}

	// execute update language
	public boolean updateSQL(String sql) {
		try {
			statement = conn.prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʱ������");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("����ʱ������");
			e.printStackTrace();
		}
		return false;
	}

	// show data in ju_users
	public void layoutStyle2(ResultSet rs) {
		System.out.println("-----------------");
		System.out.println("ִ�н��������ʾ:");
		System.out.println("-----------------");
		System.out.println(" �û�ID" + "/t/t" + "�Ա�ID" + "/t/t" + "�û���" + "/t/t"
				+ "����");
		System.out.println("-----------------");
		try {
			while (rs.next()) {
				System.out.println(rs.getInt("ju_userID") + "/t/t"
						+ rs.getString("taobaoID") + "/t/t"
						+ rs.getString("ju_userName") + "/t/t"
						+ rs.getString("ju_userPWD"));
			}
		} catch (SQLException e) {
			System.out.println("��ʾʱ���ݿ������");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("��ʾ������");
			e.printStackTrace();
		}
	}

	public Set<DataBean> getAllDataBean() {
		// TODO Auto-generated method stub
		return null;
	}
}