/**
 * @author Walter Gugenberger
 * @date 02.06.2013 18:20:26
 * @version
 * @name guide.org.wuidl.noip.tourguide.database.DatabaseConnection.java
 * @description DatabaseConnection
 */
package org.noip.wuidl.tourguide.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.noip.wuidl.tourguide.constants.ServiceConstants;

/**
 * The Class DatabaseConnection.
 */
public class DatabaseConnection {

	/** The connect. */
	private Connection connect;

	/** The statement. */
	private Statement statement;

	/** The result set. */
	private ResultSet resultSet;

	/** The instance. */
	private static DatabaseConnection instance;

	/**
	 * Instantiates a new database connection.
	 * 
	 * @param path
	 *            the path
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws SQLException
	 *             the sQL exception
	 */
	private DatabaseConnection(String path) throws ClassNotFoundException,
	SQLException {
		try {
			Class.forName("java.sql.Driver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		this.connect = DriverManager.getConnection(path+ServiceConstants.DB_NAME,ServiceConstants.DB_USER,ServiceConstants.DB_PWD);
		this.statement = this.connect.createStatement();
		this.resultSet = null;
	}

	/**
	 * Gets the connection. This Class is a SINGLETON. It can only be
	 * instantiated once.
	 * 
	 * @param path
	 *            the path
	 * @return the connection
	 */
	public static DatabaseConnection getConnection(String path) {
		if (instance == null) {
			try {
				instance = new DatabaseConnection(path);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	/**
	 * Close connection to the DB.
	 * 
	 * @throws SQLException
	 *             the sQL exception
	 */
	public void closeConnection() throws SQLException {
		if (this.resultSet != null) {
			this.resultSet.close();
		}
		if (this.statement != null) {
			this.statement.close();
		}
		if (this.connect != null) {
			this.connect.close();
		}
	}

	/**
	 * Prepared statement to insert into the DB.
	 * 
	 * @param query
	 *            the query
	 * @return the prepared statement
	 */
	public PreparedStatement preparedStatement(String query) {
		try {
			return this.connect.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Deprecated<br>
	 * Write to db. This method is deprecated. With this method SQL Injections
	 * would be possible.
	 * 
	 * @param query
	 *            the query
	 * @return true, if successful
	 */
	@Deprecated
	public boolean writeToDb(PreparedStatement query) {
		try {
			return query.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Deprecated<br>
	 * Read from db. Read from the and return the result as ResultSet.
	 * 
	 * 
	 * @param query
	 *            the query
	 * @return the result set
	 */
	@Deprecated
	public ResultSet readFromDb(PreparedStatement query) {
		try {
			this.resultSet = query.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.resultSet;
	}
}
