public class Magazine extends Book {
    public Magazine(String title, String author) {
        super(title, author);
    }

    @Override
    public void showDetails() {
        System.out.println("=== Majalah ===");
        super.showDetails();
    }
}
