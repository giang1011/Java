package Service;

import Entity.Invoice;
import IGneric.GenericService;
import Entity.Account;

import java.util.List;
import java.util.stream.Collectors;

public class InvoiceService implements GenericService<Invoice> {
    private List<Invoice> invoices;

    public InvoiceService(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public void update(Invoice invoice) {

    }

    @Override
    public List<Invoice> sort(List<Invoice> objList) {
        return objList.stream()
                .sorted((i1, i2) -> Double.compare(i1.getAmount(), i2.getAmount()))
                .collect(Collectors.toList());
    }

    @Override
    public Invoice getById(List<Invoice> objList, int id) {
        return objList.stream()
                .filter(invoice -> invoice.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Invoice getByName(List<Invoice> objList, String name) {

        return null;
    }

    public List<Invoice> getInvoicesWithSufficientBalance(List<Invoice> invoices, List<Account> accounts) {
        return invoices.stream()
                .filter(invoice -> {
                    Account account = accounts.stream()
                            .filter(acc -> acc.getCustomer().getId() == invoice.getCustomer().getId())
                            .findFirst()
                            .orElse(null);
                    return account != null && account.getBalance() >= invoice.getAmount() * (1 - invoice.getCustomer().getDiscount() / 100.0);
                })
                .collect(Collectors.toList());
    }

    public List<Invoice> getInvoicesLargerBalance(List<Invoice> invoices, List<Account> accounts) {
        return invoices.stream()
                .filter(invoice -> {
                    Account account = accounts.stream()
                            .filter(acc -> acc.getCustomer().getId() == invoice.getCustomer().getId())
                            .findFirst()
                            .orElse(null);
                    return account != null && account.getBalance() < invoice.getAmount();
                })
                .collect(Collectors.toList());
    }

    public void applyAdditionalDiscountForFemales(List<Invoice> invoices) {
        invoices.forEach(invoice -> {
            String gender = invoice.getCustomer().getGender().toString();
            if (gender.equalsIgnoreCase("F") && invoice.getDatetime().getMonthValue() == 8) {
                double newAmount = invoice.getAmount() * 0.9;
                invoice.setAmount(newAmount);
            }
        });
    }
}
