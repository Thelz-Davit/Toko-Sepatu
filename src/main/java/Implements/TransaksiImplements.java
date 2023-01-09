/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implements;

import Pojo.Transaksi;
import Service.TransaksiService;
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
 * @author DARARI
 */
public class TransaksiImplements implements TransaksiService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;

    @Override
    public List<Transaksi> findAll() {
        List<Transaksi> listTransaksi = new ArrayList<>();
        String sql = "SELECT * FROM transaksi";

        conMan = new ConnectionManager();
        conn = conMan.connect();

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setNoTransaksi(rs.getString("no_transaksi"));
                transaksi.setTglTransaksi(rs.getString("tgl_transaksi"));
                transaksi.setTotalTransaksi(rs.getDouble("total_transaksi"));
                transaksi.setNamaPelanggan(rs.getString("nama_pelanggan"));

                listTransaksi.add(transaksi);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiImplements.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        return listTransaksi;
    }

    @Override
    public Integer create(Transaksi object) {
        int result = 0;
        String sql = "INSERT INTO transaksi(no_transaksi, tgl_transaksi, total_transaksi, nama_pelanggan) "
                + "VALUES('" + object.getNoTransaksi()+ "', "
                + "'" + object.getTglTransaksi()+ "', "
                + "'" + object.getTotalTransaksi()+ "', "
                + "'" + object.getNamaPelanggan()+ "')";

        conMan = new ConnectionManager();
        conn = conMan.connect();

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiImplements.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Integer update(Transaksi object) {
        int result = 0;
        String sql = "UPDATE transaksi SET tgl_transaksi='" + object.getTglTransaksi()+ "',"
                + " total_transaksi='" + object.getTotalTransaksi()+ "',"
                + " nama_pelanggan=" + object.getNamaPelanggan()+ ","
                + " WHERE no_transaksi='" + object.getNoTransaksi()+ "'";

        conMan = new ConnectionManager();
        conn = conMan.connect();

        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiImplements.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Transaksi findById(int id) {
        Transaksi transaksi = null;
        String sql = "SELECT * FROM transaksi WHERE no_transaksi=" + id + "";

        conMan = new ConnectionManager();
        conn = conMan.connect();

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                transaksi = new Transaksi();
                transaksi.setNoTransaksi(rs.getString("no_transaksi"));
                transaksi.setTglTransaksi(rs.getString("tgl_transaksi"));
                transaksi.setTotalTransaksi(rs.getDouble("total_transaksi"));
                transaksi.setNamaPelanggan(rs.getString("nama_pelanggan"));
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiImplements.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return transaksi;
    }

    @Override
    public Integer delete(int id) {
        int result = 0;
        String sql = "DELETE FROM transaksi WHERE no_pelanggan=" + id + "";

        conMan = new ConnectionManager();
        conn = conMan.connect();

        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiImplements.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

}

