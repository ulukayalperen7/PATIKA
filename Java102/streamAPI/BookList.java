
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookList {

    public static void main(String[] args) {

        ArrayList<Book> list = new ArrayList<>();

        list.add(new Book("To Kill a Mockingbird", "Harper Lee", 281));
        list.add(new Book("1984", "George Orwell", 328));
        list.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 180));
        list.add(new Book("Moby-Dick", "Herman Melville", 585));
        list.add(new Book("Pride and Prejudice", "Jane Austen", 432));
        list.add(new Book("x", "Harper", 11));
        list.add(new Book("y", "George Orwell", 22));
        list.add(new Book("z", "F. Scott Fitzgerald", 333));
        list.add(new Book("t", "Herman Melville", 444));
        list.add(new Book("w", "Jane Austen", 555));

        Map<String, String> map = new HashMap<>();

        list.stream().forEach(i -> map.put(i.getName(), i.getAuthor()));
        

        List<Book> filtered = list.stream().filter(book -> book.getPageNumber() > 100).collect(Collectors.toList());
        System.out.println("more than 100 pages: ");
        filtered.forEach(i -> System.out.println(i));
    }
}

class Book {

    private String name;
    private String author;
    private int pageNumber;

    public Book(String name, String author, int pageNumber) {
        this.name = name;
        this.author = author;
        this.pageNumber = pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book name : " + name + ", author : " + author + ", page number : " + pageNumber;
    }

}
