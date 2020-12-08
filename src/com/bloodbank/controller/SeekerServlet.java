package com.bloodbank.controller;

import java.io.IOException;
import java.util.List;

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

import dao.DonorDAOImpl;
import dao.RequestDAO;
import dao.RequestDAOImpl;
import dao.DonorDAO;
import dao.SeekerDAO;
import dao.SeekerDAOImpl;


@WebServlet({ "/SeekerServlet", "/SeekerServlet/create", "/SeekerServlet/login","/SeekerServlet/edit","/SeekerServlet/LogoutServlet","/SeekerServlet/request" })

public class SeekerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SeekerDAO seekerDAO = null;
	DonorDAO donorDAO = null;
	RequestDAO requestDAO=null;
    public SeekerServlet() {
        super();
        System.out.println("listseeker");
        seekerDAO=new SeekerDAOImpl();
        donorDAO = new DonorDAOImpl();
        requestDAO=new RequestDAOImpl();
        List<Seeker> ListSeeker = seekerDAO.getSeeker();
		
		
		System.out.println(ListSeeker);
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getServletPath();
		switch (action) {
		case "/SeekerServlet":
			
	
		
              List<Donor> ListDonor = donorDAO.getDonor();
			
		
			request.setAttribute("list", ListDonor);
			System.out.println(ListDonor);
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/seeker/WelcomeSeeker.jsp");
			dispatcher.forward(request, response);

			break;

		case "/SeekerServlet/login":
			
			dispatcher = request.getRequestDispatcher("../view/seeker/login.jsp");
			dispatcher.forward(request, response);

			break;

		case "/SeekerServlet/create":

			dispatcher = request.getRequestDispatcher("../view/seeker/register.jsp");
			dispatcher.forward(request, response);

			break;
		case "/SeekerServlet/edit":
			System.out.println("inside");
			  HttpSession session = request.getSession();
				 String email=(String)session.getAttribute("srEmail");  
				 System.out.println("inside"+email);
				 List<Seeker> ListSeeker = seekerDAO.SeekerId(email);
				 System.out.println("inside1");
					request.setAttribute("list", ListSeeker);
					System.out.println(ListSeeker);
					System.out.println("inside1"+ListSeeker);
					 dispatcher = request.getRequestDispatcher("../view/seeker/edit.jsp");
					dispatcher.forward(request, response);
			break;

		case "/SeekerServlet/delete":
			break;
			
		case "/SeekerServlet/LogoutServlet":
			session = request.getSession();
			 session.setAttribute("drEmail",null);
			 response.sendRedirect("http://localhost:9090/BloodBank/SeekerServlet/login");
			break;
			
		case "/SeekerServlet/request":
			System.out.println("reuest");
			Request rr=new Request();
		    session = request.getSession();
			String  did= request.getParameter("d_id");
			System.out.println("reuest1");
			rr.setDid(did);
			System.out.println("reuest2");
			rr.setStatus("Requested");
			rr.setSid((Integer) session.getAttribute("sid"));
			System.out.println("reuest3");
			requestDAO.save(rr);
			
			 response.sendRedirect("http://localhost:9090/BloodBank/SeekerServlet");
			
			
			break;
		default:
			break;

	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
			case "/SeekerServlet":
				System.out.println("POST");
				break;
			case "/SeekerServlet/login":
				
				HttpSession session = request.getSession();
      
				Seeker srLogin = new Seeker();
				System.out.println(email);
				System.out.println(password);
				srLogin.setEmail(email);
				srLogin.setPassword(password);

				String status = seekerDAO.SeekerLogin(srLogin);
              
				if (status.equals("true")) {
					session.setAttribute("srEmail", srLogin.getEmail());
					System.out.println("IN SERVLET SET");
					System.out.println(srLogin.getEmail());
					int sid=seekerDAO.sidSeeker(srLogin);
					System.out.print(sid);
					session.setAttribute("sid", sid);
					response.sendRedirect("../SeekerServlet");
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
			case "/SeekerServlet/create":

				System.out.println("POST" + action);

				Seeker sr = new Seeker();

				sr.setPassword(password);
				sr.setName(name);
				sr.setPhone(phone);

				sr.setEmail(email);
				sr.setGender(gender);
				sr.setAge(age);
				sr.setState(state);
				sr.setCity(city);
				sr.setBlood_group(blood_group);
				

				if (seekerDAO.save(sr)) {
					request.setAttribute("message", "Seeker Details Inserted Successfully.");
					response.sendRedirect("../SeekerServlet/login");
				} else {
					request.setAttribute("message", "Error somewhere !");
					doGet(request, response);
				}

				break;
			case "/SeekerServlet/edit":
				
				 session = request.getSession();
				    sr = new Seeker();

				    sr.setPassword(password);
				    sr.setName(name);
				    sr.setPhone(phone);

				    sr.setEmail(email);
				    sr.setGender(gender);
				    sr.setAge(age);
				    sr.setState(state);
				    sr.setCity(city);
				    sr.setBlood_group(blood_group);
				    sr.setSid((Integer) session.getAttribute("sid"));
					
				    seekerDAO.update(sr);
					System.out.println(seekerDAO.update(sr));
					response.sendRedirect("../SeekerServlet/edit");
				break;
			case "/SeekerServlet/delete":
				break;
			default:
				break;
		}
	}

}
