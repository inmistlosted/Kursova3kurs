package servlets;

import classes.TestClass5;
import db.TestClass5DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TestServlet3", urlPatterns = "/test3")
public class TestServlet3 extends HttpServlet {
    private TestClass5DB db = new TestClass5DB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String testId = request.getParameter("testId");
        if (testId != null){
            method2(request, response);
        } else {
            method1(request, response);
        }
    }

    private void method1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            String program = request.getParameter("program");
            String cmd = "run " + program;
            Runtime.getRuntime().exec(cmd);
            List<TestClass5> tests = db.findAll();
            request.setAttribute("tests", tests);
            request.getRequestDispatcher("/views/test.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void method2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            String testIdStr = request.getParameter("testId");
            int testId = Integer.parseInt(testIdStr);
            TestClass5 test = db.findOne(testId);

            String folder = request.getParameter("folder");
            String cmd = "mkdir " + folder;
            Runtime.getRuntime().exec(cmd);

            if (test == null){
                request.setAttribute("message", "Message");
                request.getRequestDispatcher("/views/test2.jsp").forward(request, response);
            }else {
                request.setAttribute("test", test);
                request.getRequestDispatcher("/views/test.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
