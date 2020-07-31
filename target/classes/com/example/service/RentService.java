package com.example.service;

import com.example.entity.Rent;
import com.example.mapper.RentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {

    @Autowired
    RentMapper mapper;

    public List<Rent> getAllRent() {
        return mapper.getAllRent();
    }

    public void addRent(Rent rent) {
        mapper.addRent(rent);
    }

    public void deleteRent(int uid) {
        mapper.deleteRent(uid);
    }
}
