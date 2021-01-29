<<<<<<< HEAD
/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;
import com.flipkart.utils.DBUtils;

import java.sql.*;
/**
 * @author surya
 *
 */
public class AdminDaoImpl implements AdminDao {
	
	public static Logger logger = Logger.getLogger(AdminDaoImpl.class);
	
	@Override
	public ArrayList<User> viewUsers() {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();

		try {
			Connection connection = DBUtils.getConnection();
			PreparedStatement stmt = null;
			stmt = connection.prepareStatement("SELECT "SQLQueriesConstants.VIEW_USERS_QUERY);
			ResultSet rs = stmt.executeQuery(SQLQueriesConstants.VIEW_USERS_QUERY);
			while(rs.next()) {
				User user = new User(null, null, null, null, 0, null, null);
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setRole(rs.getString(3));
				userList.add(user);
			}

		}catch(SQLException se) {
			logger.info(se.getMessage());
			return null;
		}
	}

		@Override
		public void assignProfessor(Professor professor, int courseId) {
			// TODO Auto-generated method stub
			CourseCatalogDaoImpl cd = new CourseCatalogDaoImpl();
			
			
			try {
				Connection connection = DBUtils.getConnection();
				PreparedStatement stmt = null;
				Course c = cd.getCourse(Integer.toString(courseId));
				stmt = connection.prepareStatement(SQLQueriesConstants.VIEW_USERS_QUERY);
				ResultSet rs = stmt.executeQuery(SQLQueriesConstants.VIEW_USERS_QUERY);
				while(rs.next()) {
					c.setProfessor(professor);
					cd.set
				}

			}catch(SQLException se) {
				logger.info(se.getMessage());
				return null;
			}
		}

		@Override
		public String addNewCourseInCatalog(Course course) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void deleteUser(int userId) {
			// TODO Auto-generated method stub

		}

	}
=======
package com.flipkart.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
>>>>>>> d2dbf3be979b8aa8ce20ec1aad6621f589964c61
