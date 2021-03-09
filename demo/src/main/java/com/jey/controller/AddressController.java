package com.jey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jey.bo.Address;
import com.jey.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@GetMapping("/test")
	public String test() {
		
		
		return "jey";
	}
	
	@PostMapping("/save")
	public String addAddress(@RequestBody Address address) {

		System.out.println(address);
		return service.addAddress(address);

	}
	
	@GetMapping("/getall")
	public List<Address> getAllAddress() {

		return service.getAllAddress();

	}
	
	@GetMapping("/getbyname/{name}")
	public List<Address> getAddressByName(@PathVariable String name) {
System.out.println("name:"+name);
		return service.getAddressByName(name);
	}
	
	

}
