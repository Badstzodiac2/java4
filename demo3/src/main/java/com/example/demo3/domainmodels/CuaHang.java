package com.example.demo3.domainmodels;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "CuaHang")
public class CuaHang {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name = "Ma")
    private String Ma;

    @Column(name = "Ten")
    private String Ten;

    @Column(name = "DiaChi")
    private String DiaChi;

    @Column(name = "ThanhPho")
    private String ThanhPho;

    @Column(name = "QuocGia")
    private String QuocGia;

    @OneToMany(mappedBy = "ch", fetch = FetchType.LAZY)
    private List<NhanVien> listNv;

    public CuaHang() {
    }

    public CuaHang(UUID id, String ma, String ten, String diaChi, String thanhPho, String quocGia) {
        Id = id;
        Ma = ma;
        Ten = ten;
        DiaChi = diaChi;
        ThanhPho = thanhPho;
        QuocGia = quocGia;
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

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getThanhPho() {
        return ThanhPho;
    }

    public void setThanhPho(String thanhPho) {
        ThanhPho = thanhPho;
    }

    public String getQuocGia() {
        return QuocGia;
    }

    public void setQuocGia(String quocGia) {
        QuocGia = quocGia;
    }

    @Override
    public String toString() {
        return "CuaHang{" +
                "Id=" + Id +
                ", Ma='" + Ma + '\'' +
                ", Ten='" + Ten + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", ThanhPho='" + ThanhPho + '\'' +
                ", QuocGia='" + QuocGia + '\'' +
                '}';
    }
}
