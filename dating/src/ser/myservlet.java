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
		doPost(request, response);//hrefĬ�ϵ���doGet����,��������,http://localhost:8080/dating/myser?account=1&status=delete.��û��form����ָ������ʲô����
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//���ݱ�������request����,����requestҲҪ���ñ���
		String status=request.getParameter("status");
		database d=new database();
		//��Ҫ�Ѵ洢���ݵĶ�������Ϊȫ�ֱ���,��Ϊservlet�ǵ�̬��
		if(status.equals("insert")){
		
			System.out.println("-----insert-----");
			Login login=new Login();
			login.setName(request.getParameter("name"));
			login.setTele(request.getParameter("tele"));
			login.setAccount(request.getParameter("account"));
			login.setPassword(request.getParameter("password"));

			d.save(login);
			
		}
			
		else if(status.equals("queryname")){//Ӧ���ǵ��˺��ظ������,�����������յ�����,�û�����֪������
		
			System.out.println("------queryname-----");
			String nameOraccount=request.getParameter("nameOraccount").toString();
			//request.getAttribute("username")�ǻ�ȡ���������ֵ����������������Ч,��tomcat
			//request.getParameter("username") �ǻ�ȡ��һ��ҳ�洫�뱾ҳ���ֵ,�õ�����GET/POST�ͱ����ݹ������ַ���
			request.getSession().setAttribute("nameOraccount",nameOraccount);
			ArrayList<Login> arrayList=d.query(nameOraccount,"name");
			request.setAttribute("Logins", arrayList);//��ser�����ݴ�����ͼҳ��(jsp)
			RequestDispatcher dispatcher= request.getRequestDispatcher("/query.jsp");
			/*�ض����ת������ʼ�ڷ������ˣ����ύ���������Ǵ����ύ���ύ���ģ������ɿͻ��˷���form�������ض����ת��
			ӲҪ˵���ƵĻ�������˵���ض����һ�����裬����������������ض�����Դ�ⲽ��
			request.getRequestDispatcher()������ת����ǰ��ҳ�湲��һ��request
			ser-->jsp ��ת,����ת���ڲ���ת������ת���������ҳ��,���ض�����������,��ַû�б仯*/
			dispatcher.forward(request, response);//ת��
			/*����Ҫ��תҳ�浫������Ҫ�õ�ǰһ��ҳ���ĳЩ��Ϣ��ʱ��������������
			����Ҫ��תҳ�沢�Ҳ���Ҫ�õ�ǰһ��ҳ�����Ϣʱ�����ѡ����redirect���ض���*/
		}
		
		else if(status.equals("queryaccount")){
			
			System.out.println("------queryaccount-----");
			String nameOraccount=request.getParameter("nameOraccount").toString();
			request.getSession().setAttribute("nameOraccount",nameOraccount);
			ArrayList<Login> arrayList=d.query(nameOraccount,"account");
			request.setAttribute("Logins", arrayList);
			RequestDispatcher dispatcher= request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
		}
		//System.out.println(request.getParameter("name"));
		//System.out.println(request.getParameter("tele"));
		//System.out.println(request.getParameter("account"));
		//System.out.println(request.getParameter("password"));
		
		else if(status.equals("delete")){
			
			System.out.println("------delete-----");
			
			d.delete(request.getParameter("account"));

			ArrayList<Login> arrayList=d.query(request.getSession().getAttribute("nameOraccount").toString(),"account");
			request.setAttribute("Logins", arrayList);
			RequestDispatcher dispatcher= request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);//�������������ɾ���Ժ�ǰһ��query��������
		}
		
		else if(status.equals("update")){
			
			System.out.println("------update-----");
			d.update(request.getParameter("account"),request.getParameter("name"),request.getParameter("tele"),request.getParameter("password"));
		
		}
	}

}