package com.raven.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raven.dsvendas.dto.SaleSuccessDTO;
import com.raven.dsvendas.dto.SaleSumDTO;
import com.raven.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new com.raven.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))"
			+ "FROM  Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.raven.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))"
			+ "FROM  Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successRateGroupedBySeller();
}
