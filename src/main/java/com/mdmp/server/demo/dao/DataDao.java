package com.mdmp.server.demo.dao;

import java.sql.ResultSet;
import java.util.Set;

import com.mdmp.server.demo.domain.DataBean;

public interface DataDao {
	
	public Set<DataBean> getAllDataBean();
	
	public ResultSet selectSQL(String sql);

	public boolean insertSQL(String sql);

	public boolean deleteSQL(String sql);

	public boolean updateSQL(String sql);

	public void layoutStyle2(ResultSet rs);
}
