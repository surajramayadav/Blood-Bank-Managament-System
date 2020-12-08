package dao;
import java.sql.*;

import com.util.DBConnectionUtil;
public class AdminDAOImpl implements AdminDao {

	@Override
	public Integer DonorCount() {
		int SampleCollectorCount = 0;
	    Connection connection = null;
	    ResultSet resultSet = null;
	    //		PreparedStatement preparedStatement = null;
	    Statement statement;

	    String query = "select count(*) from donor";
	    try {
	      connection = DBConnectionUtil.openConnection();

	      statement = connection.createStatement();
	      resultSet = statement.executeQuery(query);
	      resultSet.next();
	      SampleCollectorCount = resultSet.getInt(1);
	      //System.out.println("Number of records in the cricketers_data table: "+count);

	    } catch (ClassNotFoundException | SQLException e) {
	      e.printStackTrace();
	    }
	    return SampleCollectorCount;
	
	}

	@Override
	public Integer SeekerCount() {
		int SampleCollectorCount = 0;
	    Connection connection = null;
	    ResultSet resultSet = null;
	    //		PreparedStatement preparedStatement = null;
	    Statement statement;

	    String query = "select count(*) from seeker";
	    try {
	      connection = DBConnectionUtil.openConnection();

	      statement = connection.createStatement();
	      resultSet = statement.executeQuery(query);
	      resultSet.next();
	      SampleCollectorCount = resultSet.getInt(1);
	      //System.out.println("Number of records in the cricketers_data table: "+count);

	    } catch (ClassNotFoundException | SQLException e) {
	      e.printStackTrace();
	    }
	    return SampleCollectorCount;
	
	}

	@Override
	public Integer ReqCount() {
		int SampleCollectorCount = 0;
	    Connection connection = null;
	    ResultSet resultSet = null;
	    //		PreparedStatement preparedStatement = null;
	    Statement statement;

	    String query = "select count(*) from requests";
	    try {
	      connection = DBConnectionUtil.openConnection();

	      statement = connection.createStatement();
	      resultSet = statement.executeQuery(query);
	      resultSet.next();
	      SampleCollectorCount = resultSet.getInt(1);
	      //System.out.println("Number of records in the cricketers_data table: "+count);

	    } catch (ClassNotFoundException | SQLException e) {
	      e.printStackTrace();
	    }
	    return SampleCollectorCount;
	
	}

}
