package ser;

import java.io.IOException;
import java.util.ArrayList;

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
import info.suggest;

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
    
    public void init() throws ServletException {
    	//有两种init方法,分别是不带参数的init和init(ServletConfig config)
    	/*在Servlet初始化的时候，会自动调用init(ServletConfig config)，Container会自动收集一些该Servlet的配置信息，
    	生成一个ServletConfig的实例，通过调用该实例的四个getXXX方法（即ServletConfig,ServletContext接口中的四个方法），
    	我们可以得到该Servlet的这些配置信息。
    	如果忘记去调用super.init(config);
    	GenericServlet的config属性不能初始化，以至于当调用getServletConfig()的时候，会有空指针exception
    	init(ServletConfig config)  
       	super.init(config);  如果子类复写init(ServletConfig config)方法时,忘写super.init(config),则运行汇报NullPointerException异常*/
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
	
		String status=request.getParameter("status");
		database d=new database();
		//不要把存储数据的对象设置为全局变量,因为servlet是单态类
		if(status.equals("insert")){
			
			System.out.println("-----insert-----");
			Login login=new Login();
			if(request.getParameter("account")!=""&&request.getParameter("password")!=""&&request.getParameter("name")!=""){
				login.setAccount(request.getParameter("account"));
				login.setName(request.getParameter("name"));
				login.setPassword(request.getParameter("password"));
				login.setGender(request.getParameter("gender"));
				login.setTele(request.getParameter("tele"));
				login.setDormitory(request.getParameter("dormitory"));
				d.save(login);
				response.sendRedirect("/dating/success.jsp");
			}
			else {
				request.setAttribute("RegisterError", "注册失败,用户名 密码 昵称 不能为空");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		
		
		else if(status.equals("queryname")){//应考虑到账号重复的情况,服务器端能收到报错,用户并不知道错误
		
			System.out.println("------queryname-----");
			
			String nameOraccount=request.getParameter("nameOraccount").toString();
			

			//request.getAttribute("username")是获取setattribute里的或是容器里面的值，在整个容器中有效,如tomcat
			//request.getParameter("username") 是获取上一个页面传入本页面的值,得到的是GET/POST和表单传递过来的字符串
			//这两种要分清使用
			int totalpage=d.countpage(nameOraccount, "name");
			request.getSession().setAttribute("nameOraccount",nameOraccount);
			request.getSession().setAttribute("page",1);
			request.getSession().setAttribute("totalpage",totalpage);
			request.getSession().setAttribute("querystatus", status);//为了给splitpage识别用什么方法
			ArrayList<Login> arrayList=d.query(nameOraccount,"name",1);
			request.setAttribute("Logins", arrayList);//把ser的数据传到视图页面(jsp)
			RequestDispatcher dispatcher= request.getRequestDispatcher("/query.jsp");
			/*转发是,servlet用一个命令把一个页面返回给用户（用户->ser->页面->用户）,重定向是servlet告诉用户要去访问一个页面
			 (用户->ser->用户->页面)
			request.getRequestDispatcher()是请求转发，前后页面共享一个request
			ser-->jsp 跳转,此跳转是内部跳转不能跳转到工程外的页面,和重定向的区别就是,地址没有变化*/
			dispatcher.forward(request, response);
			/*两种方法用哪个取决于需求.数据共享->内部跳转.不需要->外部跳转(重定向)
			 当你要跳转页面但是你又要用到前一个页面的某些信息的时候可以用这个方法
			当你要跳转页面并且不需要用到前一个页面的信息时你可以选择用redirect（重定向）*/
		}
		
		else if(status.equals("queryaccount")){
			
			System.out.println("------queryaccount-----");
			String nameOraccount=request.getParameter("nameOraccount").toString();
			
			
			int totalpage=d.countpage(nameOraccount, "account");
			request.getSession().setAttribute("nameOraccount",nameOraccount);
			request.getSession().setAttribute("page",1);
			request.getSession().setAttribute("totalpage",totalpage);
			request.getSession().setAttribute("querystatus", status);
			ArrayList<Login> arrayList=d.query(nameOraccount,"account",1);
			request.setAttribute("Logins", arrayList);
			RequestDispatcher dispatcher= request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(status.equals("splitpage")){
			System.out.println("------split------");
			String querystatus=request.getSession().getAttribute("querystatus").toString();
			ArrayList<Login> arrayList = null;
			int page=Integer.parseInt(request.getParameter("page"));//这里的page是通过url的方式传过来的,不会上面setattribute里的
			String nameOraccount=request.getSession().getAttribute("nameOraccount").toString();
			request.getSession().setAttribute("page",page);
			if(querystatus.equals("queryname"))
				arrayList=d.query(nameOraccount,"name",page);
			else if(querystatus.equals("queryaccount"))
				arrayList=d.query(nameOraccount,"account",page);
			request.setAttribute("Logins", arrayList);
			RequestDispatcher dispatcher= request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(status.equals("delete")){
			
			System.out.println("------delete-----");
			if(request.getSession().getAttribute("adminname")!=null){
				d.delete(request.getParameter("account"));

				ArrayList<Login> arrayList=d.query(request.getSession().getAttribute("nameOraccount").toString(),"account",1);
				request.setAttribute("Logins", arrayList);
				RequestDispatcher dispatcher= request.getRequestDispatcher("/query.jsp");
				dispatcher.forward(request, response);
			}
			
			else
				response.sendRedirect("/dating/noadmin.jsp");
		}
		
		else if(status.equals("update")){
			
			System.out.println("------update-----");
			System.out.println(request.getParameter("gender"));
			d.update(request.getParameter("account"),request.getParameter("name"),request.getParameter("tele"),request.getParameter("password"),request.getParameter("gender"),request.getParameter("dormitory"));
		
		}
		
		else if(status.equals("suggest")){
			System.out.println("----suggest-----");
			String sug=request.getParameter("suggest");
			d.sug(sug);
			ServletContext app = this.getServletContext();
			ArrayList<suggest> arrayList3=d.querysug();
			app.setAttribute("sug_arraylist", arrayList3);
			request.getRequestDispatcher("/suggest.jsp").forward(request, response);
		}
	}

}