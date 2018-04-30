package com.example.service;

import java.util.List;

import com.example.bean.Bank;

public interface BankService {
 public List<Bank> getBanks();
 public Bank getBank(String ifsc_code); 
 public List<Bank> findBanks(String bank_name,String city);
}
