public class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book (String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    // Methods to manage availability
    public void borrowBook() { this.isAvailable = false; }
    public void returnBook() { this.isAvailable = true; }
}