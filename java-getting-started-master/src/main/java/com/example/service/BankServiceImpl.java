package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Bank;
import com.example.dao.BankDao;

@Service("BankService")
public class BankServiceImpl implements BankService {
	
 @Autowired
 private BankDao BankDao;

public List<Bank> getBanks() {
	// TODO Auto-generated method stub
	List<Bank> list=BankDao.getBanks();
	return list;
}

public Bank getBank(String ifsc_code) {
	// TODO Auto-generated method stub
	 Bank bank = BankDao.getBank(ifsc_code);
	  return bank;
}

public List<Bank> findBanks(String bank_name,String city){
	 List<Bank> banks = BankDao.findBanks(bank_name,city);
	  return banks;
}

}