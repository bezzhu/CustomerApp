package com.example.demo.api;

import com.example.demo.model.Customer;
import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/costumers")
public class resource {
    @Autowired
    private Service service;

    @PostMapping
    public Customer addCostumer(@RequestBody Customer customer) {
        return service.addCostumer(customer);
    }
    @GetMapping
    public List<Customer> getCustomers(){
        return service.getCostumers();
    }
    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable("id") int id){
        return service.getCostumer(id);
    }
    @PutMapping(value = "/{id}")
    public Customer updateCostumer(@PathVariable("id") int id ,@RequestBody Customer customer) {
        return service.updateCostumer(id, customer);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteCostumer(@PathVariable("id") int id){
        service.deleteCostumer(id);
    }
}
