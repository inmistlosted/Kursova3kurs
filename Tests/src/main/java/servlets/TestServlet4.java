package servlets;

import classes.TestClass1;
import classes.TestClass6;
import db.TestClass1DB;
import db.TestClass6DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TestServlet4", urlPatterns = "/test4")
public class TestServlet4 extends HttpServlet {
    private TestClass1DB db1 = new TestClass1DB();
    private TestClass6DB db2 = new TestClass6DB();

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

        String attr = request.getParameter("attr");
        File fileToDelete = new File("/home/proj/" + attr);
        boolean flag = fileToDelete.delete();

    }

    private void method1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            PrintWriter out = response.getWriter();
            out.write("Hello " + name);

            String testIdStr = request.getParameter("testId");
            int testId = Integer.parseInt(testIdStr);
            TestClass1 test = db1.findOne(testId);
            List<TestClass6> tests = db2.findTestClasses2(test.getB());
            if (tests == null){
                request.setAttribute("message", "Error");
                request.getRequestDispatcher("/views/test2.jsp").forward(request, response);
            }else {
                request.setAttribute("tests", tests);
                request.setAttribute("test", test);
                request.getRequestDispatcher("/views/test.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void method2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String test1Id = request.getParameter("test1Id");
            String test5Id = request.getParameter("test5Id");
            String str1 = request.getParameter("str1");
            String str2 = request.getParameter("str2");
            String str3 = request.getParameter("str3");

            TestClass6 test = new TestClass6(Integer.parseInt(str1), Integer.parseInt(test1Id));
            db2.insert(test);

            String program = request.getParameter("program");
            String cmd = "run " + program;
            Runtime.getRuntime().exec(cmd);


            response.getWriter().write("Message");
            response.setHeader("Refresh","2;URL="+request.getContextPath()+"/test4?op=test2");


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
