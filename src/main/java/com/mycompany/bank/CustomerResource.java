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
@Path("/customers")
public class CustomerResource {
    
    private CustomerService customerService = new CustomerService(); 
    
    @GET
    @Path("/login")
    //@Produces(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Response login (@Context UriInfo info) {
        List<Customer> customers = customerService.getAllCustomers();
        String email = info.getQueryParameters().getFirst("email");
        String password = info.getQueryParameters().getFirst("password");
        
        //for every customer in customers do this loop
        for (Customer customer: customers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                
                //Returns customer
                return Response.status(Response.Status.OK).entity(customer).build(); // Same as 200 (success)
            }
        }
        return Response.status(Response.Status.FORBIDDEN).build(); // Same as 401 

        
    }
    
//    @GET
//    @Path("/login")
//    //@Produces(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_XML)
//    public Response login (@Context UriInfo info) {
//        String email = info.getQueryParameters().getFirst("email");
//        String password = info.getQueryParameters().getFirst("password");
//        if ("Owen".equals(email) && "123".equals(password)) {   // Doesn't crash for NULL values
//            return Response.status(Response.Status.OK).build(); // Same as 200
//        } else { 
//            return Response.status(Response.Status.FORBIDDEN).build(); // Same as 401
//        }
//    }
    
    @POST
    @Path("/create")
    //@Produces(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Response  createCustomer(@Context UriInfo info) {
        
        String email = info.getQueryParameters().getFirst("email");
        String password = info.getQueryParameters().getFirst("password");
        String confirmPassword = info.getQueryParameters().getFirst("confirmPassword");
        String address = info.getQueryParameters().getFirst("address");
        
        Customer newCustomer = new Customer();
        
        //id is the size of array
        
        int id = customerService.getAllCustomers().size(); 
        
        // sets values for new account
        newCustomer.setId(id);
        newCustomer.setPassword(password);
        newCustomer.setAddress(address);
        newCustomer.setEmail(email);
        newCustomer.setAccounts(new ArrayList<Account>());
        
        //adds to list
        CustomerService.list.add(newCustomer);
        
        return Response.status(Response.Status.CREATED).entity(newCustomer).build(); // Same as 200 (success)
        
    }

    
}
