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

import dao.AdminDAOImpl;
import dao.AdminDao;
import dao.DonorDAO;
import dao.DonorDAOImpl;
import dao.RequestDAO;
import dao.RequestDAOImpl;
import dao.SeekerDAO;
import dao.SeekerDAOImpl;



@WebServlet({ "/AdminServlet", "/AdminServlet/login","/AdminServlet/LogoutServlet","/AdminServlet/Donor","/AdminServlet/Seeker","/AdminServlet/request","/AdminServlet/delete","/AdminServlet/Undo" })

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DonorDAO donorDAO = null;
	SeekerDAO seekerDAO = null;
	RequestDAO requestDAO=null;
	AdminDao adminDao=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();

        donorDAO = new DonorDAOImpl();
        seekerDAO=new SeekerDAOImpl();
        requestDAO=new RequestDAOImpl();
        adminDao=new AdminDAOImpl();  
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		  HttpSession session = request.getSession();
		switch (action) {
		case "/AdminServlet":
			Integer donor=adminDao.DonorCount();
			Integer seeker=adminDao.SeekerCount();
			Integer rr=adminDao.ReqCount();
			request.setAttribute("donor", donor);
			request.setAttribute("seeker", seeker);
			request.setAttribute("rr", rr);
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/Welcome.jsp");
			
			dispatcher.forward(request, response);
		
			break;

		case "/AdminServlet/login":
			 dispatcher = request.getRequestDispatcher("../view/admin/login.jsp");
			dispatcher.forward(request, response);
			break;

			
		case "/AdminServlet/LogoutServlet":
			 session = request.getSession();
			 session.setAttribute("drEmail",null);
			 session.setAttribute("srEmail", null);
			 session.setAttribute("adEmail", null);
			 response.sendRedirect("http://localhost:9090/BloodBank/AdminServlet/login");
			break;
			
       case "/AdminServlet/Donor":

    	   List<Donor> ListDonor = donorDAO.getDonor();
    		
			request.setAttribute("list", ListDonor);
			
		
		    dispatcher = request.getRequestDispatcher("../view/admin/Donor.jsp");
			dispatcher.forward(request, response);
			break;
			
       case "/AdminServlet/Seeker":
    	   List<Seeker> ListSeeker = seekerDAO.getSeeker();
    	   request.setAttribute("list", ListSeeker);
    	   dispatcher = request.getRequestDispatcher("../view/admin/Seeker.jsp");
		dispatcher.forward(request, response);
			break;
       case "/AdminServlet/request":
    	   List<Request> ListRequest = requestDAO.getRequest();
    	   System.out.println(ListRequest);
    	   request.setAttribute("list", ListRequest);
    	   dispatcher = request.getRequestDispatcher("../view/admin/Request.jsp");
   		dispatcher.forward(request, response);
			break;
		
       case "/AdminServlet/delete":
    		String  d_id= request.getParameter("d_id");
    		donorDAO.delete(d_id);
    		 response.sendRedirect("http://localhost:9090/BloodBank/AdminServlet/Donor");
			break;
			
       case "/AdminServlet/Undo":
    		System.out.println("reuest1");
   		String  sid= request.getParameter("sid");
   		System.out.println("reuest1"+sid);
   		seekerDAO.delete(sid);
   		System.out.println("reuest2");
   		 response.sendRedirect("http://localhost:9090/BloodBank/AdminServlet/Seeker");
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
				case "/AdminServlet":
					System.out.println("POST");
					break;
				case "/AdminServlet/login":
					
				if(email.equals("admin")&& password.equals("12345"))
				{
					session.setAttribute("adEmail", email);
					response.sendRedirect("../AdminServlet");
				}
				else {
					request.setAttribute("message", "Login Failed");
					System.out.println("Login Invalid");
					doGet(request, response);
				}
	      

					break;
				
				case "/AdminServlet/edit":
					
					break;
				case "/AdminServlet/delete":
					break;
				default:
					break;
			}
	}

}
