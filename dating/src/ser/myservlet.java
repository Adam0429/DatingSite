package ser;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		Login login=new Login();
		login.setName(request.getParameter("name"));
		login.setTele(request.getParameter("tele"));
		login.setAccount(request.getParameter("account"));
		login.setPassword(request.getParameter("password"));
		database d=new database();
		d.save(login);
		System.out.println("-----post-----");
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("tele"));
		System.out.println(request.getParameter("account"));
		System.out.println(request.getParameter("password"));
	}

}