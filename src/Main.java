import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        Book pestenTid = new Book("Pesten tid", "Stephen King", 1993, "1:a Upplagan", false);
        Book lida = new Book("Lida", "Stephen King", 1991, "2:a Upplagan", true);

        ArrayList<Book> books = new ArrayList<>();
        books.add(pestenTid);
        books.add(lida);


        do {
            System.out.println("""
                                  ::Välkommen till Folkets Bibliotek::
                    1. Lägg till en bok till biblioteket
                    2. Sök efter en bok
                    3. Lista över alla tillängliga böcker
                    4. Lista över alla utlånade böcker
                    5. Låna bok
                    6. Återlämna bok
                    7. Avsluta
                                    """);

            choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {
                case 1:

                    System.out.println("Lägg till bok:");
                    System.out.print("Titel: ");
                    String input = sc.nextLine();
                    System.out.print("Författare: ");
                    String author = sc.nextLine();
                    System.out.print("Utgivningsår: ");
                    int year = sc.nextInt();
                    System.out.print("Upplaga: ");
                    String edition = sc.next();

                    Book newBook = new Book(input, author, year, edition, true);
                    books.add(newBook);

                    System.out.println("Följande bok har lagts till:");
                    Book latestBook = books.get(books.size() - 1);
                    System.out.println("Titel: " + latestBook.getTitle() + ", Författare: " + latestBook.getAuthor());
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Tillängliga böcker: ");
                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).isBookAvailable()) {
                            System.out.println((i + 1) + ". " + books.get(i).getTitle() + " Författare: " + books.get(i).getAuthor());
                        }

                    }
                    break;
                case 4:
                    System.out.println("Utlånade böcker: ");
                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).isBookLoaned()) {
                            System.out.println((i + 1) + ". " + books.get(i).getTitle() + " Författare: " + books.get(i).getAuthor());
                        }

                    }
                    break;

                case 5:
                    int bookChoice;
                    do {
                        System.out.println("Tillgängliga böcker:");
                        for (int i = 0; i < books.size(); i++) {
                            if (books.get(i).isBookAvailable()) {
                                System.out.println((i + 1) + ". " + books.get(i).getTitle() + " Författare: " + books.get(i).getAuthor());
                            }
                        }
                        System.out.print("Välj en bok (1-" + books.size() + "): ");
                        bookChoice = sc.nextInt();

                        if (bookChoice < 1 || bookChoice > books.size()) {
                            System.out.println("Ogiltigt val. Försök igen! 😊");
                        }
                    } while (bookChoice < 1 || bookChoice > books.size());

                    // Här, utanför loopen, kan du utföra låneoperationen
                    Book selectedBook = books.get(bookChoice - 1);
                    if (selectedBook.isBookAvailable()) {
                        selectedBook.setAvailable(false);
                        System.out.println("Du har lånat boken: " + selectedBook.getTitle());
                    } else {
                        System.out.println("Den här boken är inte tillgänglig för utlåning.");
                    }
                    break;
                case 6:

                    do {
                        System.out.println("Utlånade böcker: ");
                        for (int i = 0; i < books.size(); i++) {
                            if (books.get(i).isBookLoaned()) {
                                System.out.println((i + 1) + ". " + books.get(i).getTitle() + " Författare: " + books.get(i).getAuthor());
                            }

                        }
                        System.out.print("Välj en bok (1-" + books.size() + "): ");
                        bookChoice = sc.nextInt();

                        if (bookChoice < 1 || bookChoice > books.size()) {
                            System.out.println("Ogiltigt val. Försök igen! 😊");
                        }
                    } while (bookChoice < 1 || bookChoice > books.size());

                    // Här, utanför loopen, kan du utföra låneoperationen
                    selectedBook = books.get(bookChoice - 1);
                    if (selectedBook.isBookLoaned()) {
                        selectedBook.setAvailable(true);
                        System.out.println("Du har återlämnat boken: " + selectedBook.getTitle());
                    } else {
                        System.out.println("Den här boken är inte tillgänglig för utlåning.");
                    }
                    break;

            }
        } while (choice != 7);
    }
}
