public class Book {
    private String title;
    private String author;
    private boolean isAvailable = true;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() { 
        return title; 
    }

    public String getAuthor() { 
        return author; 
    }

    public boolean isAvailable() { 
        return isAvailable; 
    }

    public void setAvailable(boolean available) { 
        this.isAvailable = available; 
    }

    public void showDetails() {
        System.out.println("Judul : " + title);
        System.out.println("Penulis : " + author);
    }
}
