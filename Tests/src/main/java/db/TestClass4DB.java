package db;

import classes.TestClass4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestClass4DB {
    public TestClass4 findOneById(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.initDB();
        Statement statement = conn.createStatement();

        String sql = "select * from tests4 where test4_id=" + id;

        ResultSet rs = statement.executeQuery(sql);

        TestClass4 test = null;
        if (rs.next()) {
            String str1 = rs.getString("str1");
            String str2 = rs.getString("str2");
            double dbl = rs.getDouble("dbl");
            String str3 = rs.getString("str3");
            String str4 = rs.getString("str4");
            String str5 = rs.getString("str5");
            Integer[] ints = new Integer[4];
            ints[0] = Integer.parseInt(str2);
            ints[1] = Integer.parseInt(str3);
            ints[2] = Integer.parseInt(str4);
            ints[3] = Integer.parseInt(str5);
            test = new TestClass4(Integer.parseInt(str1), ints);
        }

        return test;
    }

    public TestClass4 findOne(String str1, String str2) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.initDB();
        Statement statement = conn.createStatement();

        String sql = "select test4_id from tests4 where str1='" + str1 + "' and str2='" + str2 + "'";

        ResultSet rs = statement.executeQuery(sql);
        java.net.PasswordAuthentication pa = new java.net.PasswordAuthentication("userName", "1234".toCharArray());

        TestClass4 test = null;
        if (rs.next()) {
            int id = rs.getInt("test4_id");
            test = new TestClass4(id);
        }
        rs.close();
        conn.close();

        return test;
    }

    public void insert(TestClass4 test) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement statement = null;

        try{
            conn = DBConnection.initDB();
            statement = conn.createStatement();

            String sql = "insert into tests4 (length, str1, str2, str3) values('" + test.getFileLength() + "', '" +
                    test.getNums()[0] + "', '" + test.getNums()[1] + "', '" + test.getNums()[2] + "')";

            statement.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            statement.close();
            conn.close();
        }
    }

    public void updateLength(int id, double newLength) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement statement = null;

        try{
            conn = DBConnection.initDB();
            statement = conn.createStatement();

            String sql = "update tests4 set length=" + newLength + " where test4_id=" + id;

            statement.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            statement.close();
            conn.close();
        }
    }
}
