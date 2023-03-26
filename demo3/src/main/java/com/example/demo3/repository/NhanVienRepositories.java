package com.example.demo3.repository;

import com.example.demo3.viewmodel.QLNhanVien;

import java.util.ArrayList;

public class NhanVienRepositories {
    private ArrayList<QLNhanVien> list = new ArrayList<>();

    public ArrayList<QLNhanVien>findAll() {
        return list;
    }
    public void insert (QLNhanVien kh){
        list.add(kh);
    }
    public void edit (QLNhanVien qlkh){
        for (int i = 0; i < this.list.size(); i++) {
            QLNhanVien vm = this.list.get(i);
            if (vm.getMa().equals(qlkh.getMa())) {
                this.list.set(i, qlkh);
            }
        }
    }
    public void delete (QLNhanVien kh){
        list.remove(kh);
    }
    public QLNhanVien findByMa(String ma) {
        {
            for (int i = 0; i < this.list.size(); i++) {
                QLNhanVien vm = this.list.get(i);
                if (vm.getMa().equals(ma)) {
                    return vm;
                }
            }

            return null;
        }
    }
}
