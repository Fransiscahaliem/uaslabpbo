/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uaslabpbo1;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author USER
 */
public class Transaksi {
    public static int id_trans;
    public static int no_antrian;
    public static String nama;
    public static float total_belanja;
    public static float dibayar;
    public static float kembali;
    public static String waktu;
    


    public Transaksi(int id_trans, int no_antrian, String nama, float total_belanja, float dibayar, float kembali, String waktu){
        this.id_trans = id_trans;
        this.no_antrian = no_antrian;
        this.nama = nama;
        this.total_belanja = total_belanja;
        this.dibayar = dibayar;
        this.kembali = kembali;
        this.waktu = waktu;
    }

public static void simpanDatabase() throws SQLException{
        try{
            Connection conn = DBConnector.initDBConnection();
            String sql = "INSERT INTO transaksi(id_trans, no_antrian, nama, total_belanja, dibayar, kembali, waktu) VALUES(?, ?, ?, ?, ?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
           
            stmt.setInt(1,id_trans);
            stmt.setInt(2, no_antrian);
            stmt.setString(3, nama);
            stmt.setFloat(4, total_belanja);
            stmt.setFloat(5, dibayar);
            stmt.setFloat(6,kembali);
            stmt.setString(7, waktu);
            stmt.executeUpdate();
            
        } catch(SQLException e){
            System.out.print(e);
        }
    }

    public static void resetDatabase() throws SQLException{
        try{
            Connection conn = DBConnector.initDBConnection();
            Statement statement = conn.createStatement();
            statement.executeUpdate("TRUNCATE TABLE transaksi");

            // Mengatur ulang nilai ID menjadi 1
            statement.executeUpdate("ALTER TABLE transaksi AUTO_INCREMENT = 1");

            // Memberikan notifikasi berhasil
            JOptionPane.showMessageDialog(null, "Database telah direset. Silakan close window ini, dan jalankan kembali programnya");    
        } catch(SQLException e){
            System.out.print(e);
        }
    }

    public Transaksi() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
