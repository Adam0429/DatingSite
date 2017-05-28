package db;

import java.sql.DriverManager;
import java.sql.SQLException;

import info.Login;

public class database {
	String driver = "com.mysql.jdbc.Driver";
	java.sql.Connection connection=null;
	java.sql.PreparedStatement statement=null;
	java.sql.ResultSet resultSet=null;
	public void save(Login login){
		try {
			Class.forName(driver);//load the driver
			connection=DriverManager.getConnection("jdbc:mysql://localhost/web","root","");
			statement=connection.prepareStatement("insert into login values (?,?,?,?)");
			statement.setString(1,login.getName());
			statement.setString(2,login.getTele());
			statement.setString(3,login.getAccount());
			statement.setString(4,login.getPassword());
			statement.executeUpdate();
			System.out.println("新用户注册成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
