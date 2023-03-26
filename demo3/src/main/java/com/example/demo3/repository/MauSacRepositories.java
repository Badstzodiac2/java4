package com.example.demo3.repository;

import com.example.demo3.viewmodel.QLMauSac;

import java.util.ArrayList;

public class MauSacRepositories {

    public ArrayList<QLMauSac> list = new ArrayList<>();

    public ArrayList<QLMauSac> findAll() {
        return list;
    }

    public void insert(QLMauSac ms) {
        list.add(ms);
    }

    public void edit(QLMauSac ms) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMa().equals(ms.getMa())) {
                list.set(i, ms);
            }
        }
    }

    public QLMauSac findByMa(String ma) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMa().equals(ma)) {
                return list.get(i);
            }
        }
        return null;
    }

    public void delete(QLMauSac ms) {
        list.remove(ms);
    }

}
