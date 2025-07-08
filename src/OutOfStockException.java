public class OutOfStockException extends Exception{
    public OutOfStockException(String BookTitle) {
        super("Not enough stock for " + BookTitle);
    }
}
