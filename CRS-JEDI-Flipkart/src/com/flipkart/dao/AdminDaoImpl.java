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
	public void addAdmin(User admin) {
		// TODO Auto-generated method stub
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.ADD_NEW_USER_QUERY);
			stmt.setString(1,admin.getName());
			stmt.setString(2,admin.getPassword());
			stmt.setObject(3, "ADMIN");
			stmt.setString(4,admin.getUserId());
			int rows = stmt.executeUpdate();
			logger.info(rows + " admin added");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void deleteAdmin(String adminId) {
		// TODO Auto-generated method stub
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.DELETE_ADMIN_QUERY);
			stmt.setString(1,adminId);
			int rows = stmt.executeUpdate();
			logger.info(rows + " deleted");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}

}
>>>>>>> d2dbf3be979b8aa8ce20ec1aad6621f589964c61
