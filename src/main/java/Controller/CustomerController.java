package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.CustomerService;
import Service.CustomerServiceImpl;

@WebServlet("*.co")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerService service;
	
	public CustomerController() {
		service = new CustomerServiceImpl();
	}

	protected void doGet(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(requset, response);
	}

	protected void doPost(HttpServletRequest requset, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(requset, resp);
	}
	
	protected void doProcess(HttpServletRequest requset, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doProcess");
		String uri = requset.getRequestURI();
	}
	
	
	
	
}
