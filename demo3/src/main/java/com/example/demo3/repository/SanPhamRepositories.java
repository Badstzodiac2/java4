package com.example.demo3.repository;

import com.example.demo3.viewmodel.QLSanPham;

import java.util.ArrayList;

public class SanPhamRepositories {
    private ArrayList<QLSanPham> list = new ArrayList<>();

    public ArrayList<QLSanPham>findAll() {
        return list;
    }
    public void insert (QLSanPham sp){
        list.add(sp);
    }
    public void edit (QLSanPham qlsp){
        for (int i = 0; i < this.list.size(); i++) {
            QLSanPham vm = this.list.get(i);
            if (vm.getMa().equals(qlsp.getMa())) {
                this.list.set(i, qlsp);
            }
        }
    }
    public void delete (QLSanPham sp){
        list.remove(sp);
    }
    public QLSanPham findByMa(String ma) {
        {
            for (int i = 0; i < this.list.size(); i++) {
                QLSanPham vm = this.list.get(i);
                if (vm.getMa().equals(ma)) {
                    return vm;
                }
            }

            return null;
        }
    }
}
