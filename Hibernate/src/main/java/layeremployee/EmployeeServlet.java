package layeremployee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.hib.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	PrintWriter out=resp.getWriter();
    	resp.setContentType("text/html");
			String action=req.getServletPath();
			/*
			 * if(action.startsWith("delete")) { action="/deleterecord"; }
			 */
			
			switch(action)
			{
			case "/addrecord":
					addRecord(req, resp);
					break;
			case "/deleterecord":
					deleteRecord(req, resp);
					break;
			case "/showrecord":
				showRecord(req, resp);
					break;
			}
    }
    
    private void showRecord(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    	RequestDispatcher rd=req.getRequestDispatcher("ShowRecord.jsp");
    	EmployeeDao emp=new EmployeeDao();
    	List<Employee>list=emp.getEmployee();
    	req.setAttribute("list", list);
    	rd.forward(req, resp);
    }
    
    private void addRecord(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    	String name=req.getParameter("name");
    	String mobile=req.getParameter("mobile");
    	String add=req.getParameter("address");
    	EmployeeDao.add(name,mobile,add);
    	showRecord(req, resp);
    	
    }
    private void deleteRecord(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    	int sid=Integer.parseInt(req.getParameter("sid"));
    	EmployeeDao.delete(sid);
    	showRecord(req, resp);
    }
}
