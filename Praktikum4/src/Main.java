public class Main {
    public static void main(String[] args) {
        Book novel = new Novel("Laskar Pelangi", "Andrea Hirata");
        Book magazine = new Magazine("National Geographic", "Tim NG");
        Book textbook = new Textbook("Pemrograman Java", "Dr. Andi");

        User user = new User("Dhiya");

        System.out.println("=== MENAMPILKAN DETAIL BUKU ===");
        user.viewBookDetails(novel);
        user.viewBookDetails(magazine);
        user.viewBookDetails(textbook);

        System.out.println("\n=== PROSES PEMINJAMAN & PENGEMBALIAN ===");
        user.borrowBook(novel);
        user.borrowBook(novel); // mencoba meminjam yang sudah dipinjam
        user.returnBook(novel);
        user.returnBook(novel); // mencoba mengembalikan yang sudah tersedia

        System.out.println("\n=== STATUS AKHIR ===");
        user.viewBookDetails(novel);
    }
}
