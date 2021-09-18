/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mac
 */
@XmlRootElement
public class Account {
    private int accountId;
    private double balance;
    private String accountNum;
    private String sortCode;
    private List<Transaction> transaction;

    public Account(int accountId, double balance, String accountNum, String sortCode, List<Transaction> transaction) {
        this.accountId = accountId;
        this.balance = balance;
        this.accountNum = accountNum;
        this.sortCode = sortCode;
        this.transaction = transaction;
    }

   public Account() {
    }
        
   public double add (double amount) {
      balance = balance + amount;
      return balance;
   }
   
   public double withdraw (double amount) {
      balance = balance - amount;
      return balance;
   }
    
    

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    
    
    
} 
