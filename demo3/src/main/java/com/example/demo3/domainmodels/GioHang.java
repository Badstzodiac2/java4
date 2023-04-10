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

    @ManyToOne()
    @JoinColumn(
            name="IdKH",
            referencedColumnName = "Id",
            nullable = true
    )
    private KhachHang kh;

    public GioHang() {
    }

    public GioHang(UUID id, String idNV, String ma, Date ngayTao, Date ngayThanhToan, String tenNguoiNhan, String diaChi, String sdt, boolean tinhTrang, KhachHang kh) {
        Id = id;
        IdNV = idNV;
        Ma = ma;
        NgayTao = ngayTao;
        NgayThanhToan = ngayThanhToan;
        TenNguoiNhan = tenNguoiNhan;
        DiaChi = diaChi;
        Sdt = sdt;
        TinhTrang = tinhTrang;
        this.kh = kh;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
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
                "Id=" + Id +
                ", IdNV='" + IdNV + '\'' +
                ", Ma='" + Ma + '\'' +
                ", NgayTao=" + NgayTao +
                ", NgayThanhToan=" + NgayThanhToan +
                ", TenNguoiNhan='" + TenNguoiNhan + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", Sdt='" + Sdt + '\'' +
                ", TinhTrang=" + TinhTrang +
                ", kh=" + kh +
                '}';
    }
}
