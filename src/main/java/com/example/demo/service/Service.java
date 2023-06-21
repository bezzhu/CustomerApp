package com.example.demo.service;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Service {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer addCostumer(Customer customer) {
        return customerDAO.save(customer);
    }

    public List<Customer> getCostumers(){
        return customerDAO.findAll();
    }


    public Customer getCostumer(int id){

        Optional<Customer> optionalCustomer = customerDAO.findById(id);

        if(optionalCustomer.isEmpty())
            throw new CustomerNotFoundException("Customer Record is not available ..");
        return optionalCustomer.get();
    }

    public Customer updateCostumer(int id , Customer customer){
        customer.setId(id);
        return customerDAO.save(customer);

    }

    public void deleteCostumer(int id){
        customerDAO.deleteById(id);
    }






}
