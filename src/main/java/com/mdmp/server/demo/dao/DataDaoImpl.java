package com.mdmp.server.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.mdmp.server.demo.db.MysqlConnectionFactory;
import com.mdmp.server.demo.domain.DataBean;

public class DataDaoImpl implements DataDao {
	//private Connection conn = null;
	PreparedStatement statement = null;

	// execute selection language
	public ResultSet selectSQL(String sql) {
		ResultSet rs = null;
		try {
			statement = MysqlConnectionFactory.getConnection().prepareStatement(sql);
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	// execute insertion language
	public boolean insertSQL(String sql) {
		try {
			statement = MysqlConnectionFactory.getConnection().prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("插入数据库时出错：");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("插入时出错：");
			e.printStackTrace();
		}
		return false;
	}

	// execute delete language
	public boolean deleteSQL(String sql) {
		try {
			statement = MysqlConnectionFactory.getConnection().prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("插入数据库时出错：");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("插入时出错：");
			e.printStackTrace();
		}
		return false;
	}

	// execute update language
	public boolean updateSQL(String sql) {
		try {
			statement = MysqlConnectionFactory.getConnection().prepareStatement(sql);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("插入数据库时出错：");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("插入时出错：");
			e.printStackTrace();
		}
		return false;
	}

	// show data in ju_users
	public void layoutStyle2(ResultSet rs) {
		System.out.println("-----------------");
		System.out.println("执行结果如下所示:");
		System.out.println("-----------------");
		System.out.println(" 用户ID" + "/t/t" + "淘宝ID" + "/t/t" + "用户名" + "/t/t"
				+ "密码");
		System.out.println("-----------------");
		try {
			while (rs.next()) {
				System.out.println(rs.getInt("ju_userID") + "/t/t"
						+ rs.getString("taobaoID") + "/t/t"
						+ rs.getString("ju_userName") + "/t/t"
						+ rs.getString("ju_userPWD"));
			}
		} catch (SQLException e) {
			System.out.println("显示时数据库出错。");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("显示出错。");
			e.printStackTrace();
		}
	}

	public Set<DataBean> getAllDataBean() {
		ResultSet rs = selectSQL("SELECT * FROM mdmp");
		Set<DataBean> dataSet = new HashSet<DataBean>();
		try {
			while (rs.next()){
				DataBean newBean = new DataBean();
				newBean.setResumeTime(rs.getString("resumeTime"));
				newBean.setAppKey(rs.getString("appKey"));
				newBean.setOsType(rs.getString("osType"));
				newBean.setCategory(rs.getString("category"));
				newBean.setAction(rs.getString("action"));
				newBean.setDevId(rs.getString("devId"));
				newBean.setValue(rs.getString("value"));
				dataSet.add(newBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataSet;
	}

	public boolean addDataBean(DataBean newBean) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO mdmp VALUES (");
		sb.append(newBean.getResumeTime() + ", ");
		sb.append(newBean.getAppKey() + ", ");
		sb.append(newBean.getOsType() + ", ");
		sb.append(newBean.getCategory() + ", ");
		sb.append(newBean.getAction() + ", ");
		sb.append(newBean.getDevId() + ", ");
		sb.append(newBean.getValue() + ")");
		return insertSQL(sb.toString());
	}
}
