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
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		if(status.equals("login")){
			if(account.equals(password)){
				request.getSession().setAttribute("name", account);
				Cookie cookieaccount=new Cookie("account",account);
				Cookie cookiepassword=new Cookie("password",password);
				cookieaccount.setMaxAge(2323232);
				cookiepassword.setMaxAge(cookieaccount.getMaxAge());
				response.addCookie(cookieaccount);//将cookie保存在客户端
				response.addCookie(cookiepassword);
				response.sendRedirect("/dating/admin/admin.jsp");
			}
			else{
				request.setAttribute("error", "登录失败");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
		if(status.equals("auto")){
			System.out.println("auto");
			Cookie[] cookies=request.getCookies();
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("account"))
					request.setAttribute("account", cookie.getValue());
				if(cookie.getName().equals("password"))
					request.setAttribute("password", cookie.getValue());
			}
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	
	}

}
