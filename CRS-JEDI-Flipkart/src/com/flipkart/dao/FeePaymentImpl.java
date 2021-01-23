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
	public static void main(String[]args) {
		FeePaymentImpl temp =new FeePaymentImpl();
		//temp.calculatefees(102);
		temp.updatefees(102, 50000);		
		//temp.getFeesToPay(102);
	}
	@Override
	public double calculatefees(int studentId) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		int count =this.countcourses(studentId);
		double fees= count* GlobalConstants.feesOfSingleCourse;
		
		try {logger.info("hello" +SQLQueriesConstant.UPDATE_FEE);
			statement = connection.prepareStatement(SQLQueriesConstant.UPDATE_FEE );
			
			statement.setDouble(1,fees);
			statement.setInt(2,studentId);
			
			logger.info("statement is "+statement);
			int rows = statement.executeUpdate();
			if(rows > 0) {
				logger.info("FeesUpdated sucessfully");
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
		try {logger.info(SQLQueriesConstant.COUNT_COURSE);
			statement = connection.prepareStatement(SQLQueriesConstant.COUNT_COURSE);
			statement.setInt(1,studentId);
			logger.info("statement is "+statement);
			ResultSet resultSet = statement.executeQuery();
			logger.info("userid is "+resultSet);
			if(resultSet.next())
			{
				logger.info(resultSet.getInt("coursecount"));
				count=(resultSet.getInt("coursecount"));
				logger.info(count);
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
			logger.info("statement is "+statement);
			int rows = statement.executeUpdate();
			if(rows > 0) {
				logger.info("Fee payment sucessfully");
			}
			else {
				logger.info("Error during insertion");
			}
			
		}catch(Exception e) {
			logger.error(e.getMessage());
			
		}
		
		double feePending= this.getFeesToPay(studentId);
		try {logger.info("hello" +SQLQueriesConstant.UPDATE_FEE);
			statement = connection.prepareStatement(SQLQueriesConstant.UPDATE_FEE );
			
			statement.setDouble(1,feePending-fees);
			statement.setInt(2,studentId);
			
			logger.info("statement is "+statement);
			int rows = statement.executeUpdate();
			if(rows > 0) {
				logger.info("FeesUpdated sucessfully");
			}
			else {
				logger.info("Error during insertion");
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
		try {logger.info(SQLQueriesConstant.GET_FEE_QUERY);
			statement = connection.prepareStatement(SQLQueriesConstant.GET_FEE_QUERY);
			statement.setInt(1,studentId);
			logger.info("statement is "+statement);
			ResultSet resultSet = statement.executeQuery();
			logger.info("userid is "+resultSet);
			if(resultSet.next())
			{
				logger.info(resultSet.getDouble("amountPayable"));
				fee=(resultSet.getInt("amountPayable"));
				logger.info(fee);
			}
			return fee;
		}catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return fee;
		}
	
	}

}
