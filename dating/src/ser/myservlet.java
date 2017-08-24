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
public class myservlet extends HttpServlet {//��̬�ֻ࣬�ܴ���һ�ζ���
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myservlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	//������init����,�ֱ��ǲ���������init��init(ServletConfig config)
    	/*��Servlet��ʼ����ʱ�򣬻��Զ�����init(ServletConfig config)��Container���Զ��ռ�һЩ��Servlet��������Ϣ��
    	����һ��ServletConfig��ʵ����ͨ�����ø�ʵ�����ĸ�getXXX��������ServletConfig,ServletContext�ӿ��е��ĸ���������
    	���ǿ��Եõ���Servlet����Щ������Ϣ��
    	�������ȥ����super.init(config);
    	GenericServlet��config���Բ��ܳ�ʼ���������ڵ�����getServletConfig()��ʱ�򣬻��п�ָ��exception
    	init(ServletConfig config)  
       	super.init(config);  ������ิдinit(ServletConfig config)����ʱ,��дsuper.init(config),�����л㱨NullPointerException�쳣*/
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
	
		String status=request.getParameter("status");
		database d=new database();
		//��Ҫ�Ѵ洢���ݵĶ�������Ϊȫ�ֱ���,��Ϊservlet�ǵ�̬��
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
				request.setAttribute("RegisterError", "ע��ʧ��,�û��� ���� �ǳ� ����Ϊ��");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		
		
		else if(status.equals("queryname")){//Ӧ���ǵ��˺��ظ������,�����������յ�����,�û�����֪������
		
			System.out.println("------queryname-----");
			
			String nameOraccount=request.getParameter("nameOraccount").toString();
			

			//request.getAttribute("username")�ǻ�ȡsetattribute��Ļ������������ֵ����������������Ч,��tomcat
			//request.getParameter("username") �ǻ�ȡ��һ��ҳ�洫�뱾ҳ���ֵ,�õ�����GET/POST�ͱ����ݹ������ַ���
			//������Ҫ����ʹ��
			int totalpage=d.countpage(nameOraccount, "name");
			request.getSession().setAttribute("nameOraccount",nameOraccount);
			request.getSession().setAttribute("page",1);
			request.getSession().setAttribute("totalpage",totalpage);
			request.getSession().setAttribute("querystatus", status);//Ϊ�˸�splitpageʶ����ʲô����
			ArrayList<Login> arrayList=d.query(nameOraccount,"name",1);
			request.setAttribute("Logins", arrayList);//��ser�����ݴ�����ͼҳ��(jsp)
			RequestDispatcher dispatcher= request.getRequestDispatcher("/query.jsp");
			/*ת����,servlet��һ�������һ��ҳ�淵�ظ��û����û�->ser->ҳ��->�û���,�ض�����servlet�����û�Ҫȥ����һ��ҳ��
			 (�û�->ser->�û�->ҳ��)
			request.getRequestDispatcher()������ת����ǰ��ҳ�湲��һ��request
			ser-->jsp ��ת,����ת���ڲ���ת������ת���������ҳ��,���ض�����������,��ַû�б仯*/
			dispatcher.forward(request, response);
			/*���ַ������ĸ�ȡ��������.���ݹ���->�ڲ���ת.����Ҫ->�ⲿ��ת(�ض���)
			 ����Ҫ��תҳ�浫������Ҫ�õ�ǰһ��ҳ���ĳЩ��Ϣ��ʱ��������������
			����Ҫ��תҳ�沢�Ҳ���Ҫ�õ�ǰһ��ҳ�����Ϣʱ�����ѡ����redirect���ض���*/
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
			int page=Integer.parseInt(request.getParameter("page"));//�����page��ͨ��url�ķ�ʽ��������,��������setattribute���
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