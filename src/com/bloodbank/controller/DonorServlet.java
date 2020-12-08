package com.bloodbank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodbank.model.Donor;
import com.bloodbank.model.Request;
import com.bloodbank.model.Seeker;

import java.util.List;

import dao.DonorDAO;
import dao.DonorDAOImpl;
import dao.RequestDAO;
import dao.RequestDAOImpl;
import dao.SeekerDAO;
import dao.SeekerDAOImpl;

/**
 * Servlet implementation class DonorServlet
 */


@WebServlet({ "/DonorServlet", "/DonorServlet/create", "/DonorServlet/login","/DonorServlet/edit","/DonorServlet/LogoutServlet","/DonorServlet/request" })
public class DonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DonorDAO donorDAO = null;
	SeekerDAO seekerDAO = null;
	RequestDAO requestDAO=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorServlet() {
        super();
     
        donorDAO = new DonorDAOImpl();
        seekerDAO=new SeekerDAOImpl();
        requestDAO=new RequestDAOImpl();
        
   
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/DonorServlet":
		
			List<Seeker> ListSeeker = seekerDAO.getSeeker();
			  HttpSession session = request.getSession();
			 Integer ddid=  (Integer) session.getAttribute("d_id");
			List<Request> ListRequest = requestDAO.getData(ddid);
			request.setAttribute("list", ListSeeker);
			request.setAttribute("list1", ListRequest);
			System.out.println(ListRequest);
			System.out.println("ListSeeker"+ListRequest);
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/donor/WelcomeDonor.jsp");
			dispatcher.forward(request, response);

			break;

		case "/DonorServlet/login":
			
			dispatcher = request.getRequestDispatcher("../view/donor/login.jsp");
			dispatcher.forward(request, response);

			break;

		case "/DonorServlet/create":

			dispatcher = request.getRequestDispatcher("../view/donor/register.jsp");
			dispatcher.forward(request, response);

			break;
		case "/DonorServlet/edit":
			  session = request.getSession();
			 String email=(String)session.getAttribute("drEmail");  
			 List<Donor> ListDonor = donorDAO.DonorId(email);
			 
				request.setAttribute("list", ListDonor);
				System.out.println(ListDonor);
				 dispatcher = request.getRequestDispatcher("../view/donor/edit.jsp");
				dispatcher.forward(request, response);
			break;

		case "/DonorServlet/delete":
			break;
		case "/DonorServlet/LogoutServlet":
			 session = request.getSession();
			 session.setAttribute("drEmail",null);
			 session.setAttribute("srEmail", null);
			 response.sendRedirect("http://localhost:9090/BloodBank/DonorServlet/login");
			break;
			
		case "/DonorServlet/request":
			System.out.println("reuest");
			Request rr=new Request();
		    session = request.getSession();
			String  id= request.getParameter("id");
			System.out.println("reuest1"+id);
			requestDAO.update(id);
			
			 response.sendRedirect("http://localhost:9090/BloodBank/DonorServlet");
			break;

		default:
			break;

	}

}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String pt_id = request.getParameter("pt_id");
		 HttpSession session = request.getSession();
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
	
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		String age = request.getParameter("age");
		
	
		String blood_group = request.getParameter("blood_group");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		
		String action = request.getServletPath();
		System.out.println(action);
		switch (action) {
			case "/DonorServlet":
				System.out.println("POST");
				break;
			case "/DonorServlet/login":
				
			
      
				Donor drLogin = new Donor();
				System.out.println(email);
				System.out.println(password);
				drLogin.setEmail(email);
				drLogin.setPassword(password);
				
				String status = donorDAO.DonorLogin(drLogin);

				if (status.equals("true")) {
					session.setAttribute("drEmail", drLogin.getEmail());
					System.out.println(drLogin.getEmail());
					System.out.println("IN SERVLET SET");
					System.out.println(drLogin.getEmail());
					int d_id=donorDAO.didDonor(drLogin);
					System.out.print(d_id);
					session.setAttribute("d_id", d_id);
					
					response.sendRedirect("../DonorServlet");
				} else if (status.equals("false")) {
					request.setAttribute("message", "Login Failed");
					System.out.println("Login Invalid");
					doGet(request, response);
				} else {
					request.setAttribute("message", "Login Error");
					System.out.println("Error");
					doGet(request, response);
				}

				break;
			case "/DonorServlet/create":

				System.out.println("POST" + action);

				Donor dr = new Donor();

				dr.setPassword(password);
				dr.setName(name);
				dr.setPhone(phone);

				dr.setEmail(email);
				dr.setGender(gender);
				dr.setAge(age);
                dr.setState(state);
                dr.setCity(city);
				dr.setBlood_group(blood_group);
				
				
				

				if (donorDAO.save(dr)) {
					request.setAttribute("message", "Donor Details Inserted Successfully.");
					response.sendRedirect("../DonorServlet/login");
				} else {
					request.setAttribute("message", "Error somewhere !");
					doGet(request, response);
				}

				break;
			case "/DonorServlet/edit":
				 session = request.getSession();
			    dr = new Donor();

				dr.setPassword(password);
				dr.setName(name);
				dr.setPhone(phone);

				dr.setEmail(email);
				dr.setGender(gender);
				dr.setAge(age);
                dr.setState(state);
                dr.setCity(city);
				dr.setBlood_group(blood_group);
				dr.setd_id((Integer) session.getAttribute("d_id"));
				
				donorDAO.update(dr);
				System.out.println(donorDAO.update(dr));
				response.sendRedirect("../DonorServlet/edit");
				break;
			case "/DonorServlet/delete":
				break;
			default:
				break;
		}
	}
	

}
