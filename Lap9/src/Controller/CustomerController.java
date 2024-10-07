package Controller;

import Entity.Customer;
import Service.CustomerService;
import java.util.List;

public class CustomerController {

    private List<Customer> customers;
    private CustomerService cs;

    public CustomerController(List<Customer> customers, CustomerService cs) {
        this.customers = customers;
        this.cs = cs;
    }

    public Customer getById(int id) {
        return cs.getById(customers, id);
    }

    public List<Customer> getByName(String keyword) {

        return (List<Customer>) cs.getByName(customers, keyword);
    }
}
