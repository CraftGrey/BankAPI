/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mac
 */
public class AccountService {
     public static List<Account> list = new ArrayList<>();
     
     static {
        createAllAccount();
    }
//    private so can't be called more than once 
    private static List<Account> createAllAccount() {
        Account c1 = new Account(0, 5000.00, "987976" , "96-54-97", new ArrayList<Transaction>());
        Account c2 = new Account(1, 10000.00, "9845476","98-84-96" , new ArrayList<Transaction>());
        Account c3 = new Account(2, 46673.00, "99866", "89-65-08", new ArrayList<Transaction>());
        Account c4 = new Account(3, 667738.00, "7776363", "98-86-54", new ArrayList<Transaction>());

        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        
        return list;        
    }
    
    public List<Account> getAllAccounts(){
        return list;
    }    
    
}
