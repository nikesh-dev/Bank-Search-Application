package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Main;
import com.example.bean.Bank;
import com.example.service.BankService;

@RestController
public class BankController {

 @Autowired
 private BankService bankService;

 @RequestMapping(value = "/banks", method = RequestMethod.GET, produces = "application/json")
 public ResponseEntity<List<Bank>> banks() {

  HttpHeaders headers = new HttpHeaders();
  List<Bank> banks = bankService.getBanks();
  
  if (banks == null) {
   return new ResponseEntity<List<Bank>>(HttpStatus.NOT_FOUND);
  }
  headers.add("Number Of Records Found", String.valueOf(banks.size()));
  return new ResponseEntity<List<Bank>>(banks, headers, HttpStatus.OK);
 }

 @RequestMapping(value = "/bank/{ifsc}", method = RequestMethod.GET)
 public ResponseEntity<Bank> getBank(@PathVariable("ifsc") String ifsc_code) {
  Bank bank = bankService.getBank(ifsc_code);
  if (bank == null) {
   return new ResponseEntity<Bank>(HttpStatus.NOT_FOUND);
  }
  return new ResponseEntity<Bank>(bank, HttpStatus.OK);
 }
 
 @RequestMapping(value = "/bank/find", method = RequestMethod.GET)
 public ResponseEntity<List<Bank>> findBank(@RequestParam String bank_name, @RequestParam String city   ) {
  List<Bank> banks = bankService.findBanks(bank_name,city);
  if (banks == null) {
   return new ResponseEntity<List<Bank>>(HttpStatus.NOT_FOUND);
  }else if(banks.size()==0) {
   return new ResponseEntity<List<Bank>>(HttpStatus.NOT_FOUND);  
  }
  HttpHeaders headers = new HttpHeaders();
  headers.add("Number Of Records Found", String.valueOf(banks.size()));
  return new ResponseEntity<List<Bank>>(banks, headers,HttpStatus.OK);
 }
}
