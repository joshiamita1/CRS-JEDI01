<<<<<<< HEAD
package com.flipkart.util;
 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
 
import org.apache.log4j.Logger;
 
 
 
public class DBUtil {
 
	private static Connection connection = null;
 
	private static Logger logger = Logger.getLogger(DBUtil.class);
 
	public static Connection getConnection() {
 
        if (connection != null)
            return connection;
        else {
            try {
            	Properties prop = new Properties();
                InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("./config.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                logger.error(e.getMessage());
            } catch (SQLException e) {
            	logger.error(e.getMessage());
            } catch (FileNotFoundException e) {
            	logger.error(e.getMessage());
            } catch (IOException e) {
            	logger.error(e.getMessage());
            }
            return connection;
        }
 
    }
 
	public static void closeConnection() {
		System.out.println("Closing Connection!!");
		try {
			if(connection != null) {
				connection.close();
			}
			else {
				logger.info("Connection already closed!");
			}
		}catch (SQLException e) {
			logger.error(e.getMessage());
        }
 
	}
}
 
=======
package com.flipkart.util;
 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
 
import org.apache.log4j.Logger;
 
 
 
public class DBUtil {
 
	public static Connection connection = null;
 
	private static Logger logger = Logger.getLogger(DBUtil.class);
 
	public static Connection getConnection() {
		logger.info("inside connection");
        if (connection != null)
            return connection;
        else {
            try {
            	Properties prop = new Properties();
                InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("./config.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                logger.info(driver);
                String url = prop.getProperty("url");
                logger.info(url);
                String user = prop.getProperty("user");
                logger.info(user);
                String password = prop.getProperty("password");
                logger.info(password);
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                logger.error(e.getMessage());
            } catch (SQLException e) {
            	logger.error(e.getMessage());
            } catch (FileNotFoundException e) {
            	logger.error(e.getMessage());
            } catch (IOException e) {
            	logger.error(e.getMessage());
            }
            return connection;
        }
 
    }
 
	public static void closeConnection() {
		System.out.println("Closing Connection!!");
		try {
			if(connection != null) {
				connection.close();
			}
			else {
				logger.info("Connection already closed!");
			}
		}catch (SQLException e) {
			logger.error(e.getMessage());
        }
 
	}
}
>>>>>>> cf804ec800aeeff3212d1ea073bff347dd339c96
 