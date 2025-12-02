import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DownloadManagerGUI extends JFrame {

    private JProgressBar file1Bar, file2Bar, file3Bar;
    private JButton startButton;

    public DownloadManagerGUI() {
        super("Download Manager App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel utama untuk progress bar
        JPanel progressPanel = new JPanel();
        progressPanel.setLayout(new GridLayout(3, 1, 5, 5)); 
        progressPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Inisialisasi Progress Bar
        file1Bar = new JProgressBar();
        file2Bar = new JProgressBar();
        file3Bar = new JProgressBar();

        // Menambahkan Label dan Progress Bar ke panel
        progressPanel.add(new JLabel("File 1:"));
        progressPanel.add(file1Bar);
        progressPanel.add(new JLabel("File 2:"));
        progressPanel.add(file2Bar);
        progressPanel.add(new JLabel("File 3:"));
        progressPanel.add(file3Bar);

        // Tombol Start
        startButton = new JButton("Downloading");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startDownloads();
                startButton.setEnabled(false); // Nonaktifkan tombol setelah diklik
            }
        });

        // Menambahkan komponen ke Frame
        add(progressPanel, BorderLayout.CENTER);
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        southPanel.add(startButton);
        add(southPanel, BorderLayout.SOUTH);

        pack(); // Mengatur ukuran frame agar sesuai dengan komponen
        setLocationRelativeTo(null); // Menempatkan frame di tengah layar
        setVisible(true);
    }

    private void startDownloads() {
        // Membuat dan memulai thread untuk setiap file
        DownloadTaskGUI f1 = new DownloadTaskGUI("File 1", file1Bar);
        DownloadTaskGUI f2 = new DownloadTaskGUI("File 2", file2Bar);
        DownloadTaskGUI f3 = new DownloadTaskGUI("File 3", file3Bar);

        f1.start();
        f2.start();
        f3.start();
    }

    public static void main(String[] args) {
        // Memastikan inisialisasi GUI terjadi di Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new DownloadManagerGUI());
    }
}