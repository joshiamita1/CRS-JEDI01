package com.flipkart.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.util.DBUtils;

public class ProfessorDaoImpl implements ProfessorDao {
	public static Logger logger = Logger.getLogger(ProfessorDaoImpl.class);
	

	@Override
	public List<String> getProfessors() {
		
		Connection connection = DBUtils.getConnection();
		PreparedStatement statement = null;
		List<String> newListProf = new ArrayList<String>();
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.VIEW_PROFESSORID_QUERY);
			
			ResultSet resultSet = statement.executeQuery();
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
		
		Connection connection = DBUtils.getConnection();
		PreparedStatement statement = null;
		Professor professor;
		try {
			statement = connection.prepareStatement("SELECT * FROM PROFESSOR WHERE ID = \'" + professorId+"\'");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				String profId = resultSet
				String email
				Long mobile
				Gender gender
				Deptartment dept
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProfessor(String professorId) {
		// TODO Auto-generated method stub
		
	}

}