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

import java.util.List;

import com.flipkart.bean.User;

public class AdminDaoImpl implements AdminDao{

	@Override
	public void addAdmin(User admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAdmin(String adminId) {
		// TODO Auto-generated method stub
		
	}

}
>>>>>>> d2dbf3be979b8aa8ce20ec1aad6621f589964c61
