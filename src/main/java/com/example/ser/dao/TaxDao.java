package com.example.ser.dao;

import java.util.List;

import com.example.ser.model.Tax;



public interface TaxDao {
     Tax saveTax(Tax tax);
	List<Tax> listTax();
	 Tax getById(int id);
	 void deleteById(int id);
}