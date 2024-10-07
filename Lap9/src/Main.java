import Controller.CustomerController;
import Entity.Account;
import Entity.Customer;
import Entity.Gender;
import Entity.Invoice;
import Service.AccountService;
import Service.CustomerService;
import Service.InvoiceService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<Customer>();
        CustomerService cs = new CustomerService(customers);

        CustomerController customerController = new CustomerController(customers,cs);
        customers.add(new Customer(1,"Rever",Gender.M, 10));
        customers.add(new Customer(2,"Kuronami",Gender.F, 15));
        customers.add(new Customer(3, "Prime", Gender.F, 20));
        customers.add(new Customer(4, "Singularity", Gender.M, 25));
        customers.add(new Customer(5, " Gaia's Vengeance", Gender.M, 30));


        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1, customers.get(0), 500.0));
        accounts.add(new Account(2, customers.get(1), 300.0));
        accounts.add(new Account(3, customers.get(2), 700.0));
        accounts.add(new Account(4, customers.get(3), 800.0));
        accounts.add(new Account(5, customers.get(4), 900.0));

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(1, customers.get(0), 450.0, LocalDate.of(2023, 8, 10)));
        invoices.add(new Invoice(2, customers.get(1), 400.0, LocalDate.of(2023, 7, 15)));
        invoices.add(new Invoice(3, customers.get(2), 600.0, LocalDate.of(2023, 8, 22)));
        invoices.add(new Invoice(4, customers.get(3), 321.0, LocalDate.of(2023, 12, 22)));
        invoices.add(new Invoice(5, customers.get(4), 635.0, LocalDate.of(2023, 8, 22)));



        CustomerService customerService = new CustomerService(customers);
        AccountService accountService = new AccountService(accounts);
        InvoiceService invoiceService = new InvoiceService(invoices);


//        Customer updatedCustomer = new Customer(1, "Alice Updated", Gender.O, 15);
//        customerService.update(updatedCustomer);


        Customer foundCustomer = customerService.getById(customers, 1);
        System.out.println("Found Customer: " + foundCustomer.getName());


        List<Customer> sortedCustomers = customerService.sort(customers);
        System.out.println("Sorted Customers: ");
        sortedCustomers.forEach(c -> System.out.println(c.getName()));



        List<Invoice> sufficientInvoices = invoiceService.getInvoicesWithSufficientBalance(invoices, accounts);
//        System.out.println("Invoices with sufficient balance: ");
//        sufficientInvoices.forEach(i -> System.out.println("Invoice ID: " + i.getId() + "    Amount: " + i.getAmount()  ));
        sufficientInvoices.forEach(i -> {

            String customerName = i.getCustomer().getName();


            double customerBalance = 0.0;


            for (Account account : accounts) {
                if (account.getCustomer().getId() == i.getCustomer().getId()) {
                    customerBalance = account.getBalance();
                    break;
                }
            }

            System.out.println("Invoice ID: " + i.getId() +
                    "    Customer: " + customerName +
                    "    Balance: " + customerBalance +
                    "    Amount: " + i.getAmount());

        });





        List<Invoice> smallBalanceInvoices = invoiceService.getInvoicesLargerBalance(invoices, accounts);


        System.out.println("Invoices with larger balance: ");
        smallBalanceInvoices.forEach(invoice -> {
            String customerName = invoice.getCustomer().getName();
            System.out.println("Invoice ID: " + invoice.getId() +
                    "    Customer: " + customerName +
                    "    Amount: " + invoice.getAmount() );
        });


        invoiceService.applyAdditionalDiscountForFemales(invoices);
        System.out.println("Invoices after applying discounts: ");
        invoices.forEach(i -> System.out.println("Invoice ID: " + i.getId() + ", Amount: " + i.getAmount()));
    }
}
