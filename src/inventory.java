import java.util.*;

public class inventory {
    private Map<String, Book> books = new HashMap<>();
    void addToInventory(Book b){
        books.put(b.getISBN(),b);
    }

    boolean BookExistsInInventory(String ISBN){
        return(books.containsKey(ISBN));
    }

    List<Book> removeOutdatedBooks(int years){
        List <Book> outdated = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> it = books.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Book> entry = it.next();
            Book book = entry.getValue();

            if (book.getYearPublished() <= years) {
                outdated.add(book);
                it.remove();
            }
        }


//        for (Book book : this.books.values()) {
//            if(book.getYearPublished()>= years){
//                outdated.add(book);
//                this.books.remove(book.getISBN());
//            }
//        }
        return outdated;
    }

    double buyBookInventory(String ISBN,int quantity,String email,String address) throws OutOfStockException, demoBookBuyingException {
        Book myBook = books.get(ISBN);
            return myBook.BuyBook(quantity, email, address);

    }
}

