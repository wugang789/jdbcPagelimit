package com.cn.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.bean.Student;
import com.cn.dao.StudenDao;
import com.cn.util.Page;

/**
 * Servlet implementation class view
 */
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println(">>>>>>>>>..");
		int currentPage = 1;  
		    try {  
		    	currentPage = Integer.parseInt(request.getParameter("currentPage"));  
		    } catch (Exception ex) {}  
		      
		    //取得总记录数，创建Page对象  
		    System.out.println(currentPage);
		    int totalRow = StudenDao.getCount();//通过select count 取得总记录数  
		    System.out.println(totalRow);
		    Page page = new Page(totalRow, currentPage);  
		   List<Student> list= StudenDao.getStudentsByPage(page);
		    System.out.println(list);
	}
		
		

}
