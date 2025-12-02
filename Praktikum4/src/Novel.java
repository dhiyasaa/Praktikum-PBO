public class Novel extends Book {
    public Novel(String title, String author) {
        super(title, author);
    }

    @Override
    public void showDetails() {
        System.out.println("=== Novel ===");
        super.showDetails();
    }
}
