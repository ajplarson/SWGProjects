/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.practicesql;

import java.sql.*;

/**
 *
 * @author ajplarson
 */
public class App {

    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/TrackIt", "root", "2a7n1d8r2e8w");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT\n"
                    + "    IFNULL(s.Name, '[None]') StatusName,\n"
                    + "    COUNT(t.TaskId) TaskCount\n"
                    + "FROM Task t\n"
                    + "LEFT OUTER JOIN TaskStatus s ON t.TaskStatusId = s.TaskStatusId\n"
                    + "GROUP BY s.Name\n"
                    + "ORDER BY s.Name;");
            while (rs.next()) {
                System.out.println(rs.getString("StatusName") + " " + rs.getString("TaskCount"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
