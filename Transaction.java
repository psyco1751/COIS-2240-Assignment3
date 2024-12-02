import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Transaction {
	 private static Transaction instance;

	    // Private constructor
	    private Transaction() {}
	    public static Transaction getTransaction() {
	        if (instance == null) {
	            instance = new Transaction();
	        }
	        return instance;
	    }
	    public void saveTransaction(String transactionDetails) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Git files\\COIS-2240-Assignment3\\Transaction", true))) {
	            writer.write(transactionDetails);
	            writer.newLine();
	        } catch (IOException e) {
	            System.out.println("Error saving transaction: " + e.getMessage());}
	    }
	    public void displayTransactionHistory() {
	        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Git files\\COIS-2240-Assignment3\\Transaction"))) {
	            String line;
	            System.out.println("Transaction History:");
	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	            }
	        } catch (IOException e) {
	            System.out.println("No transactions found or unable to read file: " + e.getMessage());
	        }
	    }
	        
	        
    // Perform the borrowing of a book
    public static boolean borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.borrowBook();
            member.borrowBook(book); 
            String transactionDetails = getCurrentDateTime() + " - Borrowing: " + member.getName() + " borrowed " + book.getTitle();
            System.out.println(transactionDetails);
            return true;
        } else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    // Perform the returning of a book
    public static void returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            System.out.println(transactionDetails);
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }

    // Get the current date and time in a readable format
    private static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}