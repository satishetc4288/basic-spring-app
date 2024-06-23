package org.example;

import java.sql.*;
import java.util.Arrays;

public class GenericQueryExecutor {
    public static void main(String[] args) throws Exception {
        Arrays.stream(args).forEach(System.out::println);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn =
            DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
        Statement ps = conn.createStatement();
        Arrays.stream(args).forEach( arg -> {
            ResultSet rs = null;
            try {
                rs = ps.executeQuery(arg + ";");
                while(rs.next()){
                    System.out.println(rs.getString(1) + " " +
                            rs.getString(2) + " " +
                            rs.getString(3) );
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
}