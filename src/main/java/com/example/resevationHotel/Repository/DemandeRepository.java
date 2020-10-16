package com.example.resevationHotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.resevationHotel.Model.Demande;


@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {

}
