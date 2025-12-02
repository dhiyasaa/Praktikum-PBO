public class User {
    private String name;

    // Constructor default diubah agar nama defaultnya "Superman" (menyesuaikan output)
    public User() {
        this.name = "Dhiya";
    }

    public User (String name) {
        this.name = name;
    }

    // Method viewBookDetails menerapkan Polymorphism
    public void viewBookDetails (Book book) {
        System.out.println("Judul: "+ book.getTitle());
        System.out.println("Penulis: "+ book.getAuthor());
        System.out.println("Tersedia:" + (book.isAvailable() ? "Ya": "Tidak"));

        // Polymorphism: Menggunakan instanceof untuk mengecek tipe sub-class
        if (book instanceof Novel) {
            Novel novel = (Novel) book;
            System.out.println("Genre: " + novel.getGenre());
        } else if (book instanceof Magazine) {
            Magazine magazine = (Magazine) book;
            System.out.println("Kategori: " + magazine.getCategory());
        } else if (book instanceof Textbook) {
            Textbook textbook = (Textbook) book;
            System.out.println("Bidang Studi: " + textbook.getStudyField());
        }
    }
    
    // Method untuk meminjam buku
    public void borrowBook (Book book) {
        if (book.isAvailable()) {
            book.borrowBook();
            System.out.println("Buku \"" + book.getTitle() + "\" berhasil dipinjam oleh " + this.name);
        } else {
            System.out.println("Maaf " + this.name + ", buku \"" + book.getTitle() + "\" sedang tidak tersedia.");
        }
    }
    
    // Method untuk mengembalikan buku
    public void returnBook (Book book) {
        if (!book.isAvailable()) {
            book.returnBook();
            System.out.println("Buku \"" + book.getTitle() + "\" berhasil dikembalikan.");
        } else {
            System.out.println("Buku \"" + book.getTitle() + "\" sudah tersedia.");
        }
    }
}