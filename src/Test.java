import java.util.List;
public class Test {
    void TestAdding(Book b){
        System.out.println("Adding Test");
        inventory inv = new inventory();
        inv.addToInventory(b);
        if(inv.BookExistsInInventory(b.getISBN()))
            System.out.println("Book: " + b.getTitle() + " exists in inventory (Test passed)" );
        else
            System.out.println("Book: " + b.getTitle() + " not in inventory (Test failed)");

        System.out.println("*******************");
    }
    void TestRemoving(int year){
        System.out.println("Removing Test");
        inventory inv = new inventory();
         EBook b1 = new EBook("123","outdated book",year-1,50,"pdf");
         paperBook b2 = new paperBook("122","valid book",year+1,60,3);
         inv.addToInventory(b1);
        inv.addToInventory(b2);
        List<Book> l = inv.removeOutdatedBooks(year);
        if(inv.BookExistsInInventory(b2.getISBN())){
            if(!(inv.BookExistsInInventory(b1.getISBN()))) {
                if (l.contains(b1)) {
                    System.out.println("Removing outdated books (test passed)");
                }
                else {
                    System.out.println("returned list does not contain the outdated book (Test failed)");
                }
            }
            else {
                System.out.println("outdated book not removed (Test failed)");
            }
        }
        else {
            System.out.println("removed a valid book (Test failed)");
        }
        System.out.println("*******************");
    }

    void TestBuying()  {
        System.out.println("Buying Test");
        inventory inv = new inventory();

        paperBook paper = new paperBook("111", "Paper Book", 2000, 90.5, 5);

        EBook ebook = new EBook("222", "EBook", 2010, 120.5, "PDF");

        demoBook demo = new demoBook("333", "Demo Book", 2020, 100.5);

        inv.addToInventory(paper);
        inv.addToInventory(ebook);
        inv.addToInventory(demo);

        try {
            int qBefore = paper.getStock();
            inv.buyBookInventory(paper.getISBN(), 3, "email 1", "add 1");
            int qAfter = paper.getStock();
            if (qBefore - qAfter == 3)
                System.out.println("paper book bought and its quantity reduced correctly (Test passed)");
        } catch(OutOfStockException | demoBookBuyingException e){
            if (e instanceof OutOfStockException)
                System.out.println("out of stock exception caught when the is enough quantity (Test failed)");
            else {
                System.out.println("demoBookBuyingException caught(Test failed)");
            }
        }

        try {
            inv.buyBookInventory(paper.getISBN(), 10, "email 1", "add 1");
            System.out.println("Book bought even though not enough stock (Test failed)");
        } catch(OutOfStockException | demoBookBuyingException e){
            if (e instanceof OutOfStockException)
                System.out.println("out of stock exception caught when there is not enough quantity (Test passed)");
            else {
                System.out.println("demoBookBuyingException caught(Test failed)");
            }
        }

        try {
            inv.buyBookInventory(ebook.getISBN(), 1, "email 2", "add 2");
            System.out.println("EBook bought successfully (Test passed)");
        } catch (OutOfStockException e) {
            System.out.println("OutOfStockException caught when buying EBook (Test failed)");
        } catch (demoBookBuyingException e) {
            System.out.println("DemoBookBuyingException caught when buying EBook (Test failed)");
        }


        try {
            inv.buyBookInventory(demo.getISBN(), 1, "email 3", "add 3");
            System.out.println("Demo book was bought (Test failed)");
        } catch (demoBookBuyingException e) {
            System.out.println("DemoBookBuyingException caught as expected (Test passed)");
        } catch (OutOfStockException e) {
            System.out.println("OutOfStockException caught instead of DemoBookBuyingException (Test failed)");
        }

    }


}
