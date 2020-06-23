package com.xg.demo.mapper;

import com.xg.demo.model.Hotels;
import com.xg.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotels,Integer> {
}
