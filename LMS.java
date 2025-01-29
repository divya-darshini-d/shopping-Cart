import java.util.ArrayList; // ArrayList Import
import java.util.List; // List Import
import java.util.Scanner; // Scanner Import

public class LMS {
    private List<Books> booksList = new ArrayList<>();
    private List<LibraryUser> usersList = new ArrayList<>();
    private List<Roles> rolesList = new ArrayList<>();
    private List<Transaction> transactionsList = new ArrayList<>();
    private List<Library> librariesList = new ArrayList<>();

    public static void main(String[] args) {
        LMS lms = new LMS();
        lms.initializeSampleData();
        lms.run();
    }

    // Initialize sample data
    private void initializeSampleData() {
        // Sample Books
        booksList.add(new Books(1, "Harry Potter", 428, "J.K. Rowling", "Fantasy", 500.0));
        booksList.add(new Books(2, "The Hobbit", 310, "J.R.R. Tolkien", "Fantasy", 300.0));

        // Sample Users
        usersList.add(new LibraryUser(1, "Aisu", "aisu@email.com", "Madurai", 9843413124L, 1));
        usersList.add(new LibraryUser(2, "John Doe", "john@example.com", "Chennai", 9876543210L, 2));

        // Sample Roles
        rolesList.add(new Roles(1, "Buyer", "Who buys books"));
        rolesList.add(new Roles(2, "Seller", "Who sells books"));

        // Sample Libraries
        librariesList.add(new Library(1, "Thalapathy Library", "Chennai", 6381881005L));
    }

