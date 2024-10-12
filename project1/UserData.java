package project1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserData {
    // Method untuk menyimpan username dan password ke database
public static boolean saveUser(String username, String password, String namaUser, int idLevel) {
    String sql = "INSERT INTO user (username, password, nama_user, id_level) VALUES (?, ?, ?, ?)";
    try (Connection conn = DatabaseConnection.Go();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        System.out.println("Menyusun query...");
        stmt.setString(1, username);
        stmt.setString(2, password); // Pertimbangkan untuk mengenkripsi password
        stmt.setString(3, namaUser);
        stmt.setInt(4, idLevel);

        System.out.println("Menjalankan query...");
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("User berhasil disimpan.");
            return true;
        } else {
            System.out.println("Gagal menyimpan user.");
            return false;
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Tampilkan detail kesalahan
        return false;
    }
}

    // Method untuk memverifikasi login user dari database
    public static boolean verifyLogin(String username, String password) {
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.Go();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);  // Jika password terenkripsi, pastikan metode verifikasinya benar

            return stmt.executeQuery().next();  // Mengembalikan true jika data cocok
        } catch (SQLException e) {
        }
        return false;
    }

    static UserProfile getUserProfile(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

