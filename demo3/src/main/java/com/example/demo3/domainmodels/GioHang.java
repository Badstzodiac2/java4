package com.example.demo3.domainmodels;


import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "GioHang")
public class GioHang {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name = "IdKH")
    private String IdKH;

    @Column(name = "IdNV")
    private String IdNV;

    @Column(name = "Ma")
    private String Ma;

    @Column(name = "NgayTao")
    private Date NgayTao;

    @Column(name = "NgayThanhToan")
    private Date NgayThanhToan;

    @Column(name = "TenNguoiNhan")
    private String TenNguoiNhan;

    @Column(name = "DiaChi")
    private String DiaChi;

    @Column(name = "Sdt")
    private String Sdt;

    @Column(name = "TinhTrang")
    private boolean TinhTrang;

    public GioHang() {
    }

    public GioHang(UUID id, String idKH, String idNV, String ma, Date ngayTao, Date ngayThanhToan, String tenNguoiNhan, String diaChi, String sdt, boolean tinhTrang) {
        Id = id;
        IdKH = idKH;
        IdNV = idNV;
        Ma = ma;
        NgayTao = ngayTao;
        NgayThanhToan = ngayThanhToan;
        TenNguoiNhan = tenNguoiNhan;
        DiaChi = diaChi;
        Sdt = sdt;
        TinhTrang = tinhTrang;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getIdKH() {
        return IdKH;
    }

    public void setIdKH(String idKH) {
        IdKH = idKH;
    }

    public String getIdNV() {
        return IdNV;
    }

    public void setIdNV(String idNV) {
        IdNV = idNV;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String ma) {
        Ma = ma;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date ngayTao) {
        NgayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        NgayThanhToan = ngayThanhToan;
    }

    public String getTenNguoiNhan() {
        return TenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        TenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public boolean isTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        TinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "GioHang{" +
                "Id='" + Id + '\'' +
                ", IdKH='" + IdKH + '\'' +
                ", IdNV='" + IdNV + '\'' +
                ", Ma='" + Ma + '\'' +
                ", NgayTao=" + NgayTao +
                ", NgayThanhToan=" + NgayThanhToan +
                ", TenNguoiNhan='" + TenNguoiNhan + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", Sdt='" + Sdt + '\'' +
                ", TinhTrang=" + TinhTrang +
                '}';
    }
}
