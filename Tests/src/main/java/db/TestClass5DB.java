package db;

import classes.TestClass5;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestClass5DB {
    public List<TestClass5> findAll() throws SQLException, ClassNotFoundException, IOException {
        Connection conn = DBConnection.initDB();
        Statement statement = conn.createStatement();

        String sql = "select * from tests5";

        ResultSet rs = statement.executeQuery(sql);

        List<TestClass5> tests = new ArrayList<TestClass5>();
        while (rs.next()){
            int id = rs.getInt("test5_id");
            String str1 = rs.getString("str1");
            String str2 = rs.getString("str2");
            String str3 = rs.getString("str3");
            int integer1 = rs.getInt("int1");
            tests.add(new TestClass5(id, Integer.parseInt(str2), integer1));
        }

        rs.close();
        conn.close();

        return tests;
    }

    public TestClass5 findOne(int id) throws SQLException, ClassNotFoundException, IOException {
        Connection conn = DBConnection.initDB();
        Statement statement = conn.createStatement();

        java.net.PasswordAuthentication pa = new java.net.PasswordAuthentication("user", "qwerty".toCharArray());

        String sql = "select * from tests5 where test5_id="+id;

        ResultSet rs = statement.executeQuery(sql);

        TestClass5 test = null;
        if (rs.next()){
            String str1 = rs.getString("str1");
            String str2 = rs.getString("str2");
            String str3 = rs.getString("str3");
            int integer1 = rs.getInt("int1");
            test = new TestClass5(Integer.parseInt(str1), Integer.parseInt(str2), integer1);
        }

        return test;
    }

    public double findInt1(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.initDB();
        Statement statement = conn.createStatement();

        String sql = "select int1 from tests5 where test5_id="+id;

        ResultSet rs = statement.executeQuery(sql);

        int integer1 = 0;
        if (rs.next()){
            integer1 = (int)rs.getDouble("int1");
        }

        rs.close();
        conn.close();

        return integer1;
    }
}
