package com.flipkart.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
<<<<<<< HEAD
=======
import com.flipkart.bean.User;
>>>>>>> lovish
import com.flipkart.constant.Department;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.util.DBUtil;

public class ProfessorDaoImpl implements ProfessorDao {
	public static Logger logger = Logger.getLogger(ProfessorDaoImpl.class);
	Connection connection = DBUtil.getConnection();
<<<<<<< HEAD

	@Override
	public List<String> getProfessors() {
		
		PreparedStatement statement = null;
		List<String> newListProf = new ArrayList<String>();
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.VIEW_PROFESSORID_QUERY);
			
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				
				String profId = resultSet.getString("ID");
				newListProf.add(profId);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				resultSet.close();
				statement.close();
			}catch(Exception se) {
				se.printStackTrace();
			}
		}
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public Professor getProfessor(String professorId) {
		
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_PROF_DETAIL);
			ResultSet resultSet = statement.executeQuery();
			
			String userId = resultSet.getString("userId");
			String emailId = resultSet.getString("emailId");
			String password = resultSet.getString("password");
			String name = resultSet.getString("name");
			long mobile = resultSet.getLong("mobile");
			Role role = (Role) resultSet.getObject("role");
			Gender gender = (Gender)resultSet.getObject("gender");
			String dept = resultSet.getString("dept");
			
			Professor professor = new Professor( userId, emailId, password, name, mobile, role, gender, dept);
			return professor;
=======
	
	@Override
	public Professor getProfessor(int professorId) {
		
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_PROF_DETAIL);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				
				String userId = resultSet.getString("userId");
				String emailId = resultSet.getString("emailId");
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				long mobile = resultSet.getLong("mobile");
				Role role = Role.valueOf(resultSet.getString("role"));
				Gender gender = Gender.valueOf(resultSet.getString("gender"));
				Department dept = Department.valueOf(resultSet.getString("dept"));

				Professor professor = new Professor( userId, emailId, password, name, mobile, role, gender, dept);
				return professor;
			}
			return null;
>>>>>>> cf804ec800aeeff3212d1ea073bff347dd339c96
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
<<<<<<< HEAD
	public void addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.ADD_NEW_USER_QUERY);
			stmt.setString(1,professor.getName());
			stmt.setString(2,professor.getPassword());
			stmt.setObject(3, "PROFESSOR");
			stmt.setString(4,professor.getUserId());
			int rows = stmt.executeUpdate();
			logger.info(rows + " professor added");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		
	}
=======
	public void addProfessor(User user, String password, Department department) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.ADD_NEW_PROF_QUERY);
>>>>>>> cf804ec800aeeff3212d1ea073bff347dd339c96

			stmt.setString(1,professor.getUserId());
			stmt.setObject(2,String.valueOf(professor.getDepartment()));
			stmt.setObject(3,String.valueOf(professor.getGender()));
			stmt.setString(4,professor.getCity());
			stmt.setString(5,professor.getAddress());
			stmt.setString(6,professor.getCountry());
			stmt.setString(7,professor.getState());
			stmt.setLong(8,professor.getMobile());
			stmt.setString(9,professor.getEmailId());
			
			int rows = stmt.executeUpdate();
			if(rows > 0) {
				logger.info("Added Professor sucessfully");
			}
			else {
				logger.info("Error during insertion");
			}
			logger.info(rows + " professor added");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		
	}
	@Override
<<<<<<< HEAD
	public void deleteProfessor(String professorId) {
=======
	public void deleteProfessor(int userId) {
>>>>>>> cf804ec800aeeff3212d1ea073bff347dd339c96
		// TODO Auto-generated method stub
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLQueriesConstant.DELETE_PROF_QUERY);
<<<<<<< HEAD
			stmt.setString(1,professorId);
=======
			stmt.setString(1,userId);
>>>>>>> cf804ec800aeeff3212d1ea073bff347dd339c96
			int rows = stmt.executeUpdate();
			logger.info(rows + " deleted");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}
<<<<<<< HEAD

}
=======
	
	
}
>>>>>>> lovish
