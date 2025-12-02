import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class DownloadTaskGUI extends Thread {

    private String fileName;
    private JProgressBar progressBar;

    public DownloadTaskGUI(String fileName, JProgressBar progressBar) {
        this.fileName = fileName;
        this.progressBar = progressBar;
        // Inisialisasi progress bar
        this.progressBar.setMinimum(0);
        this.progressBar.setMaximum(100);
        this.progressBar.setStringPainted(true);
        this.progressBar.setString(fileName + ": 0%");
    }

    @Override
    public void run() {
        try {
            // Simulasi download: 10% hingga 100%
            for (int i = 10; i <= 100; i += 10) {
                final int progress = i;

                // Memperbarui JProgressBar harus dilakukan di Event Dispatch Thread (EDT)
                SwingUtilities.invokeLater(() -> {
                    progressBar.setValue(progress);
                    progressBar.setString(fileName + ": " + progress + "%");
                });

                // Simulasi waktu download
                Thread.sleep(500); 
            }
            
            // Setelah selesai
            SwingUtilities.invokeLater(() -> {
                progressBar.setString(fileName + " Selesai!");
            });
            
        } catch (InterruptedException e) {
            // Jika thread diinterupsi
            SwingUtilities.invokeLater(() -> {
                progressBar.setString(fileName + " Dibatalkan!");
            });
            Thread.currentThread().interrupt();
        }
    }
}