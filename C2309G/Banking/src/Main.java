import Entity.Author;
import Entity.Book;
import Entity.Gender;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
public class Main {
    public static void main(String[] args) {
        //private static int currentId = 0;
//        Customer customer = new Customer();
//        Customer customer1 = new Customer(1, "MrBean");
//        Change name
//        customer1.setName("Bill Gate");
//        customer1.name = "Bean";
//
//        System.out.println("Id: " + customer1.getId()
//                + "\nName: " + customer1.getName());
//        System.out.println(customer1);
// Doc data tu ban phim va su dung Construstor hoac setter de tao Customer (su dung scanner)
//        Scanner valo = new Scanner(System.in);
//
//
//        System.out.println("Enter Customer Name: ");
//
//
//        String name = valo.nextLine();
//        currentId++;
//        Customer customer = new Customer(currentId, name);
//        System.out.println("ID:" + customer.getId()  );
//        System.out.println("Username is: " + name);

//          List<Customer> = new ArrayList<>();
//          Customer customer = new Customer(1, "Mr Bean", Gender.M,"valorant@email.com","02133671372132173","valorant@email.com");
//          Customers.add(customer);
//
////          for (Customer c: customers){
////              System.out.println(c);
////          }
//
//
//          // Stream API
//        customers.stream()
//                .sorted(Comparator.comparing((Customer::getName).reversed()).forEach(System.out::println);
        //}


            Author author1 = new Author("Hoang Duy Hieu", Gender.M, "hoangduyhiu@gmail.com");
            Author author2 = new Author("Sheriff neo frontier", Gender.O, "neofrontier@gmail.com");

            List<Book> books = new ArrayList<>();
            books.add(new Book("Arifureta", 150.0, author1));
            books.add(new Book("Your name", 200.0, author2));
            books.add(new Book("Black Myth Wukong", 100.0, author1));

        List<Book> sortedBooks = books.stream()
                .sorted(Comparator.comparing(Book::getName))
                .toList();

        sortedBooks.forEach(book -> System.out.println("Tên sách: " + book.getName() + ", Giá: " + book.getPrice()));

            Optional<Book> maxPriceBook = books.stream().max(Comparator.comparing(Book::getPrice));
            maxPriceBook.ifPresent(book -> System.out.println("Sách giá cao nhất: " + book.getName() + " Giá: " + book.getPrice()));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên tác giả: ");
        String authorNameInput = scanner.nextLine();


        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorNameInput)) {
                booksByAuthor.add(book);
            }
        }


        if (booksByAuthor.isEmpty()) {
            System.out.println("Không tìm thấy sách của tác giả: " + authorNameInput);
        } else {
            System.out.println("Sách của tác giả " + authorNameInput + ":");
            for (Book book : booksByAuthor) {
                System.out.println("Tên sách: " + book.getName() + ", Giá: " + book.getPrice());
            }
        }

        scanner.close();

    }
}