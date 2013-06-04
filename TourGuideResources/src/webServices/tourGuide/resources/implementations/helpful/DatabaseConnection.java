/**
 * @author Walter Gugenberger
 * @date 02.06.2013 18:20:26
 * @version
 * @name guide.org.wuidl.noip.tourguide.database.DatabaseConnection.java
 * @description DatabaseConnection
 */
package webServices.tourGuide.resources.implementations.helpful;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * The Class DatabaseConnection.
 */
/**
 * The Class DatabaseConnection.
 */
public class DatabaseConnection {

	/** The instance. */
	private static DatabaseConnection instance;
	
	/**
	 * Gets the connection. This Class is a SINGLETON. It can only be
	 * instantiated once.
	 * 
	 * @param path
	 *            the path
	 * @return the connection
	 */
	public static DatabaseConnection getConnection(String fileConfigurationPath) {
		if (instance == null) {
			instance = createInstance(fileConfigurationPath);
		}
		return instance;
	}
	
	/**
	 * It will crate an instance of database reading the parameters from an XML file. 
	 * @param fileConfigurationPath
	 * @return
	 */
	private static DatabaseConnection createInstance(String fileConfigurationPath){
		DatabaseConnection result = null;
		
		try{
			//All necessary atributtes to create a databaseConnection
			String driver, name, protocol, url, port, user, password;
	
			
			//Let's read the XML file
			File 				   fXmlFile  = new File(fileConfigurationPath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder 	   dBuilder  = dbFactory.newDocumentBuilder();
			Document 			   doc       = dBuilder.parse(fXmlFile);
			
			
			doc.getDocumentElement().normalize();
			
		 
			//Root element
			driver 	 = doc.getDocumentElement().getAttribute("driver");
			name   	 = doc.getDocumentElement().getAttribute("name");
			protocol = doc.getDocumentElement().getAttribute("protocol");
			
			//Let's get the connection parameters.
			NodeList nList = doc.getElementsByTagName("conexion");
			
			if(nList.getLength() == 0){
				//We have a problem, there is no connection configuration... :(
				//TODO change it to log into the file log and abort the application...
				
			}else if(nList.getLength() > 1){
				//We have a problem, there are two connection configuration...
				//TODO change it to log into the file log, but it does not matter, we will use the first one
				
			}
			
			Node 	nNode = nList.item(0);
			Element eElement;
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				 
				eElement = (Element) nNode;
				
				url  = eElement.getAttribute("url");
				port = eElement.getAttribute("port");
			}else{
				//TODO we cannot read the node, something is going wrong...
				url  = "";
				port = "";
			}
			
			//As last, we will read the credential parameters.
			nList = doc.getElementsByTagName("credentials");
			
			if(nList.getLength() == 0){
				//We have a problem, there is no connection configuration... :(
				//TODO change it to log into the file log and abort the application...
				
			}else if(nList.getLength() > 1){
				//We have a problem, there are two connection configuration...
				//TODO change it to log into the file log, but it does not matter, we will use the first one
				
			}
			
			nNode = nList.item(0);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				 
				eElement = (Element) nNode;
				user     = eElement.getAttribute("user");
				password = eElement.getAttribute("password");
			}else{
				//TODO we cannot read the node, something is going wrong...
				user  	 = "";
				password = "";
			}
			
			
			//At this point, we have every things are necessary to create a database connection, so let's create it...
			result =  new DatabaseConnection(driver, name, protocol, url, port, user, password);
	    } catch (Exception e) {
	    	//TODO treat better this error... It should stop the application...
	    	e.printStackTrace();
	    }
		
		return result;
	}
	
	
	
	/** The connect. */
	private Connection connect;

	/** The statement. */
	private Statement statement;

	/** The result set. */
	private ResultSet resultSet;
	
	/**
	 *  Instantiates a new database connection.
	 * @param driver
	 * @param name
	 * @param protocol
	 * @param url
	 * @param port
	 * @param user
	 * @param password
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private DatabaseConnection(String driver, String name, String protocol, String url,
							   String port, String user, String password)
								throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		
		//TODO I think it is better if we try to lead this exception on other way, 
		//     because if there is an error with the database the application must stop the execution
		Class.forName(driver).newInstance();
		
		this.connect   = DriverManager.getConnection("jdbc:" + protocol + "://" + url + ":" + port + "/" + name + "?user=" + user + "&password=" + password);
		this.statement = this.connect.createStatement();
		this.resultSet = null;
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
