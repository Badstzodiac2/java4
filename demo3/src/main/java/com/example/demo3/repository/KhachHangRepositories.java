package com.example.demo3.repository;

import com.example.demo3.viewmodel.QLKhachHang;

import java.util.ArrayList;

public class KhachHangRepositories {
    private ArrayList<QLKhachHang> list = new ArrayList<>();

    public ArrayList<QLKhachHang>findAll() {
        return list;
    }
    public void insert (QLKhachHang kh){
        list.add(kh);
    }
    public void edit (QLKhachHang qlkh){
        for (int i = 0; i < this.list.size(); i++) {
            QLKhachHang vm = this.list.get(i);
            if (vm.getMa().equals(qlkh.getMa())) {
                this.list.set(i, qlkh);
            }
        }
    }
    public void delete (QLKhachHang kh){
        list.remove(kh);
    }
    public QLKhachHang findByMa(String ma) {
        {
            for (int i = 0; i < this.list.size(); i++) {
                QLKhachHang vm = this.list.get(i);
                if (vm.getMa().equals(ma)) {
                    return vm;
                }
            }

            return null;
        }
    }
}
