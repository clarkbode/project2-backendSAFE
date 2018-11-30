package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Profile;
import com.revature.services.ProfileService;

@RestController
@RequestMapping(path = "profile")
public class ProfileController {
	
	@Autowired
	private ProfileService ps;
	
	@GetMapping("{id}")
	public Profile findById(@PathVariable int id) {
		return ps.findById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Profile save(@RequestBody Profile p) {
		return ps.save(p);
	}
	
}
