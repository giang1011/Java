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


    public Optional<Account> findAccountById(List<Account> accounts, int id) {
        return accounts.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
    }





    public void applyAdditionalDiscountForFemalesInAugust(List<Invoice> invoices) {
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
