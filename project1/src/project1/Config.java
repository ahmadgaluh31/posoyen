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
            // URL untuk koneksi ke database MySQL
            String url = "jdbc:mysql://localhost:3306/db_login"; // Ganti "db_login" dengan nama database kamu
            String user = "root"; // Username default XAMPP
            String pass = ""; // Password default XAMPP (kosong)
            
            // Memuat driver MySQL JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Membuat koneksi ke database
            mysqlconfig = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi berhasil!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
            throw e; // Lanjutkan melempar SQLException ke pemanggil
        }
        return mysqlconfig;
    }
}
