package ser;

import java.io.IOException;
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
public class myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myservlet() {
        super();
        // TODO Auto-generated constructor stub
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
