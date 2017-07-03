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
			connection=DriverManager.getConnection("jdbc:mysql://localhost/web","root","970429");
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
	
	public ArrayList<Login> query(String string,String attribute){
		java.sql.ResultSet resultSet=null;
		ArrayList<Login> arrayList=new ArrayList<Login>();
		if(attribute=="name"){
			try{
				statement=connection.prepareStatement("select * from login where name like ?");
				statement.setString(1, "%"+string+"%");
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
		}
		else if(attribute=="account"){
			try{
				statement=connection.prepareStatement("select * from login where account like ? ");
				statement.setString(1, "%"+string+"%");
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
		}
		return arrayList;
	}
	
	public void delete(String account){
		try{
			statement=connection.prepareStatement("delete from login where account = ?");
			statement.setString(1, account);
			statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(String account,String name,String tele,String password){
		try{
			statement=connection.prepareStatement("update login set name = ?,tele = ?,password = ? where account = ?");
			statement.setString(1, name);
			statement.setString(2, tele);
			statement.setString(3, password);
			statement.setString(4, account);
			statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
				
	}
}
