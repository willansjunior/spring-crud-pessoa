package com.example.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.service.MaxDifferenceService;

@RestController
@RequestMapping(value = "/api/max-difference")
public class MaxDifferenceController {
	
	private MaxDifferenceService maxDifferenceService;
	
	@Autowired
	public MaxDifferenceController(MaxDifferenceService maxDifferenceService) {
		this.maxDifferenceService = maxDifferenceService;
	}
	
	@RequestMapping(value = "",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll(@RequestParam("values") int a[]) {
		return ResponseEntity.ok(maxDifferenceService.maxDifference(a));
	}

}
