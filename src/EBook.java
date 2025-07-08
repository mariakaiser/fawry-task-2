public class EBook extends Book{
    String filetype;

    public EBook(String ISBN, String title, int yearPublished, double price, String filetype) {
        super(ISBN, title, yearPublished, price);
        this.filetype = filetype;
    }

    @Override
    double BuyBook(int quantity, String email, String address) {
        System.out.println("Send EBook to MailService with the email :" + email);
        return this.getPrice();
    }
}
