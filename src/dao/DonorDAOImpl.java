package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.bloodbank.model.Donor;

import com.util.DBConnectionUtil;
public class DonorDAOImpl implements DonorDAO {

	Connection connection = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	Statement statement;


	@Override
	public boolean save(Donor dr) {
		boolean flag = false;
		String sql = "INSERT INTO `donor` ( `email`, `password`, `phone`, `name`, `gender`, `blood`, `age`, `city`, `state`) VALUES('"
				+ dr.getEmail() + "','" + dr.getPassword() + "','" + dr.getPhone() + "','" + dr.getName() + "','"
				+ dr.getGender() + "','" + dr.getBlood_group() + "','" + dr.getAge() + "','" + dr.getCity() + "','"
				+ dr.getState() + "')";
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
	public boolean update(Donor dr) {
boolean flag = false;
		
		String sql = "UPDATE `donor` SET `password` = '"+dr.getPassword()+"', `name` = '"+dr.getName()+"',"
				+ " `phone` = '"+dr.getPhone()+"', `email` = '"+dr.getEmail()+"',"
						+ " `gender` = '"+dr.getGender()+"', `age` = '"+dr.getAge()+"', `city` = '"+dr.getCity()+"', `blood` = '"+dr.getBlood_group()+"', `state` = '"+dr.getState()+"' "
								+ ", `state` = '"+dr.getState()+"' where did='"+dr.getd_id()+"' ";
		 
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
	public boolean delete(String d_id) {
		boolean flag = false;

		String sql = "DELETE FROM `requests` WHERE did = '"+d_id+"'";
		
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			
			String sql1 = "DELETE FROM `donor` WHERE did = '"+d_id+"'";
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
	public String DonorLogin(Donor drlogin) {
		Donor donor = null;

		String sql = "select did from donor where email=? and password=?";
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, drlogin.getEmail());
			preparedStatement.setString(2, drlogin.getPassword());
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
	public List<Donor> getDonor() {
		List<Donor> ListDonor = null;
		Donor donor = null;

		try {
			ListDonor = new ArrayList<Donor>();
			String sql = "select * from donor";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				donor = new Donor();

				donor.setPassword(resultSet.getString("password"));
				donor.setName(resultSet.getString("name"));
				donor.setPhone(resultSet.getString("phone"));
				donor.setEmail(resultSet.getString("email"));
				donor.setGender(resultSet.getString("gender"));
				donor.setAge(resultSet.getString("age"));
				donor.setd_id(resultSet.getInt("did"));  
				donor.setState(resultSet.getString("state"));  
				donor.setBlood_group(resultSet.getString("blood"));
				donor.setCity(resultSet.getString("city"));  
			 

				ListDonor.add(donor);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ListDonor;

	}

	@Override
	public  List<Donor>  DonorId(String Email) {
		List<Donor> ListDonor = null;
		Donor donor = null;
		
		try {
			ListDonor = new ArrayList<Donor>();
			String sql1 = "select * from donor where email='"+Email+"'";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql1);
			while (resultSet.next()) {
				donor = new Donor();

				donor.setPassword(resultSet.getString("password"));
				donor.setName(resultSet.getString("name"));
				donor.setPhone(resultSet.getString("phone"));
				donor.setEmail(resultSet.getString("email"));
				donor.setGender(resultSet.getString("gender"));
				donor.setAge(resultSet.getString("age"));
				donor.setd_id(resultSet.getInt("did"));  
				donor.setState(resultSet.getString("state"));  
				donor.setBlood_group(resultSet.getString("blood"));
				donor.setCity(resultSet.getString("city"));  
			 

				ListDonor.add(donor);
				System.out.print("list data"+ListDonor);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ListDonor;

	}

	@Override
	public Integer didDonor(Donor drlogin) {
		Donor donor = null;
	

		String sql = "select did from donor where email=? ";
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, drlogin.getEmail());
			resultSet = preparedStatement.executeQuery();
			
			
				while (resultSet.next()) {
					donor = new Donor();
					donor.setd_id(resultSet.getInt("did"));
					
					 System.out.println("Id=" + resultSet.getInt("did"));
				}

			
		
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		int d_id=donor.getd_id();
		return d_id;
	}


}
