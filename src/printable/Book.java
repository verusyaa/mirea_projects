package printable;

public class Book implements Printable {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println(name);
    }

    public static void printBooks(Printable[] printable) {
        for (Printable p : printable) {
            if (p instanceof Book) p.print();
        }
    }
}

