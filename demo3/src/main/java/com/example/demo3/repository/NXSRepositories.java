package com.example.demo3.repository;

import com.example.demo3.viewmodel.QLNXS;

import java.util.ArrayList;

public class NXSRepositories {
    private ArrayList<QLNXS> list = new ArrayList<>();

    public ArrayList<QLNXS>findAll() {
        return list;
    }
    public void insert (QLNXS kh){
        list.add(kh);
    }
    public void edit (QLNXS qlkh){
        for (int i = 0; i < this.list.size(); i++) {
            QLNXS vm = this.list.get(i);
            if (vm.getMa().equals(qlkh.getMa())) {
                this.list.set(i, qlkh);
            }
        }
    }
    public void delete (QLNXS kh){
        list.remove(kh);
    }
    public QLNXS findByMa(String ma) {
        {
            for (int i = 0; i < this.list.size(); i++) {
                QLNXS vm = this.list.get(i);
                if (vm.getMa().equals(ma)) {
                    return vm;
                }
            }

            return null;
        }
    }
}
