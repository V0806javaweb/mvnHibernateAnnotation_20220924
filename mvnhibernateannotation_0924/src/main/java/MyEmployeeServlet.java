

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.MyEmployee;

/**
 * Servlet implementation class MyEmployeeServlet
 */
@WebServlet("/MyEmployeeServlet")
public class MyEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 在tb_employee中加入2筆資料
		SessionFactory factory;
		try {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

        MyEmployee e1 = new MyEmployee();
        e1.setId(1001);
        e1.setFirstName("Yui");
        e1.setLastName("Lee");

        MyEmployee e2 = new MyEmployee();
        e2.setId(1002);
        e2.setFirstName("Ming");
        e2.setLastName("Wang");
        session.persist(e1);
        session.persist(e2);
        t.commit();
        session.close();
		response.getWriter().append("Employee Saved ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
