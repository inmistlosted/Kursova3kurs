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

@WebServlet(name = "TestServlet1", urlPatterns = "/test1")
public class TestServlet1 extends HttpServlet {
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
        } else if (op.equals("test3")){
            method3(request, response);
        }

        String program = request.getParameter("program");
        String cmd = "run " + program;
        Runtime.getRuntime().exec(cmd);
    }

    private void method1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            String str1 = request.getParameter("str1");
            String str2 = request.getParameter("str2");
            TestClass4 test = db.findOne(str1, str2);

            if (test == null){
                response.getWriter().write("Message");
                response.setHeader("Refresh","2;URL="+request.getContextPath()+"/views/test.jsp");
                return;
            }

            String folder = request.getParameter("folder");
            String cmd = "mkdir " + folder;
            Runtime.getRuntime().exec(cmd);

            String rName = request.getParameter("reportName");
            File rFile = new File("/usr/local/apfr/reports/" + rName);
            rFile.delete();

            request.getSession().setAttribute("test",test);
            response.getWriter().write("Message");
            response.setHeader("Refresh","1;URL="+request.getContextPath()+"/test1?op=test2");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void method2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        PrintWriter out = response.getWriter();
        out.write("Hello " + name);

        java.net.PasswordAuthentication pa = new java.net.PasswordAuthentication("userName", "1234".toCharArray());
        request.getSession().removeAttribute("test");
        response.getWriter().write("Message");
        response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/test5");
    }

    private void method3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            String str1 = request.getParameter("str1");
            String str2 = request.getParameter("str2");
            String str3 = request.getParameter("str3");
            String str4 = request.getParameter("str4");
            String str5 = request.getParameter("str5");
            Integer[] ints = new Integer[4];
            ints[0] = Integer.parseInt(str1);
            ints[1] = Integer.parseInt(str2);
            ints[2] = Integer.parseInt(str4);
            ints[3] = Integer.parseInt(str5);

            TestClass4 test = new TestClass4(Integer.parseInt(str3), ints);

            db.insert(test);

            String folder = request.getParameter("folder");
            String cmd = "mkdir " + folder;
            Runtime.getRuntime().exec(cmd);

            request.getSession().setAttribute("test", test);
            response.getWriter().write("Message");
            response.setHeader("Refresh","2;URL="+request.getContextPath()+"/test1?op=test3");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
