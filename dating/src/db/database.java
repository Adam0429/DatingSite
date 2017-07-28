package db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.omg.CORBA.PUBLIC_MEMBER;

import info.Dormitory;
import info.Login;
import info.bbs;

public class database {
	String driver = "com.mysql.jdbc.Driver";
	java.sql.Connection connection=null;
	java.sql.PreparedStatement statement=null;
	int size=5;//每页有多少数据
	
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
			statement=connection.prepareStatement("insert into login values (?,?,?,?,?,?)");
			statement.setString(1,login.getAccount());
			statement.setString(2,login.getPassword());
			statement.setString(3,login.getName());
			statement.setString(4,login.getGender());
			statement.setString(5,login.getTele());
			statement.setString(6,login.getDormitory());
			statement.executeUpdate();
			System.out.println("新用户注册成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void savedormitory(Dormitory dormitory){
		try {
			statement=connection.prepareStatement("insert into dormitory values (?)");
			statement.setString(1, dormitory.getName());
			statement.executeUpdate();
			System.out.println("新宿舍插入");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Login> query(String string,String attribute,int page){
		java.sql.ResultSet resultSet=null;
		ArrayList<Login> arrayList=new ArrayList<Login>();
		if(attribute=="name"){
			try{
				statement=connection.prepareStatement("select * from login where name like ? limit ?,?");
				statement.setString(1, "%"+string+"%");
				statement.setInt(2, (page-1)*size);
				statement.setInt(3, size);
				resultSet=statement.executeQuery();
				while(resultSet.next()){
					Login login=new Login();
					login.setName(resultSet.getString("name"));
					login.setTele(resultSet.getString("tele"));
					login.setAccount(resultSet.getString("account"));
					login.setPassword(resultSet.getString("password"));
					login.setDormitory(resultSet.getString("dormitory_name"));
					login.setGender(resultSet.getString("gender"));
					arrayList.add(login);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(attribute=="account"){
			try{
				statement=connection.prepareStatement("select * from login where account like ? limit ?,?");
				statement.setString(1, "%"+string+"%");
				statement.setInt(2, (page-1)*size);
				statement.setInt(3, size);
				resultSet=statement.executeQuery();
				while(resultSet.next()){
					Login login=new Login();
					login.setName(resultSet.getString("name"));
					login.setTele(resultSet.getString("tele"));
					login.setAccount(resultSet.getString("account"));
					login.setPassword(resultSet.getString("password"));
					login.setDormitory(resultSet.getString("dormitory_name"));
					login.setGender(resultSet.getString("gender"));
					arrayList.add(login);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return arrayList;

	}
	
	
	public ArrayList<Dormitory> querydormitory(){
		java.sql.ResultSet resultSet=null;
		ArrayList<Dormitory> arrayList=new ArrayList<Dormitory>();
		try{
			statement=connection.prepareStatement("select * from dormitory");
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				Dormitory d=new Dormitory();
				d.setName(resultSet.getString("name"));
				arrayList.add(d);
			}
		}catch (Exception e) {
			e.printStackTrace();
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
	
	public void deletedormitory(String dormitory){
		try{
			statement=connection.prepareStatement("delete from dormitory where name = ?");
			statement.setString(1, dormitory);
			statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(String account,String name,String tele,String password,String gender,String dormitory){
		try{
			statement=connection.prepareStatement("update login set name = ?,tele = ?,password = ?,gender = ?, dormitory_name = ? where account = ?");
			statement.setString(1, name);
			statement.setString(2, tele);
			statement.setString(3, password);
			statement.setString(4, gender);
			statement.setString(5, dormitory);
			statement.setString(6, account);
			statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public boolean check(String account,String password){
		java.sql.ResultSet resultSet=null;
		try{
			statement=connection.prepareStatement("select password from login where account = ?");
			statement.setString(1, account);
			resultSet=statement.executeQuery();
			if(resultSet.next()){
				System.out.println(resultSet.getString("password"));
				if(password.equals(resultSet.getString("password")))
					return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int countpage(String string,String attribute){
		int page=0;
		java.sql.ResultSet resultSet=null;
		ArrayList<Login> arrayList=new ArrayList<Login>();
		if(attribute=="name"){
			try{
				statement=connection.prepareStatement("select count(*) as total from login where name like ?");
				statement.setString(1, "%"+string+"%");
				resultSet=statement.executeQuery();
				if(resultSet.next()){
					int total=resultSet.getInt("total");
					if(total%size==0)	
						page=total/size;
					else 
						page=total/size+1;
				}
			}
				catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(attribute=="account"){
			try{
				statement=connection.prepareStatement("select count(*) as total from login where account like ?");
				statement.setString(1, "%"+string+"%");
				resultSet=statement.executeQuery();
				if(resultSet.next()){
					int total=resultSet.getInt("total");
					if(total%size==0)	
						page=total/size;
					else
						page=total/size+1;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return page;
	}
	
	public void newbbs(String bbs_id,String bbs_content,String login_account){
		try{
			statement=connection.prepareStatement("insert into bbs (bbs_id,bbs_content,login_account) values (?,?,?)");
			statement.setString(1,bbs_id);
			statement.setString(2,bbs_content);
			statement.setString(3,login_account);
			statement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<bbs> querybbs(){
		java.sql.ResultSet resultSet=null;
		ArrayList<bbs> arrayList=new ArrayList<bbs>();
		try{
			statement=connection.prepareStatement("select * from bbs");
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				bbs b=new bbs();
				b.setBbs_id(resultSet.getString("bbs_id"));
				b.setBbs_content(resultSet.getString("bbs_content"));
				b.setLogin_account(resultSet.getString("login_account"));
				arrayList.add(b);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}
	
	public String bbs_number(){
		String number="0";
		try{
			java.sql.ResultSet resultSet=null;
			statement=connection.prepareStatement("select count(*) as bbs_number from bbs");
			resultSet=statement.executeQuery();
			if(resultSet.next()){
				number=resultSet.getString("bbs_number");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return number;
	}
} 
