package com.example.demo3.repository;

import com.example.demo3.viewmodel.QLCuaHang;

import java.util.ArrayList;

public class CuaHangRepository {
    private ArrayList<QLCuaHang> list = new ArrayList<>();

    public ArrayList<QLCuaHang>findAll(){
        return list;
    }
    public void insert (QLCuaHang qlCuaHang){
        list.add(qlCuaHang);
    }
    public void edit (QLCuaHang qlCuaHang){
        for(int i =0; i<list.size(); i++){
            QLCuaHang ch = this.list.get(i);
            if(ch.getMa().equals(qlCuaHang.getMa())){
                this.list.set(i, qlCuaHang);
            }
        }
    }
    public void delete (QLCuaHang ch){
        list.remove(ch);
    }

    public QLCuaHang findByMa(String ma){
        for(int i = 0; i<list.size(); i++){
            QLCuaHang ch = this.list.get(i);
            if(ch.getMa().equals(ma)){
                return ch;
            }
        }
        return null;
    }
}
