import Controller.CustomerController;
import Entity.Account;
import Entity.Customer;
import Service.AccountService;
import Service.CustomerService;
import Entity.Gender;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import Entity.Staff;
import Service.StaffService;

public class Main {
    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<Customer>();
        CustomerService cs = new CustomerService(customers);

        CustomerController customerController = new CustomerController(customers,cs);
        customers.add(new Customer(1,"VCB01", "Binh", Gender.M));
        customers.add(new Customer(2,"TCB002","Minh",Gender.F));
        customers.add(new Customer(3, "TCB003", "Lan",Gender.F));

        Customer cus = customerController.getById(1);
        if(cus != null) {
            System.out.println(cus);
        }
        else {
            System.out.println("Not found");
        }

        List<Staff> staffs = new ArrayList<>();
        StaffService ss = new StaffService(staffs);

        staffs.add(new Staff(1, "STF001", "Phuong", LocalDate.of(2003, 10,2)));
        staffs.add(new Staff(2, "STF002", "Thao", LocalDate.of(2002, 10,2)));


        for (Staff staff : staffs) {
            System.out.println(staff);
        }




        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1, "ACC001", 1200000, LocalDateTime.now(), customers.get(0)));
        accounts.add(new Account(2, "ACC002", 150000, LocalDateTime.now(), customers.get(1)));

        AccountService accountService = new AccountService(accounts);


        List<Account> accountsByCode = accountService.getAccountByCustomerCode("VCB01");
        System.out.println("Accounts with Customer Code 'VCB01': " + accountsByCode);


        List<Account> accountsByName = accountService.getAccountByCustomerName("Minh");
        System.out.println("Accounts with Customer Name 'Minh': " + accountsByName);


        List<Account> maleAccounts = accountService.getAccountByCustomer();
        System.out.println("Accounts of Male customers with balance > 1,000,000: " + maleAccounts);


        long femaleCount = accountService.countAccountByCustomer();
        System.out.println("Total Female customers with balance > 100,000: " + femaleCount);


        Account maxBalanceAccount = accountService.getMaxBalance();
        System.out.println("Customer with max balance (Female): " + (maxBalanceAccount != null ? maxBalanceAccount.getCustomer() : "Not found"));
    }
}