/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;

/**
 * @author ABHI SHREE JAIN
 *
 */
public class AdminDaoImpl implements AdminDao{

	
	private static Logger logger = Logger.getLogger(AdminDaoImpl.class);
	Connection connection = DBUtil.getConnection();
	

	@Override
	public ArrayList<User> viewUsers() {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		
		ArrayList<User> userList = new ArrayList<User>();
		
		try {
			stmt = connection.prepareStatement(SQLQueriesConstants.VIEW_USERS_QUERY);
			ResultSet rs = stmt.executeQuery(SQLQueriesConstants.VIEW_USERS_QUERY);
			while(rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setRole(rs.getString(3));
				userList.add(user);
			}
			
		}catch(SQLException se) {
			logger.info(se.getMessage());
			
		}catch(Exception e) {
			logger.info(e.getMessage());
		}
		return userList;
		return null;
	}


	@Override
	public void assignProfessor(Professor professor, int courseId) {
		// TODO Auto-generated method stub
		
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
