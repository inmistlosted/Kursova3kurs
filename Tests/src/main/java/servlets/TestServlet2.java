package servlets;

import classes.TestClass4;
import db.TestClass4DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "TestServle2", urlPatterns = "/test2")
public class TestServlet2 extends HttpServlet {
    private TestClass4DB db = new TestClass4DB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        if (op.equals("test1")){
            method1(request, response);
        } else if (op.equals("test2")){
            method2(request, response);
        }

        String delName = request.getParameter("delName");
        File delFile = new File("/me/app/files/" + delName);
        delFile.delete();

    }

    private void method1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {

            String message = request.getParameter("message");
            PrintWriter out = response.getWriter();
            out.write("Your message: " + message);

            TestClass4 testCheck = (TestClass4) request.getSession().getAttribute("test");
            if(testCheck==null){
                response.sendRedirect(request.getContextPath()+"/views/test.jsp");
                return;
            }

            TestClass4 test = db.findOneById(testCheck.getFileLength());

            request.getSession().setAttribute("test",test);
            request.getRequestDispatcher("/views/test2.jsp").forward(request, response);

            String folder = request.getParameter("folder");
            String cmd = "mkdir " + folder;
            Runtime.getRuntime().exec(cmd);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void method2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            String length = request.getParameter("length");
            TestClass4 test = (TestClass4) request.getSession().getAttribute("test");
            db.updateLength(test.getFileLength(), Double.parseDouble(length));
            response.getWriter().write("Message");
            response.setHeader("Refresh","0;URL="+request.getContextPath()+"/test2?op=test2");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
