package dao;

import java.util.List;

import com.bloodbank.model.Donor;
import com.bloodbank.model.Seeker;



public interface SeekerDAO {
	boolean save(Seeker sr);
	boolean update(Seeker sr);
	boolean delete(String sid);

	String SeekerLogin(Seeker srlogin);
	Integer sidSeeker(Seeker srlogin);
	 List<Seeker>  SeekerId(String Email);
	List<Seeker> getSeeker();
}
