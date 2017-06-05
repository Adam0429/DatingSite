package db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import info.Login;

public class database {
	String driver = "com.mysql.jdbc.Driver";
	java.sql.Connection connection=null;
	java.sql.PreparedStatement statement=null;
	
	public database(){
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost/web","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void save(Login login){
		try {
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
	
	public ArrayList<Login> query(String name){
		java.sql.ResultSet resultSet=null;
		ArrayList<Login> arrayList=new ArrayList<Login>();
		try{
			statement=connection.prepareStatement("select * from login where name = ?");
			statement.setString(1, name);
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				Login login=new Login();
				login.setName(resultSet.getString("name"));
				login.setTele(resultSet.getString("tele"));
				login.setAccount(resultSet.getString("account"));
				login.setPassword(resultSet.getString("password"));
				arrayList.add(login);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}
}
