package db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.enterprise.inject.New; 

import info.Login;

public class database {
	java.sql.Connection connection=null;
	String url="jdbc:mysql://localhost:3306/web";
	java.sql.PreparedStatement statement=null;
	java.sql.ResultSet resultSet=null;
	public void save(Login login){
		try {
			connection=DriverManager.getConnection(url,"root","");
			statement=connection.prepareStatement("insert into login values (?,?)");
			statement.setString(1,login.getName());
			statement.setString(2,login.getName());
			statement.executeUpdate();
			System.out.println("³É¹¦£¡");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
