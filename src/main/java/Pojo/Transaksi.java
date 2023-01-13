/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojo;

/**
 *
 * @author Davit
 */
public class Transaksi {
    private int idTransaksi;
    private String idProduk;
    private double harga;
    private double totalTransaksi;
    private String TglTransaksi;
    private int QtyBeli;

    public int getQtyBeli() {
        return QtyBeli;
    }

    public void setQtyBeli(int QtyBeli) {
        this.QtyBeli = QtyBeli;
    }
    
    

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    public double getTotalTransaksi() {
        return totalTransaksi;
    }

    public void setTotalTransaksi(double totalTransaksi) {
        this.totalTransaksi = totalTransaksi;
    }

    public String getTglTransaksi() {
        return TglTransaksi;
    }

    public void setTglTransaksi(String TglTransaksi) {
        this.TglTransaksi = TglTransaksi;
    }  
}
