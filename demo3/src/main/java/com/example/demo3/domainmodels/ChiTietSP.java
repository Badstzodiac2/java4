package com.example.demo3.domainmodels;


import com.example.demo3.repository.ChiTietSPRepository;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="ChiTietSP")
public class ChiTietSP {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @ManyToOne()
    @JoinColumn(
            name="IdSP",
            referencedColumnName = "Id",
            nullable = true
    )
    private SanPham sp;

    @ManyToOne()
    @JoinColumn(
            name="IdNsx",
            referencedColumnName = "Id",
            nullable = true
    )
    private NXS nxs;

    @ManyToOne()
    @JoinColumn(
            name="IdMauSac",
            referencedColumnName = "Id",
            nullable = true
    )
    private MauSac ms;

    @ManyToOne()
    @JoinColumn(
            name="IdDongSP",
            referencedColumnName = "Id",
            nullable = true
    )
    private DongSP dsp;

    @Column(name="NamBH")
    private int NamBH;

    @Column(name="MoTa")
    private String MoTa;

    @Column(name = "SoLuongTon")
    private int SoLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal GiaNhap;

    @Column(name = "GiaBan")
    private BigDecimal GiaBan;

    public ChiTietSP() {
    }

    public ChiTietSP(UUID id, SanPham sp, NXS nxs, MauSac ms, DongSP dsp, int namBH, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
        Id = id;
        this.sp = sp;
        this.nxs = nxs;
        this.ms = ms;
        this.dsp = dsp;
        NamBH = namBH;
        MoTa = moTa;
        SoLuongTon = soLuongTon;
        GiaNhap = giaNhap;
        GiaBan = giaBan;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public NXS getNxs() {
        return nxs;
    }

    public void setNxs(NXS nxs) {
        this.nxs = nxs;
    }

    public MauSac getMs() {
        return ms;
    }

    public void setMs(MauSac ms) {
        this.ms = ms;
    }

    public DongSP getDsp() {
        return dsp;
    }

    public void setDsp(DongSP dsp) {
        this.dsp = dsp;
    }

    public int getNamBH() {
        return NamBH;
    }

    public void setNamBH(int namBH) {
        NamBH = namBH;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public int getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        SoLuongTon = soLuongTon;
    }

    public BigDecimal getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        GiaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        GiaBan = giaBan;
    }

    @Override
    public String toString() {
        return "ChiTietSP{" +
                "Id=" + Id +
                ", sp=" + sp +
                ", nxs=" + nxs +
                ", ms=" + ms +
                ", dongSP=" + dsp +
                ", NamBH=" + NamBH +
                ", MoTa='" + MoTa + '\'' +
                ", SoLuongTon='" + SoLuongTon + '\'' +
                ", GiaNhap=" + GiaNhap +
                ", GiaBan=" + GiaBan +
                '}';
    }

    public static void main(String[] args) {
        ChiTietSPRepository repo = new ChiTietSPRepository();
        List<ChiTietSP>list = repo.findAll();
        for(ChiTietSP sp : list){
            System.out.println(sp.getDsp().getTen());
        }
    }
}
