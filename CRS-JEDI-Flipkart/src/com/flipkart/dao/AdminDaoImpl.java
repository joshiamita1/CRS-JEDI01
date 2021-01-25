package com.flipkart.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.User;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.util.DBUtil;

public class AdminDaoImpl implements AdminDao{

	private static AdminDaoImpl instance = null;
	private static Logger logger = Logger.getLogger(AdminDaoImpl.class);
	Connection connection = DBUtil.getConnection();
	
	private AdminDaoImpl() {
		
	}
	
	public static AdminDaoImpl getInstance() {
		if(instance==null) {
			instance = new AdminDaoImpl();
		}
		return instance;
	}
	
	@Override
	public void addAdmin(User admin, String password) {
		// TODO Auto-generated method stub
		
		PreparedStatement stmt = null;
		try {
			
			UserDaoImpl userdao = UserDaoImpl.getInstance();
			userdao.addUser(admin, password);
			
			stmt =connection.prepareStatement(SQLQueriesConstant.GET_LAST_ENTRY);
			ResultSet resultSet = stmt.executeQuery();
			int userId=0;
			if(resultSet.next()){
				userId=resultSet.getInt("ID");
			}
			stmt = connection.prepareStatement(SQLQueriesConstant.ADD_NEW_ADMIN_QUERY);
			stmt.setInt(1, userId);
			stmt.setString(2, admin.getGender().toString());
			stmt.setString(3, admin.getCity());
			stmt.setString(4, admin.getAddress());
			stmt.setString(5,  admin.getCountry());
			stmt.setString(6, admin.getState());
			stmt.setLong(7,  admin.getMobile());
			stmt.setString(8, admin.getEmailId());
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
			
			UserDaoImpl userdao = UserDaoImpl.getInstance();
			userdao.deleteUser(userId);
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}
}
