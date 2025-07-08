abstract public class Book {
    private String ISBN;
    private String title;
    private int yearPublished;
    private double price;

    public Book(String ISBN, String title, int yearPublished, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    abstract double BuyBook(int quantity, String email, String address) throws OutOfStockException, demoBookBuyingException;

}
