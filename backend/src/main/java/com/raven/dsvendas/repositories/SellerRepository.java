package com.raven.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raven.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{
	
}
