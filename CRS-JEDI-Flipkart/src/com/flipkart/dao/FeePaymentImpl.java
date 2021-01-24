package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.flipkart.constant.GlobalConstants;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.util.DBUtil;

/**
 * @author Aditya Nahata
 *
 */
public class FeePaymentImpl implements FeePayment  {
	
	public static Logger logger = Logger.getLogger(FeePaymentImpl.class);
	Connection connection = DBUtil.getConnection();
	
	/*public static void main(String[]args) {
		FeePaymentImpl temp =new FeePaymentImpl();
		//temp.calculatefees(102);
		temp.updatefees(102, 50000);		
		//temp.getFeesToPay(102);
	}*/
	
	@Override
	public double calculatefees(int studentId) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		int count =this.countcourses(studentId);
		double fees= count* GlobalConstants.feesOfSingleCourse;
		
		StudentDaoImpl studentdao= new StudentDaoImpl();
		boolean hasScholarship=studentdao.hasScholarship(studentId);
		
		if(hasScholarship)
			fees=fees*0.5;
		
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.UPDATE_FEE );
			
			statement.setDouble(1,fees);
			statement.setInt(2,studentId);
			
			
			int rows = statement.executeUpdate();
			if(rows > 0) {
				logger.info("Fees Calculated sucessfully");
			}
			else {
				logger.info("Error during insertion");
			}
			return fees;
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return -1;
		}
		
	}

	@Override
	public int countcourses(int studentId) {
		PreparedStatement statement = null;
		int count = 0;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.COUNT_COURSE);
			statement.setInt(1,studentId);
			
			ResultSet resultSet = statement.executeQuery();
		
			if(resultSet.next())
			{
				
				count=(resultSet.getInt("coursecount"));
				
			}
			return count;
		}catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return count;
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatefees(int studentId, double fees) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.MAKE_PAYMENT_QUERY );
			statement.setInt(1,studentId);
			statement.setDouble(2,fees);
			Calendar cal = Calendar.getInstance(); 
			Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
			statement.setTimestamp(3, timestamp);		
			
			int rows = statement.executeUpdate();
			if(rows > 0) {
				logger.info("Fee payment successfull");
			}
			else {
				logger.info("Error during insertion");
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			
		}
		
		double feePending= this.getFeesToPay(studentId);
		try {
			
			statement = connection.prepareStatement(SQLQueriesConstant.UPDATE_FEE );
			
			statement.setDouble(1,feePending-fees);
			statement.setInt(2,studentId);
			
			
			int rows = statement.executeUpdate();
			if(rows > 0) {
				logger.info(" Post Payment FeesUpdated sucessfully");
			}
			else {
				logger.info("Error during update");
			}
						
		}catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			
		}
		
		
	}
	@Override
	public double getFeesToPay(int studentId) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		double fee =0;
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.GET_FEE_QUERY);
			statement.setInt(1,studentId);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next())
			{
				
				fee=(resultSet.getInt("amountPayable"));
				
			}
			return fee;
		}catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return fee;
		}
	
	}

}
