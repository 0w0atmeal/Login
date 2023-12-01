package controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;

import model.User;


public class DatabaseController {

	ArrayList<User> users = new ArrayList<User>();
    
    public void createTable() throws SQLException{
		Connection connection = connect();
		if(connection != null){
			Statement statement = connection.createStatement();
			// TABLE USERS
			statement.execute("CREATE TABLE IF NOT EXISTS users(id INTEGER PRIMARY KEY, username TEXT, userkey TEXT)");
			closeConnection(connection);
		}
	}

    public void testConnection(){
		Connection connection = null;
		try {
            String url = "jdbc:sqlite:memory.db";
            connection = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            closeConnection(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}

	public Connection connect(){
		Connection connection = null;
		try {
            String url = "jdbc:sqlite:memory.db";
            connection = DriverManager.getConnection(url);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return connection;
	}

    public void closeConnection(Connection connection) throws SQLException{
		connection.close();
	}

    /**
	 * 	User Funktionen:
     * 
	 *  addUser
	 *  removeUser
	 *  getUser
	 *  getAllUsers
     * 
	 */

     public void addUser(User user) throws SQLException{
		Connection connection = connect();
		if(connection != null){
			Statement statement = connection.createStatement();
			statement.execute("INSERT INTO users (username, userkey) values ('"+user.getUserName()+"','"+user.getKey()+"')");
			closeConnection(connection);
		}
	}

	public void removeUser(int id) throws SQLException{
		Connection connection = connect();
		if(connection != null){
			Statement statement = connection.createStatement();
			statement.execute("DELETE FROM users WHERE id='"+id+"'");
			closeConnection(connection);
		}
	}

	public User getUser(int id) throws SQLException{
		Connection connection = connect();
		User user = null;
		if(connection != null){
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM users WHERE id='"+id+"'");
			while(res.next()){
				user = new User(res.getInt(1), res.getString(2), res.getInt(3));
			}
			closeConnection(connection);
		}
		return user;
	}

	public ArrayList<User> getAllUsers()  throws SQLException{
		ArrayList<User> users = new ArrayList<>();

		Connection connection = connect();
		if(connection != null){
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM USERS ORDER BY username ASC");
			while(res.next()){
				users.add(new User(res.getInt(1), res.getString(2), res.getInt(3)));
			}
			closeConnection(connection);
		}
		
		return users;
	}
}
