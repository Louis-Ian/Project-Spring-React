package com.raven.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raven.dsvendas.dto.SaleDTO;
import com.raven.dsvendas.dto.SaleSuccessDTO;
import com.raven.dsvendas.dto.SaleSumDTO;
import com.raven.dsvendas.service.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;

	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable page){
		Page<SaleDTO> list = service.findAll(page);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
		List<SaleSumDTO> list = service.amountGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/success-rate-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successRateGroupedBySeller(){
		List<SaleSuccessDTO> list = service.successRateGroupedBySeller();
		return ResponseEntity.ok(list);
	}
}
