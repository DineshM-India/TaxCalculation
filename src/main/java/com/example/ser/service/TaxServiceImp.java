package com.example.ser.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ser.dao.TaxDao;
import com.example.ser.model.Tax;


@Service
public class TaxServiceImp implements TaxService {
	@Autowired
	private TaxDao taxdao;
	
	 public TaxServiceImp(TaxDao taxdao) {
		 super();
		 this.taxdao = taxdao;
	 }
	@Override
	@Transactional
	public Tax saveTax(Tax tax) {
	return taxdao.saveTax(tax);
	}

	@Override
	@Transactional
	public List<Tax> getAllTax() {
		List<Tax> tax = new ArrayList<Tax>();
		taxdao.listTax().forEach(tax::add);
		return tax;
	}

	@Override
	@Transactional
	public Tax getTaxById(int id) {

		return taxdao.getById(id);
	}

	@Override
	@Transactional
	public void deleteTax(int id) {
	 taxdao.deleteById(id);
	}


}