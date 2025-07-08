public class demoBook extends Book{

    public demoBook(String ISBN, String title, int yearPublished, double price) {
        super(ISBN, title, yearPublished, price);
    }

    @Override
    double BuyBook(int quantity, String email, String address) throws demoBookBuyingException {
        throw new demoBookBuyingException();
    }
}
