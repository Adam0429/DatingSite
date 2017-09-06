package ser;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.database;
import info.bbs;
import info.reply;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() throws ServletException {
		System.out.println("login!!!!!!!!!!!!!!!!!!!!!!!");
		//System.out.println("宿舍size:"+arrayList.size());
	}
	
    public loginservlet() {
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
		String status=request.getParameter("status");
		System.out.println(status);
		String account=request.getParameter("loginaccount");
		String password=request.getParameter("loginpassword");
		database database=new database();
		if(status.equals("login")){

			if(database.check(account, password)){
				System.out.println("正确");
				request.getSession().setAttribute("loginaccount", account);
				Cookie cookieaccount=new Cookie("loginaccount",account);
				Cookie cookiepassword=new Cookie("loginpassword",password);
				cookieaccount.setMaxAge(2323232);
				cookiepassword.setMaxAge(cookieaccount.getMaxAge());
				response.addCookie(cookieaccount);//将cookie保存在客户端
				response.addCookie(cookiepassword);
				response.sendRedirect("/dating/login/loginframe.jsp");
				ArrayList<bbs> arrayList= database.querybbs();
				request.getSession().setAttribute("bbs_arraylist", arrayList);
			}
			else{
				System.out.println("错误");
				request.setAttribute("error", "账号或密码错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
		
		if(status.equals("loginauto")){

			Cookie[] cookies=request.getCookies();
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("loginaccount"))
					request.setAttribute("loginaccount", cookie.getValue());
				
				if(cookie.getName().equals("loginpassword")){
					request.setAttribute("loginpassword", cookie.getValue());

				}
				ArrayList<bbs> arrayList= database.querybbs();
				request.getSession().setAttribute("bbs_arraylist", arrayList);
			}
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		if(status.equals("newbbs")){
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date currentTime = new java.util.Date();//得到当前系统时间  
			String time = formatter.format(currentTime); //将日期时间格式化  
			database.newbbs(database.bbs_number(),request.getParameter("bbs_title").toString(),request.getParameter("bbs_content").toString(),request.getSession().getAttribute("loginaccount").toString(),time);
			ArrayList<bbs> arrayList= database.querybbs();
			this.getServletContext().setAttribute("bbs_arraylist", arrayList);
			request.getRequestDispatcher("/login/bbs_frame.jsp").forward(request, response);
		}
		
		if(status.equals("bbs_frame")){
			
			ArrayList<bbs> arrayList= database.querybbs();
			request.getSession().setAttribute("bbs_arraylist", arrayList);//存到session是为了让用户随时浏览
			request.getRequestDispatcher("/login/bbs_frame.jsp").forward(request, response);
		}
		
		if(status.equals("bbs_browse")){
			String id=request.getParameter("bbs_id");
			bbs b=database.bbs_browse(id);
			request.getSession().setAttribute("bbs",b);
			ArrayList<reply> arrayList=database.queryreply(id);
			request.getSession().setAttribute("reply_arraylist",arrayList);
			request.getRequestDispatcher("login/bbs_browse.jsp").forward(request, response);
		}
		
		if(status.equals("reply")){
			System.out.println("reply");
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date currentTime = new java.util.Date(); 
			String time = formatter.format(currentTime);
			String login_account=request.getSession().getAttribute("loginaccount").toString();
			String reply_content=request.getParameter("replycontent");
			bbs b=(bbs) request.getSession().getAttribute("bbs");
			String id=b.getBbs_id();
			database.newreply(database.reply_number(), reply_content,id, time, login_account);
		}
	}

}
