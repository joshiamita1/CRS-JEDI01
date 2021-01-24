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
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.MODIFY_USER_QUERY );
			//StudentId, Name,Email,Mobile,Gender, branch, hasScholarship, isApproved,city, address,state)
			//statement.setInt(1,Integer.valueOf(student.getUserId()));
			statement.setString(1,user.getName());
			statement.setString(2,user.getPassword());
			statement.setString(3,String.valueOf(user.getRole()));
			statement.setString(4, userId);
			
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
<<<<<<< HEAD
	public List<String> getUsers(Role role) {
=======
	public String getPassword(int inputId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Integer> getUsers(Role role) {
>>>>>>> cf804ec800aeeff3212d1ea073bff347dd339c96
		
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
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_USER_DETAIL_ID);
			statement.setString(1,userId);
			ResultSet resultSet = statement.executeQuery();
<<<<<<< HEAD
			
			String password = resultSet.getString("password");
			String name = resultSet.getString("name");
			Role role = (Role) resultSet.getObject("role"); 
			Gender gender = (Gender) resultSet.getObject("gender");
			User user = new User(userId, null, password, name, 0, role, gender);
			//String userId, String emailId, String password, String name, long mobile, Role role, Gender gender
=======
			if(resultSet.next()){
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				Role role = Role.valueOf(resultSet.getObject("role")); 
				Gender gender = Gender.valueOf(resultSet.getObject("gender"));
				User user = new User(userId, null , password, name, 0, role, gender);
				return user;
			}
			else{
				logger.info("User does not exist");
			}
>>>>>>> cf804ec800aeeff3212d1ea073bff347dd339c96
			return null;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}
