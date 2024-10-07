/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    private static Connection mysqlconfig;
    
    public static Connection configDB() throws SQLException {
        try {
            
            String url = "jdbc:mysql://localhost:3306/db_login"; 
            String user = "root"; 
            String pass = ""; 
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            mysqlconfig = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi berhasil!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
            throw e;
        }
        return mysqlconfig;
    }
}
