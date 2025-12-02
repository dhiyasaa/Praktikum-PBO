import java.util.ArrayList;
import java.util.List;

public class LambdaDownloadApp {

    // Method untuk menjalankan simulasi download di dalam thread
    public static Runnable createDownloadTask(String fileName) {
        // Menggunakan Lambda Expression untuk mendefinisikan Runnable
        return () -> {
            try {
                // Simulasi progress dari 10% sampai 100%
                for (int i = 10; i <= 100; i += 10) {
                    System.out.println(fileName + " progress: " + i + "%");
                    // Simulasi waktu download
                    Thread.sleep(500); 
                }
                System.out.println(fileName + " selesai diunduh!");
            } catch (InterruptedException e) {
                // Menangani jika thread diinterupsi saat sleep
                Thread.currentThread().interrupt(); 
                System.out.println(fileName + " download dibatalkan!");
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Downloading...");

        // Membuat daftar thread
        List<Thread> downloadThreads = new ArrayList<>();

        // Membuat dan memulai 3 thread menggunakan Lambda Expression
        // 1. Thread untuk File-1
        Thread f1 = new Thread(createDownloadTask("File-1"));
        downloadThreads.add(f1);
        
        // 2. Thread untuk File-2
        Thread f2 = new Thread(createDownloadTask("File-2"));
        downloadThreads.add(f2);

        // 3. Thread untuk File-3
        Thread f3 = new Thread(createDownloadTask("File-3"));
        downloadThreads.add(f3);

        // Memulai semua thread
        for (Thread t : downloadThreads) {
            t.start();
        }

        // Menunggu semua thread selesai menggunakan join()
        // join() memaksa thread utama (main) menunggu sampai thread yang dipanggil selesai
        f1.join(); 
        f2.join();
        f3.join();

        System.out.println("\nSemua file selesai diunduh!");

        // Menampilkan status akhir (semua harus TERMINATED)
        System.out.println("\nStatus akhir:");
        System.out.println(f1.getName() + ": " + f1.getState());
        System.out.println(f2.getName() + ": " + f2.getState());
        System.out.println(f3.getName() + ": " + f3.getState());
    }
}