/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implements;

import Pojo.Admin;
import Pojo.Akun;
import Pojo.Pegawai;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.ConnectionManager;
import Service.AkunService;

/**
 *
 * @author DARARI
 */
public class AkunImplements implements AkunService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    
   
    

    @Override
    public Pegawai login(String username, String password) {
       Pegawai pegawai = null;
        Akun akun = null;
        String sql = "SELECT pw.id, pw.nama, pw.status,"
                + "ak.id_akun,ak.username,ak.password, ak.level "
                + "FROM pegawai pw, akun ak "
                + "WHERE pw.id_akun = ak.id_akun "
                + "AND ak.username = '"+username+"' "
                + "AND ak.password = '"+password+"'";
        
         conMan = new ConnectionManager();
         conn = conMan.connect();
       
         try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                pegawai = new Pegawai();
                pegawai.setIdPegawai(rs.getString("id"));
                pegawai.setNamaPegawai(rs.getString("nama"));
                akun = new Akun();
                akun.setId(rs.getInt("id_akun"));
                akun.setUsername(rs.getString("username"));
                akun.setPassword(rs.getString("password"));
                akun.setLevel(rs.getString("level"));
                pegawai.setAkun(akun);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(AkunImplements.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return pegawai;
   
        
     
}

    @Override
    public Integer checkLevel(String id) {
//        "SELECT level FROM akun WHERE id=id";
        return null;
    }
}

