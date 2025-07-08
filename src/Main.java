// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        paperBook paper = new paperBook("111", "Paper Book", 2000, 90.5, 5);
        EBook ebook = new EBook("222", "EBook", 2010, 120.5, "PDF");
        demoBook demo = new demoBook("333", "Demo Book", 2020, 100.5);

        Test t = new Test();
        t.TestAdding(paper);
        t.TestAdding(ebook);
        t.TestAdding(demo);

        t.TestRemoving(2000);
        t.TestBuying();
    }
}