package org.mentoring;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @GetMapping("/")
    public String bulkcreate() {
        repository.save(new Customer("Rajesh", "Bhojwani"));

        repository.saveAll(Arrays.asList(new Customer("Salim", "Khan")
                , new Customer("Rajesh", "Parihar")
                , new Customer("Rahul", "Dravid")
                , new Customer("Dharmendra", "Bhojwani")));
        return "Customers are created";
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public List<Customer> findAll() {
        List<Customer> customers = repository.findAll();
        List<Customer> customerUI = new ArrayList<Customer>();

        for (Customer customer : customers) {
            customerUI.add(new Customer(customer.getId(),customer.getFirstName(), customer.getLastName()));
        }

        return customerUI;
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    public JSONObject search(@PathVariable long id) {
        String customer="" ;
        customer = repository.findById(id).get().toString();
        return new JSONObject(customer);
    }

    @RequestMapping(value = "/searchbyfirstname/{firstname}", method = RequestMethod.GET)
    public List<Customer> fetchDataByFirstName(@PathVariable String firstname) {
        List<Customer> customers = repository.findByFirstName(firstname);
        List<Customer> customerUI = new ArrayList<Customer>();
        for (Customer customer : customers) {
            customerUI.add(new Customer(customer.getId(),customer.getFirstName(), customer.getLastName()));
        }
        return customerUI;
    }
}

