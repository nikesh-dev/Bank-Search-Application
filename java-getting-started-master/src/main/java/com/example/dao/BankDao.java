package com.example.dao;

import java.util.List;

import com.example.bean.Bank;

public interface BankDao {
 public List<Bank> getBanks();
 public Bank getBank(String ifsc_code);
 public List<Bank> findBanks(String bank_name,String city);
}
