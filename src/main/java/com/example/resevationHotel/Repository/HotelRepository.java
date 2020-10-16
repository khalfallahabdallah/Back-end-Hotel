package com.example.resevationHotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.resevationHotel.Model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
