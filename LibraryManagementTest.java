import static org.junit.Assert.*;

import org.junit.Test;

public class LibraryManagementTest {

	@Test
	public void test() {
		private Book book1;
	    private Book book2;
	    private Member member1;
	    private Transaction transaction;
	    public void setUp() {
	        // Create instances of classes before each test
	        library = new Library();
	        book1 = new Book(100, "Book 1");
	        book2 = new Book(150, "Book 2");
	        member1 = new Member(1, "John Doe");
	        transaction = Transaction.getTransaction();
	    }

	}

}
