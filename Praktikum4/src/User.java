public class User {
    private String name;

    public User() {
        this.name = "Pengguna Umum";
    }

    public User(String name) {
        this.name = name;
    }

    public void viewBookDetails(Book book) {
        System.out.println("\n[DETAIL BUKU DILIHAT OLEH " + name + "]");
        book.showDetails();
        System.out.println("Status: " + (book.isAvailable() ? "Tersedia" : "Sedang dipinjam"));
    }

    public void borrowBook(Book book) {
        System.out.println("\n[PERCOBAAN PEMINJAMAN]");
        if(book.isAvailable()) {
            book.setAvailable(false);
            System.out.println(name + " berhasil meminjam \"" + book.getTitle() + "\"");
        } else {
            System.out.println("Maaf, buku \"" + book.getTitle() + "\" sedang dipinjam!");
        }
    }

    public void returnBook(Book book) {
        System.out.println("\n[PENGEMBALIAN BUKU]");
        if(!book.isAvailable()) {
            book.setAvailable(true);
            System.out.println(name + " telah mengembalikan buku \"" + book.getTitle() + "\"");
        } else {
            System.out.println("Buku ini memang sedang tersedia, tidak dapat dikembalikan.");
        }
    }
}
