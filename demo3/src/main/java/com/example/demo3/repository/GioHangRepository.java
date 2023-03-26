package com.example.demo3.repository;

import com.example.demo3.viewmodel.QLGioHang;

import java.util.ArrayList;

public class GioHangRepository {
    private ArrayList<QLGioHang> list = new ArrayList<>();

    public ArrayList<QLGioHang>findAll(){
        return list;
    }
    public void insert (QLGioHang qlGioHang){
        list.add(qlGioHang);
    }
    public void edit (QLGioHang qlGioHang){
        for(int i =0; i<list.size(); i++){
            QLGioHang gh = this.list.get(i);
            if(gh.getMa().equals(qlGioHang.getMa())){
                this.list.set(i, qlGioHang);
            }
        }
    }
    public void delete (QLGioHang gh){
        list.remove(gh);
    }

    public QLGioHang findByMa(String ma){
        for(int i = 0; i<list.size(); i++){
            QLGioHang gh = this.list.get(i);
            if(gh.getMa().equals(ma)){
                return gh;
            }
        }
        return null;
    }
}
