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
public class ProdukImplements implements ProdukService {

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
                produk.setQuantity(rs.getInt("quantity"));
                produk.setHarga(rs.getDouble("harga"));

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
        String sql = "INSERT INTO produk(id, nama_produk, kategori, quantity, harga) "
                + "VALUES('" + object.getId() + "', "
                + "'" + object.getNamaProduk() + "', "
                + "'" + object.getKategori() + "', "
                + "" + object.getQuantity() + ","
                + "" + object.getHarga() + ");";

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
                + " kategori='" + object.getKategori() + "',"
                + " quantity=" + object.getQuantity() + ","
                + " harga=" + object.getHarga() + ""
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

    @Override
    public Produk findById(String id) {
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
    
    @Override
    public Integer countTransaksi() {
        conMan = new ConnectionManager();
        conn = conMan.connect();
        int row = 0;
        String query = "SELECT id FROM produk GROUP BY id";
        try {
            row++;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return row;
    }

    @Override
    public Integer updateQty(int qty, String id) {
        int result = 0;
       
        String sql = "UPDATE produk SET quantity=" +qty
                + " WHERE id=" + id + "";

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
    
    @Override
    public Integer findQty(String id) {
        Produk produk = null;
        String sql = "SELECT quantity FROM produk WHERE id=" + id + "";

        conMan = new ConnectionManager();
        conn = conMan.connect();

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                produk = new Produk();
                produk.setQuantity(rs.getInt("quantity"));
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukImplements.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return produk.getQuantity();
    }
}
