/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author mac
 */
@Path("/transaction")
public class TransactionResource {
    private TransactionService transactionService = new TransactionService(); 
    private AccountService accountService = new AccountService(); 
    private CustomerService customerService = new CustomerService(); 
    
    @POST
    @Path("/lodge")
    //@Produces(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Response  lodgeTransaction(@Context UriInfo info) {
         List<Account> accounts = accountService.getAllAccounts();
         List<Customer> customers = customerService.getAllCustomers();
        String id = info.getQueryParameters().getFirst("id");
        String accountId = info.getQueryParameters().getFirst("accountId");
        String lodgeAmount = info.getQueryParameters().getFirst("lodgeAmount");
        String description = info.getQueryParameters().getFirst("description");
        
//        find account if no account error
            
          Account accountNew = null;

        for (Account account: accounts) {
            if (account.getAccountId() == Integer.parseInt(accountId)) {
                
                accountNew = account;
            }
        }
        
        if (accountNew == null) {
        
            return Response.status(Response.Status.NOT_FOUND).build(); // Same as 404
        }
      

//        if customer exists

         Customer customerNew = null;

        for (Customer customer: customers) {
            if (customer.getId() == Integer.parseInt(id)) {
                
                customerNew = customer;
            }
        }
        
        if (customerNew == null) {
        
            return Response.status(Response.Status.NOT_FOUND).build(); // Same as 404
        }
      
//        find if customer owns that account
//        Security feature

        Account customerAccount = null;

         for (Account account: customerNew.getAccounts()) {
            if (account.getAccountId() == accountNew.getAccountId()) {
                
                customerAccount = account;
            }
        }
        
        if (customerAccount == null) {
        
            return Response.status(Response.Status.UNAUTHORIZED).build(); // Same as 404
        }
        

//        add lodge amount to current balance 

        double newBalance = accountNew.add(Double.parseDouble(lodgeAmount)); 
        
        

//        create transaction and add to transaction list 

        Transaction newTransaction = new Transaction();
        
//         int transactionId = transactionService.getAllTransactions().size(); 
         
        newTransaction.setPostBalance(newBalance);
        newTransaction.setAmount(Double.parseDouble(lodgeAmount));
        newTransaction.setDate(new Date());
        newTransaction.setDescription(description);
        


        
            return Response.status(Response.Status.CREATED).entity(newTransaction).build();
    }
    
    @POST
    @Path("/withdraw")
    //@Produces(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Response  withdrawTransaction(@Context UriInfo info) {
         List<Account> accounts = accountService.getAllAccounts();
         List<Customer> customers = customerService.getAllCustomers();
        String id = info.getQueryParameters().getFirst("id");
        String accountId = info.getQueryParameters().getFirst("accountId");
        String withdrawAmount = info.getQueryParameters().getFirst("withdrawAmount");
        String description = info.getQueryParameters().getFirst("description");
        
//        find account if no account error
            
          Account accountNew = null;

        for (Account account: accounts) {
            if (account.getAccountId() == Integer.parseInt(accountId)) {
                
                accountNew = account;
            }
        }
        
        if (accountNew == null) {
        
            return Response.status(Response.Status.NOT_FOUND).build(); // Same as 404
        }
      

//        if customer exists

         Customer customerNew = null;

        for (Customer customer: customers) {
            if (customer.getId() == Integer.parseInt(id)) {
                
                customerNew = customer;
            }
        }
        
        if (customerNew == null) {
        
            return Response.status(Response.Status.NOT_FOUND).build(); // Same as 404
        }
      
//        find if customer owns that account
//        Security feature

        Account customerAccount = null;

         for (Account account: customerNew.getAccounts()) {
            if (account.getAccountId() == accountNew.getAccountId()) {
                
                customerAccount = account;
            }
        }
        
        if (customerAccount == null) {
        
            return Response.status(Response.Status.UNAUTHORIZED).build(); // Same as 401
        }
        

//        add lodge amount to current balance 

        double newBalance = accountNew.withdraw(Double.parseDouble(withdrawAmount)); 
        
        

//        create transaction and add to transaction list 

        Transaction newTransaction = new Transaction();
        
//         int transactionId = transactionService.getAllTransactions().size(); 
         
        newTransaction.setPostBalance(newBalance);
        newTransaction.setAmount(Double.parseDouble(withdrawAmount));
        newTransaction.setDate(new Date());
        newTransaction.setDescription(description);
        


        
            return Response.status(Response.Status.CREATED).entity(newTransaction).build();
    }
    
    @POST
    @Path("/transfer")
    //@Produces(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Response  transferTransaction(@Context UriInfo info) {
        List<Account> accounts = accountService.getAllAccounts();
        List<Customer> customers = customerService.getAllCustomers();
        String id = info.getQueryParameters().getFirst("id");
        String transferAmount = info.getQueryParameters().getFirst("transferAmount");
        String accountIdFrom = info.getQueryParameters().getFirst("accountIdFrom");
        String accountIdTo = info.getQueryParameters().getFirst("accountIdTo");
        String description = info.getQueryParameters().getFirst("description");
 
    

    Account accountNew = null;
    Account accountNew2 = null;
    
        
//        find accounts if no account error
            

        for (Account account: accounts) {
            if (account.getAccountId() == Integer.parseInt(accountIdFrom)) {
                
                accountNew = account;
            }
        }
        
        if (accountNew == null) {
        
            return Response.status(Response.Status.NOT_FOUND).build(); // Same as 404
        }
        
          for (Account account: accounts) {
            if (account.getAccountId() == Integer.parseInt(accountIdTo)) {
                
                accountNew2 = account;
            }
        }
        
        if (accountNew2 == null) {
        
            return Response.status(Response.Status.NOT_FOUND).build(); // Same as 404
        }
      

//        if customer exists

         Customer customerNew = null;

        for (Customer customer: customers) {
            if (customer.getId() == Integer.parseInt(id)) {
                
                customerNew = customer;
            }
        }
        
        if (customerNew == null) {
        
            return Response.status(Response.Status.NOT_FOUND).build(); // Same as 404
        }
      
//        find if customer owns that account
//        Security feature

        Account customerAccount = null;

         for (Account account: customerNew.getAccounts()) {
            if (account.getAccountId() == accountNew.getAccountId()) {
                
                customerAccount = account;
            }
        }
        
        if (customerAccount == null) {
        
            return Response.status(Response.Status.UNAUTHORIZED).build(); // Same as 401      
            
    }
        
//        add lodge amount to current balance 

        double newBalance = accountNew.withdraw(Double.parseDouble(transferAmount)); 
        double newBalance1 = accountNew.add(Double.parseDouble(transferAmount)); 
        
        
//        create transactions and add to transaction lists 

        Transaction newTransaction = new Transaction();
        
//         int transactionId = transactionService.getAllTransactions().size(); 

        newTransaction.setPostBalance(newBalance);
        newTransaction.setAmount(Double.parseDouble(transferAmount));
        newTransaction.setDate(new Date());
        newTransaction.setDescription(description);
        
        Transaction newTransaction1 = new Transaction();
        
        newTransaction1.setPostBalance(newBalance1);
        newTransaction1.setAmount(Double.parseDouble(transferAmount));
        newTransaction1.setDate(new Date());
        newTransaction1.setDescription(description);
        
        
    
        return Response.status(Response.Status.CREATED).entity(newTransaction).build();
    }
}
