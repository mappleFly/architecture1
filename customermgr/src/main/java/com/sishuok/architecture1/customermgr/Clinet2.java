package com.sishuok.architecture1.customermgr;

import java.sql.*;

public class Clinet2 {


    public static Connection getCon(){

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/archl?useSSL=false&serverTimezone=UTC","root","miao1314b");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return con;
    }


    public static void main(String[] args) throws SQLException {
        Connection con = getCon();
        PreparedStatement ps = con.prepareStatement("select * from tbl_customer");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Object uuid = rs.getObject("showName");
            System.out.println(uuid.toString());
        }
        System.out.println(rs.getRow());
    }
}
