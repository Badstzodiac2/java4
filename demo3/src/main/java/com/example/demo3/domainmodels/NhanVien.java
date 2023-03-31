package com.example.demo3.domainmodels;


import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name = "Ma")
    private String Ma;

    @Column(name = "Ten")
    private String Ten;

    @Column(name = "TenDem")
    private String TenDem;

    @Column(name = "Ho")
    private String Ho;

    @Column(name = "GioiTinh")
    private String GioiTinh;

    @Column(name = "NgaySinh")
    private Date NgaySinh;

    @Column(name = "DiaChi")
    private String DiaChi;

    @Column(name = "Sdt")
    private String Sdt;

    @Column(name = "MatKhau")
    private String MatKhau;

    @Column(name = "IdCH")
    private String IdCH;

    @Column(name = "IdCV")
    private String IdCV;

    @Column(name = "IdGuiBC")
    private String IdGuiBC;

    @Column(name = "TrangThai")
    private boolean TrangThai;

    public NhanVien() {
    }

    public NhanVien(UUID id, String ma, String ten, String tenDem, String ho, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, String idCH, String idCV, String idGuiBC, boolean trangThai) {
        Id = id;
        Ma = ma;
        Ten = ten;
        TenDem = tenDem;
        Ho = ho;
        GioiTinh = gioiTinh;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        Sdt = sdt;
        MatKhau = matKhau;
        IdCH = idCH;
        IdCV = idCV;
        IdGuiBC = idGuiBC;
        TrangThai = trangThai;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String ma) {
        Ma = ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getTenDem() {
        return TenDem;
    }

    public void setTenDem(String tenDem) {
        TenDem = tenDem;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String ho) {
        Ho = ho;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
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

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getIdCH() {
        return IdCH;
    }

    public void setIdCH(String idCH) {
        IdCH = idCH;
    }

    public String getIdCV() {
        return IdCV;
    }

    public void setIdCV(String idCV) {
        IdCV = idCV;
    }

    public String getIdGuiBC() {
        return IdGuiBC;
    }

    public void setIdGuiBC(String idGuiBC) {
        IdGuiBC = idGuiBC;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean trangThai) {
        TrangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "Id=" + Id +
                ", Ma='" + Ma + '\'' +
                ", Ten='" + Ten + '\'' +
                ", TenDem='" + TenDem + '\'' +
                ", Ho='" + Ho + '\'' +
                ", GioiTinh='" + GioiTinh + '\'' +
                ", NgaySinh=" + NgaySinh +
                ", DiaChi='" + DiaChi + '\'' +
                ", Sdt='" + Sdt + '\'' +
                ", MatKhau='" + MatKhau + '\'' +
                ", IdCH='" + IdCH + '\'' +
                ", IdCV='" + IdCV + '\'' +
                ", IdGuiBC='" + IdGuiBC + '\'' +
                ", TrangThai=" + TrangThai +
                '}';
    }
}
