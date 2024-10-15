package project1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection Go() {
        try {
            MysqlDataSource m = new MysqlDataSource();
            m.setServerName("localhost");
            m.setDatabaseName("db_kasir");
            m.setUser("root");
            m.setPassword("");
            m.setPortNumber(3306);
            m.setServerTimezone("Asia/Jakarta");

            Connection c = m.getConnection();
            System.out.println("Sukses terhubung");
            return c;
        } catch (SQLException e) {
            System.err.println("GAGAL terhubung: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        // Tes koneksi
        Connection connection = Go();
        if (connection != null) {
            System.out.println("Koneksi berhasil dilakukan");
        } else {
            System.out.println("Koneksi gagal dilakukan");
        }
    }
}
