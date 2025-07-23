package tasks.task11;
import java.util.*;

public class task11 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Java Programming", "John Smith", 2021, 39.99));
        books.add(new Book("Puthon Basics", "Jane Doe", 2020, 29.99));
        books.add(new Book("C++ Essentials", "Michael Johnson", 2019, 49.99));

        for(Book b : books){
            System.out.println(b.toString());
        }
    }
}

class Book {
    String title;
    String author;
    int yearPublished;
    double price;

    public Book (String title, String author, int yearPublished, double price) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    public String toString() {
        return "Title: \"" + this.title + "\"\n" +
                "Author: \"" + this.author + "\"\n" +
                "Year Publish: " + this.yearPublished + "\n" +
                "Price: " + this.price + "\n";
    }
}
