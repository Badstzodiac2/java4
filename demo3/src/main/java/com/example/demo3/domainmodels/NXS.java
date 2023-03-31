package com.example.demo3.domainmodels;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "NSX")
public class NXS {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name = "Ma")
    private String Ma;

    @Column(name = "Ten")
    private String Ten;

    public NXS() {
    }

    public NXS(UUID id, String ma, String ten) {
        Id = id;
        Ma = ma;
        Ten = ten;
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

    @Override
    public String toString() {
        return "NXS{" +
                "Id='" + Id + '\'' +
                ", Ma='" + Ma + '\'' +
                ", Ten='" + Ten + '\'' +
                '}';
    }
}
