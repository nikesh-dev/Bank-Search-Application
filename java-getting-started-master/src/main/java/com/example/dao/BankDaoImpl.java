package com.example.dao;

import java.util.List;

import com.example.bean.Bank;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bankDao")
public class BankDaoImpl implements BankDao {

 private JdbcTemplate jdbcTemplate;

 @Autowired
 public void setDataSource(DataSource dataSource) {
  this.jdbcTemplate = new JdbcTemplate(dataSource);
 }

 public List<Bank> getBanks() {
  List<Bank> banks = null ;
  
  try {
   banks = jdbcTemplate.query("SELECT * FROM BANK_BRANCHES",new BeanPropertyRowMapper<Bank>(Bank.class));   
  } catch (DataAccessException e) {
   e.printStackTrace();
  }
  return banks;
 }

 public Bank getBank(String ifsc_code) {
  Bank bank = null;
  try {
   bank = jdbcTemplate.queryForObject("SELECT * FROM BANK_BRANCHES WHERE ifsc = ?",
     new Object[] { ifsc_code }, new BeanPropertyRowMapper<Bank>(Bank.class));
  } catch (DataAccessException e) {
   e.printStackTrace();
  }
  return bank;
 }

 public List<Bank> findBanks(String bank_name, String city) {
	 List<Bank> banks = null ;
	  try {
	   banks = jdbcTemplate.query("SELECT * FROM BANK_BRANCHES WHERE bank_name = ? AND city = ?",
			   new Object[] {bank_name, city},new BeanPropertyRowMapper<Bank>(Bank.class));   
	  } catch (DataAccessException e) {
	   e.printStackTrace();
	  }
	  return banks;
 }
}