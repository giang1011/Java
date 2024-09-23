package Entity;

public class Book {
    private String name;
    private Double price;
    private Author author;

    public Book(String name, Double price, Author author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Double getPrice(){
        return this.price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Author getAuthor(){
        return author;
    }

}
