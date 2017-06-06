package ser;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import db.database;
import info.Login;

/**
 * Servlet implementation class myservlet
 */
@WebServlet("/servlet/myservlet")
public class myservlet extends HttpServlet {//单态类，只能创建一次对象
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myservlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {//容器启动时运行
		// TODO Auto-generated method stub
    	System.out.println("init");
    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {//容器销毁时运行
		System.out.println("destroy");
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
		request.setCharacterEncoding("utf-8");//数据被存入了request当中,所以request也要设置编码
		String status=request.getParameter("status");
		if(status.equals("insert"))
		{
			System.out.println("-----insert-----");
			Login login=new Login();
			login.setName(request.getParameter("name"));
			login.setTele(request.getParameter("tele"));
			login.setAccount(request.getParameter("account"));
			login.setPassword(request.getParameter("password"));
			database d=new database();
			d.save(login);
			
		}
			
		if(status.equals("query")){
			
			System.out.println("------query-----");
			database d=new database();
			ArrayList<Login> arrayList=d.query(request.getParameter("name"));
			request.setAttribute("Logins", arrayList);//把ser的数据传到视图页面(jsp)
			RequestDispatcher dispatcher= request.getRequestDispatcher("/query.jsp");//ser-->jsp 跳转,和重定向的区别就是,地址没有变化
			dispatcher.forward(request, response);//转发s]
		}
		//System.out.println(request.getParameter("name"));
		//System.out.println(request.getParameter("tele"));
		//System.out.println(request.getParameter("account"));
		//System.out.println(request.getParameter("password"));
	}

}