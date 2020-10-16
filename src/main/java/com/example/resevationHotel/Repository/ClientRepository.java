package com.example.resevationHotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resevationHotel.Model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
