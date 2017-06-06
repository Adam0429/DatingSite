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
public class myservlet extends HttpServlet {//��̬�ֻ࣬�ܴ���һ�ζ���
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myservlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {//��������ʱ����
		// TODO Auto-generated method stub
    	System.out.println("init");
    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {//��������ʱ����
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
		request.setCharacterEncoding("utf-8");//���ݱ�������request����,����requestҲҪ���ñ���
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
			request.setAttribute("Logins", arrayList);//��ser�����ݴ�����ͼҳ��(jsp)
			RequestDispatcher dispatcher= request.getRequestDispatcher("/query.jsp");//ser-->jsp ��ת,���ض�����������,��ַû�б仯
			dispatcher.forward(request, response);//ת��s]
		}
		//System.out.println(request.getParameter("name"));
		//System.out.println(request.getParameter("tele"));
		//System.out.println(request.getParameter("account"));
		//System.out.println(request.getParameter("password"));
	}

}