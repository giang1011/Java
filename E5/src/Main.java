import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import Entity.Customer;
import Entity.Gender;
import Entity.Account;
import Entity.Invoice;
import Controller.Econtroller;

public class Main {
    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Gio", Gender.F, 10));
        customers.add(new Customer(2, "Nah", Gender.M, 5));
        customers.add(new Customer(3, "Kaka", Gender.F, 15));

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1, customers.get(0), 500.0));
        accounts.add(new Account(2, customers.get(1), 300.0));
        accounts.add(new Account(3, customers.get(2), 700.0));

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(1, customers.get(0), 450.0, LocalDateTime.of(2023, 8, 10, 12, 0)));
        invoices.add(new Invoice(2, customers.get(1), 400.0, LocalDateTime.of(2023, 7, 15, 15, 30)));
        invoices.add(new Invoice(3, customers.get(2), 600.0, LocalDateTime.of(2023, 8, 22, 9, 45)));

        Econtroller customerService = new Econtroller();


        List<Customer> sortedCustomers = customerService.sortCustomersByName(customers);
        System.out.println("Sorted Customers by Name: ");
        sortedCustomers.forEach(c -> System.out.println(c.getName()));


        Optional<Account> accountOpt = customerService.findAccountById(accounts, 1);
        accountOpt.ifPresent(account -> System.out.println("Found Account for customer: " + account.getCustomer().getName()));




        customerService.applyAdditionalDiscountForFemalesInAugust(invoices);
    }
}
