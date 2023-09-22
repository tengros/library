public class Book {

    //Variabler
    private String title;
    private String author;
    private int year;
    private String edition;
    private boolean isAvailable;


    //Konstruktors

    // Konstruktör för att skapa en ny bok
    public Book(String title, String author, int year, String edition, Boolean isAvailable) {
        this.title = title;         // Sätt titeln på boken
        this.author = author;       // Sätt författaren på boken
        this.year = year;           // Sätt utgivningsåret för boken
        this.edition = edition;     // Sätt upplagan av boken
        this.isAvailable = isAvailable; // Ange om boken är tillgänglig för utlåning
    }

    // Metod för att kontrollera om boken är tillgänglig för utlåning
    public boolean isBookAvailable() {
        return this.isAvailable;
    }

    // Metod för att kontrollera om boken är utlånad
    public boolean isBookLoaned() {
        return !this.isAvailable;
    }

    // Getter-metod för att hämta bokens titel
    public String getTitle() {
        return title;
    }

    // Setter-metod för att ändra bokens titel
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter-metod för att hämta bokens författare
    public String getAuthor() {
        return author;
    }

    // Setter-metod för att ändra bokens författare
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter-metod för att hämta bokens tillgänglighet
    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter-metod för att ändra bokens tillgänglighet
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // En anpassad toString-metod för att skapa en strängrepresentation av boken
    public String toString() {
        return "Titel: " + title + " Författare: " + author + " Utgivningsår: " + year;
    }}