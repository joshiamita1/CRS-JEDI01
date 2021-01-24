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
			stmt.setString(2,password);
			stmt.setString(3,user.getRole().toString());
			int rows = stmt.executeUpdate();
			logger.info(rows + " user added");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.DELETE_USER_QUERY);
			stmt.setInt(1,userId);
			int rows = stmt.executeUpdate();
			logger.info(rows + " deleted");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}


	@Override
	public void modifyUser(int userId, User user) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.MODIFY_USER_QUERY );
			
			statement.setString(1,user.getName());
			statement.setString(2,String.valueOf(user.getRole()));
			statement.setInt(3, userId);
			
			logger.info("statement is "+statement);
			int rows = statement.executeUpdate();
			if(rows > 0) {
				logger.info("Added user sucessfully");
			}
			else {
				logger.info("Error during insertion");
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}


	@Override
	public List<Integer> getUsers() {
		
		PreparedStatement statement = null;
		List<Integer> userList = new ArrayList<Integer>();
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_USER_DETAIL);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
			int userId = resultSet.getInt("userId");
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
	public ArrayList<Integer> getUsers(Role role) {
		
		PreparedStatement statement = null;
		ArrayList<Integer> userList = new ArrayList<Integer>();
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_USER_DETAIL_ROLE);
			statement.setObject(1,role);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
			int userId = resultSet.getInt("userId");
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
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_USER_DETAIL_ID);
			statement.setInt(1,userId);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				
				String name = resultSet.getString("name");
				Role role = Role.valueOf(resultSet.getString("role")); 
				
				User user = new User();
				user.setName(name);
				user.setRole(role);
				return user;
			}
			else{
				logger.info("User does not exist");
			}
			return null;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	
	@Override
	public String getPassword(int userId) {
		// TODO Auto-generated method stub
PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_USER_DETAIL_ID);
			statement.setInt(1,userId);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				
				String password = resultSet.getString("password");
				return password;
			}
			else{
				logger.info("User does not exist");
			}
			return null;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	
	}


}