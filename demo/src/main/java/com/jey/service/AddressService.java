package com.jey.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jey.bo.Address;

@Service
public class AddressService {

	private List<Address> add = new ArrayList<>();

	public String addAddress(Address address) {

		add.add(address);

		return "success";

	}

	public List<Address> getAllAddress() {

		return add;

	}

	public List<Address> getAddressByName(String name) {


		return add.stream().filter(obj -> obj.getName().startsWith(name)).collect(Collectors.toList());

		
	}

}
