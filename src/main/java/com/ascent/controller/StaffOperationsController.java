package com.ascent.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ascent.entity.Staff_Details;
import com.ascent.service.StaffService;

@Controller
@CrossOrigin("http://localhost:4200")
public class StaffOperationsController {

	private StaffService service;

	// private StaffProperties props;

	public StaffOperationsController(StaffService service) {
		// this.props = props;
		this.service = service;
	}
	
	}
