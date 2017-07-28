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
			}
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		if(status.equals("newbbs")){
			database.newbbs(database.bbs_number(),request.getParameter("bbs_content"),request.getSession().getAttribute("loginaccount").toString());
			ArrayList<bbs> arrayList= database.querybbs();
			request.setAttribute("bbs_arraylist", arrayList);
			request.getRequestDispatcher("/login/bbs_frame.jsp").forward(request, response);
		}
		
		if(status.equals("browse_bbs")){
			
			ArrayList<bbs> arrayList= database.querybbs();
			request.setAttribute("bbs_arraylist", arrayList);
			request.getRequestDispatcher("/login/bbs_frame.jsp").forward(request, response);
		}
	}

}
