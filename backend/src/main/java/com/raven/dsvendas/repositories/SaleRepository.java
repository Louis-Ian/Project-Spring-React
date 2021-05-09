package com.raven.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raven.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
}
