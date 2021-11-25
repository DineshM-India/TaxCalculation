package com.example.ser.service;

import java.util.List;

import com.example.ser.model.Tax;

public interface TaxService {

	Tax saveTax(Tax tax);// create and update tax
    static List<Tax> getAllTax() {
		// TODO Auto-generated method stub
		return null;
	}// read all tax
	Tax getTaxById(int id);
	void deleteTax(int id);
    


}
