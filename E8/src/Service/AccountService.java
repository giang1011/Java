package Service;

import Entity.Account;
import Entity.Gender;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AccountService {
    private List<Account> accounts;

    public AccountService(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccountByCustomerCode(String code) {
        return accounts.stream()
                .filter(account -> account.getCustomer().getCode().equalsIgnoreCase(code))
                .collect(Collectors.toList());
    }

    public List<Account> getAccountByCustomerName(String keyword) {
        return accounts.stream()
                .filter(account -> account.getCustomer().getName().equalsIgnoreCase(keyword))
                .collect(Collectors.toList());
    }

    public List<Account> getAccountByCustomer() {
        return accounts.stream()
                .filter(account -> account.getCustomer().getGender() == Gender.M && account.getBalance() > 1_000_000)
                .collect(Collectors.toList());
    }

    public long countAccountByCustomer() {
        return accounts.stream()
                .filter(account -> account.getCustomer().getGender() == Gender.F && account.getBalance() > 100_000)
                .count();
    }

    public Account getMaxBalance() {
        return accounts.stream()
                .filter(a -> a.getCustomer().getGender() == Gender.F)
                .max(Comparator.comparingDouble(Account::getBalance))
                .orElse(null);
    }


}
