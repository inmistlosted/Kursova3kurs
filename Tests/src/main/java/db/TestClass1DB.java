package db;

import classes.TestClass1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestClass1DB {
    public List<TestClass1> findTestClass1(int testId) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.initDB();
        Statement statement = conn.createStatement();

        String sql = "select * from tests1 where test1_id=" + testId;

        ResultSet rs = statement.executeQuery(sql);

        List<TestClass1> testClass1s = new ArrayList<TestClass1>();
        while (rs.next()){
            int id = rs.getInt("test1_id");
            int number = rs.getInt("number");
            boolean bool = rs.getBoolean("bool");
            testClass1s.add(new TestClass1(number));
        }

        rs.close();
        conn.close();

        return testClass1s;
    }

    public TestClass1 findOne(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.initDB();
        Statement statement = conn.createStatement();

        String sql = "select * from tests1 where test1_id="+id;

        ResultSet rs = statement.executeQuery(sql);

        TestClass1 test = null;
        if (rs.next()){
            int test2Id = rs.getInt("test2_id");
            int number = rs.getInt("number");
            boolean bool = rs.getBoolean("bool");
            test = new TestClass1(number);
        }

        return test;
    }

    public int findNumberBool(int id) throws SQLException {
        Connection conn = null;
        Statement statement = null;

        int count = 0;
        try {
            conn = DBConnection.initDB();
            statement = conn.createStatement();

            String sql = "select count(*) as total from tests1 where test1_id="+ id + " and bool=1";

            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()){
                count = rs.getInt("total");
            }

        } catch(Exception e){
            e.printStackTrace();
        }finally{
            statement.close();
            conn.close();
        }
        return count;
    }

    public void updateFreeStatus(int id, boolean bool) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.initDB();
        Statement statement = conn.createStatement();

        String sql = "update tests1 set bool=" + bool + " where test1_id=" + id;

        statement.executeUpdate(sql);
    }
}