    // Main functionality loop
    private void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. View Books");
            System.out.println("2. View Users");
            System.out.println("3. View Roles");
            System.out.println("4. View Libraries");
            System.out.println("5. Add Transaction");
            System.out.println("6. Fetch Book Details by ID");
            System.out.println("7. View Transaction History");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewBooks();
                    break;
                case 2:
                    viewUsers();
                    break;
                case 3:
                    viewRoles();
                    break;
                case 4:
                    viewLibraries();
                    break;
                case 5:
                    addTransaction(scanner);
                    break;
                case 6:
                    fetchBookById(scanner);
                    break;
                case 7:
                    viewTransactionHistory();
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close(); // Close the scanner
    }

    // View all books
    private void viewBooks() {
        System.out.println("\n--- Books List ---");
        for (Books book : booksList) {
            System.out.println(
                    "ID: " + book.getBookId() + ", Name: " + book.getBookName() + ", Author: " + book.getAuthorName());
        }
    }

    // View all users
    private void viewUsers() {
        System.out.println("\n--- Users List ---");
        for (LibraryUser user : usersList) {
            System.out.println(
                    "ID: " + user.getUserId() + ", Name: " + user.getUserName() + ", Email: " + user.getEmail());
        }
    }

    // View all roles
    private void viewRoles() {
        System.out.println("\n--- Roles List ---");
        for (Roles role : rolesList) {
            System.out.println("ID: " + role.getRoleId() + ", Name: " + role.getRoleName() + ", Description: "
                    + role.getRoleDescription());
        }
    }

    // View all libraries
    private void viewLibraries() {
        System.out.println("\n--- Libraries List ---");
        for (Library library : librariesList) {
            System.out.println("ID: " + library.getLibraryId() + ", Name: " + library.getLibraryName() + ", Address: "
                    + library.getLibraryAddress());
        }
    }

    // Add a transaction
    private void addTransaction(Scanner scanner) {
        System.out.println("Enter Transaction ID:");
        int transactionId = scanner.nextInt();
        System.out.println("Enter Book ID for Transaction:");
        int transactionBookId = scanner.nextInt();
        System.out.println("Enter User ID for Transaction:");
        int transactionUserId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Transaction Date (YYYY-MM-DD):");
        String transactionDateTime = scanner.nextLine();
        System.out.println("Enter Transaction Status:");
        String transactionStatus = scanner.nextLine();

        Transaction transactionObj = new Transaction(transactionId, transactionBookId, transactionUserId,
                transactionDateTime, transactionStatus);
        transactionsList.add(transactionObj);
        System.out.println("Transaction added successfully!");
    }

    // Fetch book details by ID
    private void fetchBookById(Scanner scanner) {
        System.out.print("Enter Book ID to fetch details: ");
        int bookId = scanner.nextInt();
        boolean found = false;

        for (Books book : booksList) {
            if (book.getBookId() == bookId) {
                System.out.println("\n--- Book Details ---");
                System.out.println("ID: " + book.getBookId());
                System.out.println("Name: " + book.getBookName());
                System.out.println("Author: " + book.getAuthorName());
                System.out.println("Page Size: " + book.getPageSize());
                System.out.println("Genre: " + book.getGenre());
                System.out.println("Price: " + book.getPrice());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book with ID " + bookId + " not found.");
        }
    }

    // View transaction history
    private void viewTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        if (transactionsList.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        for (Transaction transaction : transactionsList) {
            System.out.println("Transaction ID: " + transaction.getTransactionId() +
                    ", Book ID: " + transaction.getBookId() +
                    ", User ID: " + transaction.getUserId() +
                    ", Date: " + transaction.getTransactionDateTime() +
                    ", Status: " + transaction.getTransactionStatus());
        }
    }

    // Books Entity
    public class Books {
        private int bookId;
        private String bookName;
        private int pageSize;
        private String authorName;
        private String genre;
        private Double price;

        public Books(int bookId,
                String bookName,
                int pageSize,
                String authorName,
                String genre,
                Double price) {
            this.bookId = bookId;
            this.bookName = bookName;
            this.pageSize = pageSize;
            this.authorName = authorName;
            this.genre = genre;
            this.price = price;
        }

        public int getBookId() {
            return bookId;
        }

        public String getBookName() {
            return bookName;
        }

        public int getPageSize() {
            return pageSize;
        }

        public String getAuthorName() {
            return authorName;
        }

        public String getGenre() {
            return genre;
        }

        public Double getPrice() {
            return price;
        }

        public void setBookId(int bookId) {
            this.bookId = bookId;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }

    // LibraryUser Entity
    public class LibraryUser {
        private int userId;
        private String userName;
        private String email;
        private String address;
        private Long phoneNumber;
        private int roleId;

        public LibraryUser(
                int userId,
                String userName,
                String email,
                String address,
                Long phoneNumber,
                int roleId) {
            this.userId = userId;
            this.userName = userName;
            this.email = email;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.roleId = roleId;
        }

        public int getUserId() {
            return userId;
        }

        public String getUserName() {
            return userName;
        }

        public String getEmail() {
            return email;
        }

        public String getAddress() {
            return address;
        }

        public Long getPhoneNumber() {
            return phoneNumber;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setPhoneNumber(Long phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

    }

    // Roles Entity
    public class Roles {
        private int roleId;
        private String roleName;
        private String roleDescription;

        public Roles(int roleId, String roleName, String roleDescription) {
            this.roleId = roleId;
            this.roleName = roleName;
            this.roleDescription = roleDescription;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public String getRoleDescription() {
            return roleDescription;
        }

        public void setRoleDescription(String roleDescription) {
            this.roleDescription = roleDescription;
        }

    }

    // UserRole Entity
    public class UserRole {
        private int userId;
        private int roleId;

        public UserRole(int userId, int roleId) {
            this.userId = userId;
            this.roleId = roleId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }
    }

    // Transaction Entity
    public class Transaction {
        private int transactionId;
        private int bookId;
        private int userId;
        private String transactionDateTime;
        private String transactionStatus;

        public Transaction(int transactionId, int bookId, int userId, String transactionDateTime,
                String transactionStatus) {
            this.transactionId = transactionId;
            this.bookId = bookId;
            this.userId = userId;
            this.transactionDateTime = transactionDateTime;
            this.transactionStatus = transactionStatus;
        }

        public int getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(int transactionId) {
            this.transactionId = transactionId;
        }

        public int getBookId() {
            return bookId;
        }

        public void setBookId(int bookId) {
            this.bookId = bookId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getTransactionDateTime() {
            return transactionDateTime;
        }

        public void setTransactionDateTime(String transactionDateTime) {
            this.transactionDateTime = transactionDateTime;
        }

        public String getTransactionStatus() {
            return transactionStatus;
        }

        public void setTransactionStatus(String transactionStatus) {
            this.transactionStatus = transactionStatus;
        }

    }

    // Library Entity
    public class Library {
        private int libraryId;
        private String libraryName;
        private String libraryAddress;
        private Long phoneNumber;

        public Library(int libraryId, String libraryName, String libraryAddress, Long phoneNumber) {
            this.libraryId = libraryId;
            this.libraryName = libraryName;
            this.libraryAddress = libraryAddress;
            this.phoneNumber = phoneNumber;
        }

        public int getLibraryId() {
            return libraryId;
        }

        public void setLibraryId(int libraryId) {
            this.libraryId = libraryId;
        }

        public String getLibraryName() {
            return libraryName;
        }

        public void setLibraryName(String libraryName) {
            this.libraryName = libraryName;
        }

        public String getLibraryAddress() {
            return libraryAddress;
        }

        public void setLibraryAddress(String libraryAddress) {
            this.libraryAddress = libraryAddress;
        }

        public Long getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(Long phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }

}