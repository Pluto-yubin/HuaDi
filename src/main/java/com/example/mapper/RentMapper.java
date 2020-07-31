package com.example.mapper;

import com.example.entity.Rent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 86177
 */
@Mapper
@Repository
public interface RentMapper {

    List<Rent> getAllRent();

    void addRent(Rent rent);

    void deleteRent(int uid);
}
