package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Professor;
import com.flipkart.bean.User;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.util.DBUtil;

public class UserDaoImpl implements UserDao {

	private static Logger logger = Logger.getLogger(UserDaoImpl.class);
	Connection connection = DBUtil.getConnection();
	
	@Override
	public void addUser(User user, String password) {
		// TODO Auto-generated method stub
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.ADD_NEW_USER_QUERY);
			stmt.setString(1,user.getName());
			stmt.setString(2,user.getPassword());
			stmt.setObject(3,user.getRole());
			stmt.setString(4,user.getUserId());
			int rows = stmt.executeUpdate();
			logger.info(rows + " user added");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.DELETE_USER_QUERY);
			stmt.setString(1,userId);
			int rows = stmt.executeUpdate();
			logger.info(rows + " deleted");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}

	@Override
	public void modifyUser(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getUsers() {
		
		PreparedStatement statement = null;
		List<String> userList = new ArrayList<String>();
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_USER_DETAIL);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
			String userId = resultSet.getString("userId");
			userList.add(userId);
			}
			return userList;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPassword(int inputId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getUsers(Role role) {
		
		PreparedStatement statement = null;
		List<String> userList = new ArrayList<String>();
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_USER_DETAIL_ROLE);
			statement.setObject(1,role);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
			String userId = resultSet.getString("userId");
			userList.add(userId);
			}
			return userList;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_USER_DETAIL_ID);
			statement.setString(1,userId);
			ResultSet resultSet = statement.executeQuery();
			
			String password = resultSet.getString("password");
			String name = resultSet.getString("name");
			Role role = (Role) resultSet.getObject("role"); 
			Gender gender = (Gender) resultSet.getObject("gender");
			User user = new User(userId, null, password, name, 0, role, gender);
			//String userId, String emailId, String password, String name, long mobile, Role role, Gender gender
			return null;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}