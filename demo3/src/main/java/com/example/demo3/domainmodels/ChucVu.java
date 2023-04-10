package com.example.demo3.domainmodels;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

//Eager: @ManyToOne, @OneToOne
//Lazy: @OneToMany, @ManyToMany
@Entity
@Table(name = "ChucVu")
public class ChucVu {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name = "Ma")
    private String Ma;

    @Column(name = "Ten")
    private String Ten;

    @OneToMany(mappedBy = "cv", fetch = FetchType.LAZY)
    private List<NhanVien> listNv;

    public ChucVu() {
    }

    public ChucVu(UUID id, String ma, String ten, List<NhanVien> listNv) {
        Id = id;
        Ma = ma;
        Ten = ten;
        this.listNv = listNv;
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

    public List<NhanVien> getListNv() {
        return listNv;
    }

    public void setListNv(List<NhanVien> listNv) {
        this.listNv = listNv;
    }

    @Override
    public String toString() {
        return "ChucVu{" +
                "Id=" + Id +
                ", Ma='" + Ma + '\'' +
                ", Ten='" + Ten + '\'' +
                ", listNv=" + listNv +
                '}';
    }
}
