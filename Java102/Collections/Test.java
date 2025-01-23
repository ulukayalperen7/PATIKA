package Collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Book implements Comparable<Book> {

    private String name;
    private int pageNumber;
    private String author;
    private String date;

    public Book(String name, int pageNumber, String author, String date) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.author = author;
        this.date = date;
    }

    @Override
    public int compareTo(Book other) {
        return this.name.compareTo(other.name);
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{name='" + name + "', pageNumber=" + pageNumber + 
               ", author='" + author + "', date='" + date + "'}";
    }

}

public class Test {

    public static void main(String[] args) {
       
        Book book1 = new Book("To Kill a Mockingbird", 281, "Harper Lee", "1960");
        Book book2 = new Book("1984", 328, "George Orwell", "1949");
        Book book3 = new Book("Sapiens: A Brief History", 443, "Yuval Noah Harari", "2011");
        Book book4 = new Book("Pride and Prejudice", 432, "Jane Austen", "1813");
        Book book5 = new Book("The Alchemist", 208, "Harper Lee", "1988");

        Set<Book> set = new HashSet<>();
        set.add(book1);
        set.add(book2);
        set.add(book3);
        set.add(book4);
        set.add(book5);

        System.out.println("HashSet (unordered):");
        for (Book book : set) {
            System.out.println(book);
        }

        Set<Book> booksByName = new TreeSet<>();
        booksByName.add(book1);
        booksByName.add(book2);
        booksByName.add(book3);
        booksByName.add(book4);
        booksByName.add(book5);

        System.out.println("\nTreeSet (sorted by name):");
        for (Book book : booksByName) {
            System.out.println(book);
        }

        Set<Book> booksByPageNumber = new TreeSet<>(Comparator.comparingInt(Book::getPageNumber));
        booksByPageNumber.add(book1);
        booksByPageNumber.add(book2);
        booksByPageNumber.add(book3);
        booksByPageNumber.add(book4);
        booksByPageNumber.add(book5);

        System.out.println("\nTreeSet (sorted by page number):");
        for (Book book : booksByPageNumber) {
            System.out.println(book);
        }
    }
}
