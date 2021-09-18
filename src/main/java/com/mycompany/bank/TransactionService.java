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
public class TransactionService {
     
    public static List<Transaction> list = new ArrayList<>();
    
    static {
        createAllTransaction();
    }
    
    private static List<Transaction> createAllTransaction() {
        Transaction c1 = new Transaction(5000.00, -100.00,new Date(), "For groceries");
        Transaction c2 = new Transaction(10000.00, 399, new Date(), "For groceries");
        Transaction c3 = new Transaction(46673.00, 7768, new Date(), "For groceries");
        Transaction c4 = new Transaction(667738.00, 8896, new Date(), "For groceries");

        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        
        return list;        
    }
    
    public List<Transaction> getAllTransactions(){
        return list;
    }    
    
}

    

