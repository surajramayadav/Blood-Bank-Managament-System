package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bloodbank.model.Donor;
import com.bloodbank.model.Request;
import com.util.DBConnectionUtil;

public class RequestDAOImpl implements RequestDAO {
	Connection connection = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	Statement statement;

	@Override
	public boolean save(Request rr) {
		boolean flag = false;
		String sql = "INSERT INTO `requests` ( `did`, `sid`, `status`) VALUES ('"
				+ rr.getDid() + "','" + rr.getSid() + "','" + rr.getStatus() + "')";
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
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Request> getRequest() {
		List<Request> ListRequest = null;
		Request rr = null;

		try {
			ListRequest = new ArrayList<Request>();
			String sql = "SELECT * FROM `requests`";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				rr = new Request();

				rr.setId(resultSet.getInt("rid"));
				rr.setDid(resultSet.getString("did"));
				rr.setSid(resultSet.getInt("sid"));
				rr.setStatus(resultSet.getString("status"));
				
			 

				ListRequest.add(rr);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ListRequest;

	}

	@Override
	public List<Request> getData(Integer d_id) {
		List<Request> ListRequest = null;
		Request rr = null;

		try {
			ListRequest = new ArrayList<Request>();
			String sql = "SELECT * FROM `requests` where did='"+d_id+"'";
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				rr = new Request();

				rr.setId(resultSet.getInt("rid"));
				rr.setDid(resultSet.getString("did"));
				rr.setSid(resultSet.getInt("sid"));
				rr.setStatus(resultSet.getString("status"));
				
			 

				ListRequest.add(rr);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ListRequest;
	}

	@Override
	public void update(String id) {
		String accept="Accepted";
		String sql = "Update requests set status='"+accept+"' where rid='"+id+"' ";
		 
		try {
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
