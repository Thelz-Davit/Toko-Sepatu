/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojo;

/**
 *
 * @author DARARI
 */
public class Pegawai {
    private String idPegawai;
    private String namaPegawai;
    private boolean Status;
    private Akun akun;

    public Pegawai() {
    }

    public Pegawai(String idPegawai, String namaPegawai, boolean Status) {
        this.idPegawai = idPegawai;
        this.namaPegawai = namaPegawai;
        this.Status = Status;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getNamaPegawai() {
        return namaPegawai;
    }

    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public Akun getAkun() {
        return akun;
    }

    public void setAkun(Akun akun) {
        this.akun = akun;
    }
    
    
    
}

