import Entity.Customer;
import Entity.Invoice;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Domic", 10));
        customers.add(new Customer(2, "Goku", 15));
        customers.add(new Customer(3, "Luffy", 5));

        // Tạo danh sách hóa đơn
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(101, customers.get(0), 800.0));
        invoices.add(new Invoice(102, customers.get(1), 8000.0));
        invoices.add(new Invoice(103, customers.get(2), 450.0));
        invoices.add(new Invoice(104, customers.get(0), 453.0));
        invoices.add(new Invoice(105, customers.get(1), 213.0));
        invoices.add(new Invoice(106, customers.get(2), 565.0));


        System.out.println("Invoices by Customer ID 1:");
        invoices.stream()
                .filter(inv -> inv.getCustomerID() == 1)
                .forEach(System.out::println);


        System.out.println("\nCustomer with highest total amount:");
        Optional<Customer> maxCustomer = customers.stream()
                .max(Comparator.comparingDouble(c -> invoices.stream()
                        .filter(inv -> inv.getCustomerID() == c.getID())
                        .mapToDouble(Invoice::getAmount)
                        .sum()));

        maxCustomer.ifPresent(System.out::println);


        System.out.println("\nCustomer with minimum discount:");
        customers.stream()
                .min(Comparator.comparingInt(Customer::getDiscount))
                .ifPresent(System.out::println);


        System.out.print("Enter the Invoice ID to search: ");
        String invoiceIdInput = scanner.nextLine();

        invoices.stream()
                .filter(inv -> String.valueOf(inv.getID()).contains(invoiceIdInput))
                .forEach(System.out::println);


        System.out.print("\nEnter the Customer name to search: ");
        String customerNameInput = scanner.nextLine();

        customers.stream()
                .filter(c -> c.getName().contains(customerNameInput))
                .forEach(System.out::println);


        scanner.close();
    }
}
