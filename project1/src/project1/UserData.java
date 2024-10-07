/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project1;

import java.util.HashMap;
import java.util.Map;
public class UserData {
    
     private static final Map<String, String> users = new HashMap<>();

    // Method untuk menyimpan username dan password
    public static void saveUser(String username, String password) {
        users.put(username, password);
    }

    // Method untuk verifikasi username dan password
    public static boolean verifyLogin(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
