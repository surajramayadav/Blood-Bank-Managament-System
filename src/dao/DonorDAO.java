package dao;

import com.bloodbank.model.Donor;
import java.util.List;
public interface DonorDAO {
	boolean save(Donor dr);
	boolean update(Donor dr);
	boolean delete(String d_id);

	String DonorLogin(Donor drlogin);
	Integer didDonor(Donor drlogin);
	 List<Donor>  DonorId(String Email);
	List<Donor> getDonor();
}
