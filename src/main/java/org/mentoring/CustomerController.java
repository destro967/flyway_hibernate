package org.mentoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @GetMapping("/bulkcreate")
    public String bulkcreate() {
        repository.save(new Customer("Rajesh", "Bhojwani"));

        repository.saveAll(Arrays.asList(new Customer("Salim", "Khan")
                , new Customer("Rajesh", "Parihar")
                , new Customer("Rahul", "Dravid")
                , new Customer("Dharmendra", "Bhojwani")));
        return "Customers are created";
    }

    @GetMapping("/findall")
    public List<Customer> findAll() {
        List<Customer> customers = repository.findAll();
        List<Customer> customerUI = new ArrayList<Customer>();

        for (Customer customer : customers) {
            customerUI.add(new Customer(customer.getFirstName(), customer.getLastName()));
        }

        return customerUI;
    }

    @RequestMapping("/search/{id}")
    public String search(@PathVariable long id) {
        String customer = "";
        customer = repository.findById(id).toString();
        return customer;
    }

    @RequestMapping("/searchbyfirstname/{firstname}")
    public List<Customer> fetchDataByFirstName(@PathVariable String firstname) {
        List<Customer> customers = repository.findByFirstName(firstname);
        List<Customer> customerUI = new ArrayList<Customer>();
        for (Customer customer : customers) {
            customerUI.add(new Customer(customer.getFirstName(), customer.getLastName()));
        }
        return customerUI;
    }
}

