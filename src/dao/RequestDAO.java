package dao;

import java.util.List;

import com.bloodbank.model.Request;



public interface RequestDAO {
	boolean save(Request rr);
	void update(String id);
	boolean delete(int id);
	List<Request> getData(Integer d_id);
	
	List<Request> getRequest();
}
