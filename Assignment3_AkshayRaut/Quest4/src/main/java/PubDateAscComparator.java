import java.util.Comparator;

public class PubDateAscComparator implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        if (b1.getYear() != b2.getYear()) {
            return Integer.compare(b1.getYear(), b2.getYear());
        }
        return b1.getTitle().compareTo(b2.getTitle());
    }
}