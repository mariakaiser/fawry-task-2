public class paperBook extends Book{
    int stock;

    public paperBook(String ISBN, String title, int yearPublished, double price, int stock) {
        super(ISBN, title, yearPublished, price);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    @Override
    double BuyBook(int quantity,String email,String address) throws OutOfStockException {
        if (this.stock < quantity)
            throw new OutOfStockException(this.getTitle());
        this.stock -= quantity;
        System.out.println("Send Paper book to the ShippingService with address : " + address);
        return this.getPrice()*quantity;
    }
}
