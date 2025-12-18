import java.util.Arrays;

// Кастомный класс с собственной реализацией Comparable
class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int year;
    private double price;

    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    // Реализация compareTo для сортировки сначала по автору, затем по году
    @Override
    public int compareTo(Book other) {
        int authorCompare = this.author.compareTo(other.author);
        if (authorCompare != 0) {
            return authorCompare;
        }
        return Integer.compare(this.year, other.year);
    }

    @Override
    public String toString() {
        return String.format("'%s' - %s (%d год), цена: %.2f руб.",
                title, author, year, price);
    }
}

// Дополнительный класс с альтернативной сортировкой
class Product implements Comparable<Product> {
    private String name;
    private String category;
    private int quantity;
    private double rating;

    public Product(String name, String category, int quantity, double rating) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.rating = rating;
    }

    // Сортировка по рейтингу (по убыванию), затем по количеству (по возрастанию)
    @Override
    public int compareTo(Product other) {
        int ratingCompare = Double.compare(other.rating, this.rating);
        if (ratingCompare != 0) {
            return ratingCompare;
        }
        return Integer.compare(this.quantity, other.quantity);
    }

    @Override
    public String toString() {
        return String.format("%s [%s]: %d шт., рейтинг %.1f/5",
                name, category, quantity, rating);
    }
}

public class CustomComparableDemo {

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Пример 1: Сортировка книг ===");
        Book[] books = {
                new Book("Мастер и Маргарита", "Булгаков", 1966, 450.50),
                new Book("Преступление и наказание", "Достоевский", 1866, 380.00),
                new Book("Война и мир", "Толстой", 1869, 1200.00),
                new Book("Идиот", "Достоевский", 1868, 400.00),
                new Book("Анна Каренина", "Толстой", 1877, 850.00)
        };

        System.out.println("\nКниги до сортировки:");
        for (Book b : books) {
            System.out.println(b);
        }

        bubbleSort(books);

        System.out.println("\nКниги после сортировки (по автору, затем по году):");
        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println("\n=== Пример 2: Сортировка товаров ===");
        Product[] products = {
                new Product("Ноутбук", "Электроника", 15, 4.7),
                new Product("Смартфон", "Электроника", 32, 4.5),
                new Product("Наушники", "Электроника", 48, 4.8),
                new Product("Книга", "Канцтовары", 100, 4.3),
                new Product("Наушники", "Электроника", 25, 4.8),
                new Product("Ручка", "Канцтовары", 500, 4.0)
        };

        System.out.println("\nТовары до сортировки:");
        for (Product p : products) {
            System.out.println(p);
        }

        Arrays.sort(products);

        System.out.println("\nТовары после сортировки (по рейтингу ↓, затем по количеству ↑):");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}