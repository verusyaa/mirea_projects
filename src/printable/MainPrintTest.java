package printable;

public class MainPrintTest {
    public static void main(String[] args) {

        Printable[] arr = {
                new Book("The Game of Thrones"),
                new Magazine("Forbes"),
                new Book("Harry Potter"),
                new Magazine("Time")
        };

        System.out.println("Только книги:");
        Book.printBooks(arr);

        System.out.println("Только журналы:");
        Magazine.printMagazines(arr);
    }
}

