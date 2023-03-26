package com.example.demo3.repository;

import com.example.demo3.viewmodel.QLChucVu;

import java.util.ArrayList;

public class ChucVuRepositories {
    private ArrayList<QLChucVu>list = new ArrayList<>();

    public ArrayList<QLChucVu>findAll(){
        return list;
    }
    public void insert (QLChucVu qlChucVu){
        list.add(qlChucVu);
    }
    public void edit (QLChucVu qlChucVu){
        for(int i =0; i<list.size(); i++){
            QLChucVu cv = this.list.get(i);
            if(cv.getMa().equals(qlChucVu.getMa())){
                this.list.set(i, qlChucVu);
            }
        }
    }
    public void delete (QLChucVu cv){
        list.remove(cv);
    }

    public QLChucVu findByMa(String ma){
        for(int i = 0; i<list.size(); i++){
            QLChucVu cv = this.list.get(i);
            if(cv.getMa().equals(ma)){
                return cv;
            }
        }
        return null;
    }
}
