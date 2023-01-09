/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implements;

import Pojo.Pegawai;
import Service.PegawaiService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.ConnectionManager;

/**
 *
 * @author user
 */
public class PegawaiImplement implements PegawaiService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    
    @Override
    public List<Pegawai> findAll() {
        List<Pegawai> listPegawai = new ArrayList<>();
        String sql = "SELECT * FROM pegawai";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Pegawai pegawai = new Pegawai();
                pegawai.setId(rs.getInt("id"));
                pegawai.setNama(rs.getString("nama"));
                pegawai.setUmur(rs.getInt("umur"));
                pegawai.setJenisKelamin(rs.getString("jenis_kelamin"));
                pegawai.setNomorTelepon(rs.getString("nomor_telepon"));
                pegawai.setAlamat(rs.getString("alamat"));
                
                listPegawai.add(pegawai);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiImplement.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listPegawai;
    }

    @Override
    public Integer create(Pegawai object) {
        int result = 0;
        String sql = "INSERT INTO pegawai(id, nama, umur, "
                + "jenis_kelamin, nomor_telepon, alamat) "
                + "VALUES("+object.getId()+", "
                + "'"+object.getNama()+"', "
                + ""+object.getUmur()+", "
                + "'"+object.getJenisKelamin()+"', "
                + "'"+object.getNomorTelepon()+"',"
                + "'"+object.getAlamat()+"');";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiImplement.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Integer update(Pegawai object) {
        int result = 0;
        String sql = "UPDATE pegawai SET nama='"+object.getNama()+"', "
                + "umur="+object.getUmur()+", "
                + "jenis_kelamin='"+object.getJenisKelamin()+"', "
                + "nomor_telepon='"+object.getNomorTelepon()+"', "
                + "alamat='"+object.getAlamat()+"' "
                + "WHERE id="+object.getId()+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiImplement.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Pegawai findById(int id) {
        Pegawai pegawai = null;
        String sql = "SELECT * FROM pegawai WHERE id="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                pegawai = new Pegawai();
                pegawai.setId(rs.getInt("id"));
                pegawai.setNama(rs.getString("nama"));
                pegawai.setUmur(rs.getInt("umur"));
                pegawai.setJenisKelamin(rs.getString("jenis_kelamin"));
                pegawai.setNomorTelepon(rs.getString("nomor_telepon"));
                pegawai.setAlamat(rs.getString("alamat"));
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiImplement.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return pegawai;
    }

    @Override
    public Integer delete(int id) {
        int result = 0;
        String sql = "DELETE FROM pegawai WHERE id="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiImplement.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

    
}
