package ser;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.application.Application;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.database;
import info.Dormitory;
import info.Login;
import info.bbs;
import info.suggest;

/**
 * Servlet implementation class initservlet
 */
@WebServlet("/initservlet")
public class initservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public initservlet() {
		super();
	}
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		//app就是tomcat的一个空间
    	database d=new database();
		ArrayList<Dormitory> arrayList= d.querydormitory();
		ServletContext app = this.getServletContext();//application对象
		app.setAttribute("arraylist", arrayList);
		ArrayList<bbs> arrayList2= d.querybbs();
		app.setAttribute("bbs_arraylist", arrayList2);
		ArrayList<suggest> arrayList3=d.querysug();
		app.setAttribute("sug_arraylist", arrayList3);
		//System.out.println("宿舍size:"+arrayList.size());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
