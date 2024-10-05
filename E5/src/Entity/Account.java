package Entity;

public class Account {
    private int id;
    private Customer customer;
    private double balance;

    public Account(int id, Customer customer, double balance) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customer=" + customer +
                ", balance=" + balance +
                '}';
    }
}
