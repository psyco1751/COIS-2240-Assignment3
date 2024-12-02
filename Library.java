import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Member> members = new ArrayList<Member>();
    private List<Book> books = new ArrayList<Book>();

    // Add a new member to the library
    public boolean addMember(Member member) {
        // Check if member already exists
        if (findMemberById(member.getId()) != null) {
            System.out.println("Error: Member with ID " + member.getId() + " already exists.");
            return false; // Duplicate ID found
        }
        members.add(member);
        return true; // Successfully added
    }

    // Add a new book to the library, prevent duplicates
    public boolean addBook(Book book) {
        // Check if book already exists
        if (findBookById(book.getId()) != null) {
            System.out.println("Error: Book with ID " + book.getId() + " already exists.");
            return false; // Duplicate ID found
        }
        books.add(book);
        return true; // Successfully added
    }

    // Find a member by ID
    public Member findMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    // Find a book by ID
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Get the list of members
    public List<Member> getMembers() {
        return members;
    }
    
    // Get the list of books
    public List<Book> getBooks() {
        return books;
    }
}
