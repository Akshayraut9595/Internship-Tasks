import java.util.*;

public class SetDemo {
    public static Set<Book> treeSetDemo(Comparator<Book> comparator) {
        Set<Book> books;
        if (comparator == null) {
            books = new TreeSet<>();
        } else {
            books = new TreeSet<>(comparator);
        }

        Book book1 = new Book("Clean Architecture", "Robert C. Martin", 2017);
        Book book2 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        Book book3 = new Book("The Alchemist", "Paulo Coelho", 1988);
        Book book4 = new Book("Atomic Habits", "James Clear", 2018);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        return books;
    }

    public static void main(String[] args) {
        System.out.println("Ordering by Title:");
        for (Book book : treeSetDemo(null)) {
            System.out.println(book);
        }

        System.out.println("\nSorted by Ascending Publication Year:");
        for (Book book : treeSetDemo(new PubDateAscComparator())) {
            System.out.println(book);
        }

        System.out.println("\nSorted by Descending Publication Year:");
        for (Book book : treeSetDemo(new PubDateDescComparator())) {
            System.out.println(book);
        }
    }
}