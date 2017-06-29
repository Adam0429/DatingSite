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

import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;

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
		doPost(request, response);//href默认调用doGet方法,例如这样,http://localhost:8080/dating/myser?account=1&status=delete.并没有form表单来指定调用什么方法
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//数据被存入了request当中,所以request也要设置编码
		String status=request.getParameter("status");
		database d=new database();
		if(status.equals("insert")){
		
			System.out.println("-----insert-----");
			Login login=new Login();
			login.setName(request.getParameter("name"));
			login.setTele(request.getParameter("tele"));
			login.setAccount(request.getParameter("account"));
			login.setPassword(request.getParameter("password"));

			d.save(login);
			
		}
			
		else if(status.equals("queryname")){//应考虑到账号重复的情况,服务器端能收到报错,用户并不知道错误
			
			System.out.println("------queryname-----");

			ArrayList<Login> arrayList=d.query(request.getParameter("nameOraccount"),"name");
			request.setAttribute("Logins", arrayList);//把ser的数据传到视图页面(jsp)
			RequestDispatcher dispatcher= request.getRequestDispatcher("/query.jsp");
			/*重定向和转发都都始于服务器端，而提交表单，无论是从哪提交、提交到哪，都是由客户端发起。form不属于重定向和转发
			硬要说相似的话，可以说像重定向的一个步骤，就是由浏览器请求重定向资源这步。
			request.getRequestDispatcher()是请求转发，前后页面共享一个request
			ser-->jsp 跳转,和重定向的区别就是,地址没有变化*/
			dispatcher.forward(request, response);//转发
		}
		
		else if(status.equals("queryaccount")){
			
			System.out.println("------queryaccount-----");

			ArrayList<Login> arrayList=d.query(request.getParameter("nameOraccount"),"account");
			request.setAttribute("Logins", arrayList);//把ser的数据传到视图页面(jsp)
			RequestDispatcher dispatcher= request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);//转发
		}
		//System.out.println(request.getParameter("name"));
		//System.out.println(request.getParameter("tele"));
		//System.out.println(request.getParameter("account"));
		//System.out.println(request.getParameter("password"));
		
		else if(status.equals("delete")){
			
			System.out.println("------delete-----");

			d.delete(request.getParameter("account"));
			ArrayList<Login> arrayList=d.query(request.getParameter("name"),"name");
		}
		
		else if(status.equals("update")){
			
			System.out.println("------update-----");
			d.update(request.getParameter("account"),request.getParameter("name"),request.getParameter("tele"),request.getParameter("password"));
		
		}
	}

}