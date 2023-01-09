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
    private String noTransaksi;
    private String TglTransaksi;
    private double totalTransaksi;
    private String namaPelanggan;

    public Transaksi() {
    }

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public String getTglTransaksi() {
        return TglTransaksi;
    }

    public void setTglTransaksi(String TglTransaksi) {
        this.TglTransaksi = TglTransaksi;
    }

    public double getTotalTransaksi() {
        return totalTransaksi;
    }

    public void setTotalTransaksi(double totalTransaksi) {
        this.totalTransaksi = totalTransaksi;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }
    
    
}
