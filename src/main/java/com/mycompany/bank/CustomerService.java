/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank;

import com.mycompany.bank.Customer;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class CustomerService {
    
    public static List<Customer> list = new ArrayList<>();
    
//    Ensures customers are only create once
    
    static {
        createAllCustomers();
    }
    
    private static List<Customer> createAllCustomers() {
        
//        ensure when project starts all customers have account
        List<Account> a1 = new ArrayList<>();
        a1.add(AccountService.list.get(0));
        
        List<Account> a2 = new ArrayList<>();
        a2.add(AccountService.list.get(1));
        
        List<Account> a3 = new ArrayList<>();
        a3.add(AccountService.list.get(2));
        
        List<Account> a4 = new ArrayList<>();
        a4.add(AccountService.list.get(3));
        
        Customer c1 = new Customer(0, "Owen@example.com","password", "3 farmroad", a1) ;
        Customer c2 = new Customer(1, "Marc@example.com", "harp4ever", "3 farmroad", a2);
        Customer c3 = new Customer(2, "Alex@example.com", "maynooth", "3 farmroad", a3);
        Customer c4 = new Customer(3, "Donald@example.com", "america", "3 farmroad", a4);

        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        
        return list;        
    }
    
    public List<Customer> getAllCustomers(){
        return list;
    }    
    
}
