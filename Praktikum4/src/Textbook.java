public class Textbook extends Book {
    public Textbook(String title, String author) {
        super(title, author);
    }

    @Override
    public void showDetails() {
        System.out.println("=== Buku Pelajaran ===");
        super.showDetails();
    }
}
