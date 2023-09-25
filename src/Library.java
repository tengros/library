import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    Scanner sc = new Scanner(System.in);
    ArrayList<Book> books = new ArrayList<>();

   //Case 1 - Lägg till en bok till biblioteket
    public void addBook() {

        System.out.println("Lägg till bok:");
        System.out.print("Titel: ");
        String input = sc.nextLine();
        System.out.print("Författare: ");
        String author = sc.nextLine();
        System.out.print("Utgivningsår: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.print("Upplaga: ");
        String edition = sc.nextLine();

        Book newBook = new Book(input, author, year, edition, true);
        books.add(newBook);

        System.out.println("Följande bok har lagts till:");
        Book latestBook = books.get(books.size() - 1);
        System.out.println("Titel: " + latestBook.getTitle() + ", Författare: " + latestBook.getAuthor());
        System.out.println();

    }

    // Case 2 - Sök efter en bok
    public void searchForBook() {
        Boolean foundBook = false;
        System.out.println("Sök efter bok: ");

        String search = sc.nextLine();
        String lowerCaseSearch = search.toLowerCase();
        for (int i = 0; i < books.size(); i++) {
            String lowerCaseTitle = books.get(i).getTitle().toLowerCase();
            String lowerCaseAuthor = books.get(i).getAuthor().toLowerCase();
            if (lowerCaseTitle.contains(lowerCaseSearch) || lowerCaseAuthor.contains(lowerCaseSearch)) {
                foundBook = true;
                System.out.print((i + 1) + ". " + books.get(i).getTitle() + "  - Författare: " + books.get(i).getAuthor() + " - ");
                if (books.get(i).isAvailable()) {
                    System.out.println(" Tillänglig");
                    System.out.println();
                } else if (books.get(i).isBookLoaned()) {
                    System.out.println(" Inte Tillänglig");
                    System.out.println();
                }
            }
        }
        if (!foundBook) {
            System.out.println("Hittar inte bok som matchar din sökning");
            System.out.println();
        }
    }

    // Case 3 - Lista över alla tillängliga böcker
    public void availableBooks() {
        System.out.println("Tillängliga böcker: ");
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isBookAvailable()) {
                System.out.println((i + 1) + ". " + books.get(i).getTitle() + " Författare: " + books.get(i).getAuthor());
            }

        }
        System.out.println();
    }

    //Case 4 - Lista över alla utlånade böcker
    public void loanedBooks() {
        System.out.println("Utlånade böcker: ");
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isBookLoaned()) {
                System.out.println((i + 1) + ". " + books.get(i).getTitle() + " Författare: " + books.get(i).getAuthor());
            }
            System.out.println();
        }
    }

    //Case 5 - Låna en bok
    public void loan() {
        int bookChoice;
        do {
            System.out.println("Tillgängliga böcker:");
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).isBookAvailable()) {
                    System.out.println((i + 1) + ". " + books.get(i).getTitle() + " Författare: " + books.get(i).getAuthor());
                }
            }
            System.out.println();
            System.out.print("Välj en bok (1-" + books.size() + "): ");
            bookChoice = sc.nextInt();

            if (bookChoice < 1 || bookChoice > books.size()) {
                System.out.println("Ogiltigt val. Försök igen! 😊");
                System.out.println();
            }
        } while (bookChoice < 1 || bookChoice > books.size());

        // Här, utanför loopen, kan du utföra låneoperationen
        Book selectedBook = books.get(bookChoice - 1);
        if (selectedBook.isBookAvailable()) {
            selectedBook.setAvailable(false);
            System.out.println("Du har lånat boken: " + selectedBook.getTitle());
        }

        System.out.println();
    }

    //Case 6 - Återlämna en bok
    public void returnBook() {
        int bookChoice;

        do {
            System.out.println("Utlånade böcker: ");
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).isBookLoaned()) {
                    System.out.println((i + 1) + ". " + books.get(i).getTitle() + " Författare: " + books.get(i).getAuthor());
                }
                System.out.println();

            }
            System.out.print("Välj en bok (1-" + books.size() + "): ");
            bookChoice = sc.nextInt();

            if (bookChoice < 1 || bookChoice > books.size()) {
                System.out.println("Ogiltigt val. Försök igen! 😊");
            }
        } while (bookChoice < 1 || bookChoice > books.size());

        // Här, utanför loopen, kan du utföra låneoperationen
        Book selectedBook = books.get(bookChoice - 1);
        selectedBook = books.get(bookChoice - 1);
        if (selectedBook.isBookLoaned()) {
            selectedBook.setAvailable(true);
            System.out.println("Du har återlämnat boken: " + selectedBook.getTitle());
        } else {
            System.out.println("Felaktigt val!");
        }
        System.out.println();
    }

}

