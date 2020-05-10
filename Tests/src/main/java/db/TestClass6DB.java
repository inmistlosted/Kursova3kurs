package db;

import classes.TestClass6;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestClass6DB {
    public List<TestClass6> findTestClasses2(int testId) throws SQLException, ClassNotFoundException, IOException {
        Connection conn = DBConnection.initDB();
        Statement statement = conn.createStatement();

        String sql = "select * from tests6 where test6_id=" + testId;

        ResultSet rs = statement.executeQuery(sql);

        List<TestClass6> tests = new ArrayList<TestClass6>();
        while (rs.next()){
            int id = rs.getInt("id");
            int param = rs.getInt("param");
            tests.add(new TestClass6(id, param));
        }

        return tests;
    }

    public void insert(TestClass6 test) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement statement = null;

        try{
            conn = DBConnection.initDB();
            statement = conn.createStatement();

            String sql = "insert into test6 (index, position, num, bufferint, bufflength) values(" + test.getindex() + ", " +
                    test.getPosition() + ", " + test.getnum() + ", " + test.getbufferInt() + ", " + test.getBufferLength() + ")";

            statement.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            statement.close();
            conn.close();
        }
    }
}
