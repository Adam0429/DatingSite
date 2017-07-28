package ser;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;

import db.database;
import info.Dormitory;
import info.Login;



 

public class dorservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
     
    public dorservlet() {
        super();
    
    }
    
    public void init() throws ServletException {


    }

	

	 
	public void destroy() {

	
	}

	

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	 
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String status=request.getParameter("status");
		database d=new database();
		if(status.equals("insertdormitory")){
			
			System.out.println("-----insertdormitory-----");
			

			Dormitory dormitory=new Dormitory();
			dormitory.setName(request.getParameter("dormitory"));
			d.savedormitory(dormitory);
			ArrayList<Dormitory> arrayList= d.querydormitory();
			ServletContext app = this.getServletContext();
			app.setAttribute("arraylist", arrayList);
			response.sendRedirect("/dating/admin/dormitory.jsp");
		}
		
		else if(status.equals("deletedormitory")){
			
			System.out.println("-----deletedormitory-----");
			

			
			d.deletedormitory(request.getParameter("dormitory"));
			ArrayList<Dormitory> arrayList=new ArrayList<Dormitory>();
			arrayList=d.querydormitory();
			ServletContext app=request.getServletContext();
			app.setAttribute("arraylist", arrayList);
			response.sendRedirect("/dating/admin/updatedor.jsp");//外部跳转,可以跳转到外网,但是不能转发request
//			RequestDispatcher dispatcher=request.getRequestDispatcher("/updatedor.jsp");
//			dispatcher.forward(request, response);
			
		}
	}
}
