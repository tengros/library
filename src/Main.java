import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        Library myLibrary = new Library();

        Book pestenTid = new Book("Pesten tid", "Stephen King", 1993, "1:a Upplagan", false);
        Book lida = new Book("Lida", "Stephen King", 1991, "2:a Upplagan", true);

        myLibrary.books.add(pestenTid);
        myLibrary.books.add(lida);



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
                    myLibrary.addBook();
                    break;

                case 2:
                    myLibrary.searchForBook();
                    break;

                case 3:
                    myLibrary.availableBooks();
                    break;
                case 4:
                    myLibrary.loanedBooks();
                    break;

                case 5:
                    myLibrary.loan();
                    break;
                case 6:
                    myLibrary.returnBook();
                    break;

            }
            if (choice > 7 || choice < 1) {
                System.out.println("Ogiltigt val");
            }
        } while (choice != 7);

    }
}
