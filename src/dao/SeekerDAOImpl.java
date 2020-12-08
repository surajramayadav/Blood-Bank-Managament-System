package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.bloodbank.model.Donor;
import com.bloodbank.model.Seeker;
import com.util.DBConnectionUtil;
import javax.servlet.http.HttpSession;

public class SeekerDAOImpl implements SeekerDAO {
	Connection connection = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	Statement statement;

	@Override
	public boolean save(Seeker sr) {
		boolean flag = false;
		String sql = "INSERT INTO `seeker` ( `email`, `password`, `phone`, `name`, `gender`, `blood`, `age`, `city`, `state`) VALUES('"
				+ sr.getEmail() + "','" + sr.getPassword() + "','" + sr.getPhone() + "','" + sr.getName() + "','"
				+ sr.getGender() + "','" + sr.getBlood_group() + "','" + sr.getAge() + "','" + sr.getCity() + "','"
				+ sr.getState() + "')";
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Seeker sr) {
     boolean flag = false;
		
		String sql = "UPDATE `seeker` SET `password` = '"+sr.getPassword()+"', `name` = '"+sr.getName()+"',"
				+ " `phone` = '"+sr.getPhone()+"', `email` = '"+sr.getEmail()+"',"
						+ " `gender` = '"+sr.getGender()+"', `age` = '"+sr.getAge()+"', `city` = '"+sr.getCity()+"', `blood` = '"+sr.getBlood_group()+"', `state` = '"+sr.getState()+"' "
								+ ", `state` = '"+sr.getState()+"' where sid='"+sr.getSid()+"' ";
		 
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(String sid) {
		
		boolean flag = false;

		String sql = "DELETE FROM `requests` WHERE sid = '"+sid+"'";
		
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		
			String sql1 = "DELETE FROM `seeker` WHERE sid = '"+sid+"'";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.executeUpdate();
		
			flag = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public String SeekerLogin(Seeker srlogin) {
		String sql = "select * from seeker where email=? and password=?";
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, srlogin.getEmail());
			preparedStatement.setString(2, srlogin.getPassword());
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				System.out.print("sucess");
				return "true";
			} else {
				System.out.print("failed");
				return "false";
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.print("error");
		return "error";
	}

	@Override
	public List<Seeker> getSeeker() {
		
		List<Seeker> ListSeeker = null;
		Seeker seeker = null;

		try {
			ListSeeker = new ArrayList<Seeker>();
			String sql = "select * from seeker";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				seeker = new Seeker();

				seeker.setPassword(resultSet.getString("password"));
				seeker.setName(resultSet.getString("name"));
				seeker.setPhone(resultSet.getString("phone"));
				seeker.setEmail(resultSet.getString("email"));
				seeker.setGender(resultSet.getString("gender"));
				seeker.setAge(resultSet.getString("age"));
				seeker.setSid(resultSet.getInt("sid"));  
				seeker.setState(resultSet.getString("state"));  
				seeker.setBlood_group(resultSet.getString("blood"));
				seeker.setCity(resultSet.getString("city"));  
			 
				
			
				ListSeeker.add(seeker);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ListSeeker;

	}

	@Override
	public Integer sidSeeker(Seeker srlogin) {
		Seeker seeker=null;
		String sql = "select sid from seeker where email=? ";
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, srlogin.getEmail());
			resultSet = preparedStatement.executeQuery();
			
			
				while (resultSet.next()) {
					seeker = new Seeker();
					seeker.setSid(resultSet.getInt("sid"));
					
					 System.out.println("Id=" + resultSet.getInt("sid"));
				}

			
		
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		int sid=seeker.getSid();
		return sid;
	}
	

	@Override
	public List<Seeker> SeekerId(String Email) {
		List<Seeker> ListSeeker = null;
		Seeker seeker=null;
		
		try {
			ListSeeker = new ArrayList<Seeker>();
			String sql1 = "select * from seeker where email='"+Email+"'";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql1);
			while (resultSet.next()) {
				seeker = new Seeker();

				seeker.setPassword(resultSet.getString("password"));
				seeker.setName(resultSet.getString("name"));
				seeker.setPhone(resultSet.getString("phone"));
				seeker.setEmail(resultSet.getString("email"));
				seeker.setGender(resultSet.getString("gender"));
				seeker.setAge(resultSet.getString("age"));
				seeker.setSid(resultSet.getInt("sid"));  
				seeker.setState(resultSet.getString("state"));  
				seeker.setBlood_group(resultSet.getString("blood"));
				seeker.setCity(resultSet.getString("city"));  
			 

				ListSeeker.add(seeker);
				System.out.print("list data"+ListSeeker);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ListSeeker;
	}
	

}
