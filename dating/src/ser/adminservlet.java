package ser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminservlet
 */
@WebServlet("/adminservlet")
public class adminservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminservlet() {
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
		String account=request.getParameter("adminaccount");
		String password=request.getParameter("adminpassword");
		if(status.equals("adminlogin")){
			System.out.println("adminlogin");
			if(account.equals(password)){
				System.out.println("正确");
				request.getSession().setAttribute("adminname", account);
				Cookie cookieaccount=new Cookie("adminaccount",account);
				Cookie cookiepassword=new Cookie("adminpassword",password);
				cookieaccount.setMaxAge(2323232);
				cookiepassword.setMaxAge(cookieaccount.getMaxAge());
				response.addCookie(cookieaccount);//将cookie保存在客户端
				response.addCookie(cookiepassword);
				response.sendRedirect("/dating/admin/admin.jsp");
			}
			else{
				System.out.println("错误");
				request.setAttribute("adminerror", "登录失败");
				request.getRequestDispatcher("/adminlogin.jsp").forward(request, response);
			}
		}
		if(status.equals("adminauto")){
			System.out.println("adminauto");
			Cookie[] cookies=request.getCookies();
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("adminaccount"))
					request.setAttribute("adminaccount", cookie.getValue());
				if(cookie.getName().equals("adminpassword"))
					request.setAttribute("adminpassword", cookie.getValue());
			}
			request.getRequestDispatcher("/adminlogin.jsp").forward(request, response);
		}
	
	}

}
