package com.flipkart.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.User;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.util.DBUtil;

public class AdminDaoImpl implements AdminDao{

	private static Logger logger = Logger.getLogger(AdminDaoImpl.class);
	Connection connection = DBUtil.getConnection();
	
	@Override
	public void addAdmin(User admin, String password) {
		// TODO Auto-generated method stub
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.ADD_NEW_USER_QUERY);
			stmt.setString(1,admin.getName());
			stmt.setString(2,password);
			stmt.setObject(3, "ADMIN");
			stmt.setInt(4,admin.getUserId());
			int rows = stmt.executeUpdate();
			logger.info(rows + " admin added");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void deleteAdmin(int userId) {
		// TODO Auto-generated method stub
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.DELETE_ADMIN_QUERY);
			stmt.setInt(1,userId);
			int rows = stmt.executeUpdate();
			logger.info(rows + " deleted");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}
}

