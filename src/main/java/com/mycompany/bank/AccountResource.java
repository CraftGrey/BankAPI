/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
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
@Path("/account")
public class AccountResource {
     private AccountService accountService = new AccountService(); 
    
    @POST
    @Path("/create")
    //@Produces(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Response  createAccount(@Context UriInfo info) {
        
        //**Trying to create account with zero balance
        
        String balance = info.getQueryParameters().getFirst("balance");
        String accountNum = info.getQueryParameters().getFirst("acountNum");
        String sortCode = info.getQueryParameters().getFirst("sortCode");
        
        
       Account newAccount = new Account();  //Doesn't support null values for parsing strings
        
        //id is the size of array
        
        int accountId = accountService.getAllAccounts().size(); 
        
        // sets values for new account
        newAccount.setAccountId(accountId);
        newAccount.setAccountNum(accountNum);
        newAccount.setBalance(Double.parseDouble(balance));
        newAccount.setSortCode(sortCode);
        newAccount.setTransaction(new ArrayList<Transaction>());
        
        //adds to list
        AccountService.list.add(newAccount);
        
        return Response.status(Response.Status.CREATED).entity(newAccount).build(); // Same as 200 (success)
        
    }
    
    //**currently getting 405 error for this entry point
    
    @GET
    @Path("/balance")
    //@Produces(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Response balance (@Context UriInfo info) {
        List<Account> accounts = accountService.getAllAccounts();
        String accountId = info.getQueryParameters().getFirst("Account ID");
        
        
        
        //for every account in accounts do this loop
        for (Account account: accounts) {
            if (account.getAccountId() == Integer.parseInt(accountId)) {
                
                //Returns account
                return Response.status(Response.Status.OK).entity(account).build(); // Same as 200 (success)
            }
        }
        return Response.status(Response.Status.FORBIDDEN).build(); // Same as 401 

        
    }
    
}
