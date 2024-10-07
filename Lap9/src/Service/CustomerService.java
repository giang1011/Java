package Service;

import Entity.Customer;
import IGneric.GenericService;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService implements GenericService<Customer> {
    private List<Customer> customers;

    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public List<Customer> sort(List<Customer> objList) {
        return objList.stream()
                .sorted((c1, c2) -> c1.getName().compareTo(c2.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Customer getById(List<Customer> objList, int id) {
        return objList.stream()
                .filter(customer -> customer.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Customer getByName(List<Customer> objList, String name) {
        return (Customer) objList.stream()
                .filter(customer -> customer.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}
