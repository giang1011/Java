package Controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import Entity.Customer;
import Entity.Account;
import Entity.Invoice;
import Entity.Gender;

public class Econtroller {


    public List<Customer> sortCustomersByName(List<Customer> customers) {
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
    }


    public void sortAccountsByCustomerName(List<Account> accounts) {
        List<Account> sortedAccounts = accounts.stream()
                .sorted(Comparator.comparing(account -> account.getCustomer().getName()))
                .collect(Collectors.toList());

        System.out.println("List of accounts sorted by customer name:");
        sortedAccounts.forEach(account ->
                System.out.println("Accounts of: " + account.getCustomer().getName() + " - Remainder: " + account.getBalance()));
    }


    public void sortInvoicesByCustomerName(List<Invoice> invoices) {
        List<Invoice> sortedInvoices = invoices.stream()
                .sorted(Comparator.comparing(invoice -> invoice.getCustomer().getName()))
                .collect(Collectors.toList());

        System.out.println("List of invoices sorted by customer name:");
        sortedInvoices.forEach(invoice ->
                System.out.println("Invoices ID: " + invoice.getId() + " of customers: " + invoice.getCustomer().getName()
                        + " - Amount: " + invoice.getAmount()));
    }


    public Optional<Account> findAccountById(List<Account> accounts, int id) {
        return accounts.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
    }


    public void listCustomersAbleToPay(List<Account> accounts, List<Invoice> invoices, Customer customer) {
        accounts.stream()
                .filter(account -> account.getCustomer().getId() == customer.getId())
                .forEach(account -> {
                    invoices.stream()
                            .filter(invoice -> invoice.getCustomer().getId() == customer.getId())
                            .forEach(invoice -> {
                                double amountAfterDiscount = invoice.getAmount() * (1 - (customer.getDiscount() / 100.0));
                                if (account.getBalance() >= amountAfterDiscount) {
                                    System.out.println("Customers are eligible for payment: " + customer.getName());
                                    System.out.println("Invoice ID: " + invoice.getId() + ", Amount to be paid: " + amountAfterDiscount);
                                }
                            });
                });
    }


    public void listCustomersUnableToPay(List<Customer> customers, List<Invoice> invoices, List<Account> accounts) {
        customers.forEach(customer -> {
            accounts.stream()
                    .filter(account -> account.getCustomer().getId() == customer.getId())
                    .forEach(account -> {
                        invoices.stream()
                                .filter(invoice -> invoice.getCustomer().getId() == customer.getId())
                                .forEach(invoice -> {
                                    double amountAfterDiscount = invoice.getAmount() * (1 - (customer.getDiscount() / 100.0));
                                    if (account.getBalance() < amountAfterDiscount) {
                                        System.out.println("The customer is not eligible for payment: " + customer.getName());
                                        System.out.println("Invoice ID: " + invoice.getId() + ", Amount to be paid: " + amountAfterDiscount);
                                    }
                                });
                    });
        });
    }


    public void applyForFemalesInAugust(List<Invoice> invoices) {
        invoices.stream()
                .filter(invoice -> invoice.getCustomer().getGender() == Gender.F)
                .filter(invoice -> invoice.getDateTime().getMonthValue() == 8)
                .forEach(invoice -> {
                    int newDiscount = invoice.getCustomer().getDiscount() + 10;
                    invoice.getCustomer().setDiscount(newDiscount);
                    System.out.println("Updated discount for " + invoice.getCustomer().getName() + ": " + newDiscount + "%");
                });
    }
}