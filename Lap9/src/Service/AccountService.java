package Service;

import Entity.Account;
import IGneric.GenericService;

import java.util.List;
import java.util.stream.Collectors;

public class AccountService implements GenericService<Account> {
    private List<Account> accounts;

    public AccountService(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void update(Account account) {

    }

    @Override
    public List<Account> sort(List<Account> objList) {
        return objList.stream()
                .sorted((a1, a2) -> Double.compare(a1.getBalance(), a2.getBalance()))
                .collect(Collectors.toList());
    }

    @Override
    public Account getById(List<Account> objList, int id) {
        return objList.stream()
                .filter(account -> account.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Account getByName(List<Account> objList, String name) {

        return null;
    }
}
