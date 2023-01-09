/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implements;

import Pojo.Produk;
import Service.ProdukService;
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
public class ProdukImplements implements ProdukService{

    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;

    @Override
    public List<Produk> findAll() {
        List<Produk> listProduk = new ArrayList<>();
        String sql = "SELECT * FROM produk";

        conMan = new ConnectionManager();
        conn = conMan.connect();

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Produk produk = new Produk();
                produk.setId(rs.getString("id"));
                produk.setNamaProduk(rs.getString("nama_produk"));
                produk.setKategori(rs.getString("Kategori"));
                produk.setHarga(rs.getDouble("harga"));
                produk.setQuantity(rs.getInt("quantity"));

                listProduk.add(produk);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukImplements.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        return listProduk;
    }

    @Override
    public Integer create(Produk object) {
        int result = 0;
        String sql = "INSERT INTO produk(id, nama_produk, type, harga, quantity) "
                + "VALUES('" + object.getId()+ "', "
                + "'" + object.getNamaProduk()+ "', "
                + "'" + object.getKategori()+ "', "
                + "" + object.getHarga()+ ")"
                + "" + object.getQuantity()+ ")";

        conMan = new ConnectionManager();
        conn = conMan.connect();

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukImplements.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Integer update(Produk object) {
        int result = 0;
        String sql = "UPDATE produk SET nama_produk='" + object.getNamaProduk() + "',"
                + " type='" + object.getKategori()+ "',"
                + " harga=" + object.getHarga() + ","
                + " quantity=" + object.getQuantity()+ ""
                + " WHERE id='" + object.getId() + "'";

        conMan = new ConnectionManager();
        conn = conMan.connect();

        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukImplements.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;
    }

    
    public Produk findById( String id) {
        Produk produk = null;
        String sql = "SELECT * FROM produk WHERE id=" + id + "";

        conMan = new ConnectionManager();
        conn = conMan.connect();

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                produk = new Produk();
                produk.setId(rs.getString("id"));
                produk.setNamaProduk(rs.getString("nama_produk"));
                produk.setKategori(rs.getString("Kategori"));
                produk.setHarga(rs.getDouble("harga"));
                produk.setQuantity(rs.getInt("quantity"));
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukImplements.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return produk;
    }

    
    public Integer delete(String id) {
        int result = 0;
        String sql = "DELETE FROM produk WHERE id=" + id + "";

        conMan = new ConnectionManager();
        conn = conMan.connect();

        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukImplements.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
