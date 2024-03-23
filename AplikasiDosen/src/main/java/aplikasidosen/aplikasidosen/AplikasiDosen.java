/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package aplikasidosen.aplikasidosen;
import javax.swing.*;

public class AplikasiDosen extends JDialog {
    private Display currentDisplay;

    public AplikasiDosen() {
        setTitle("Aplikasi Input Nilai Mahasiswa");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        currentDisplay = new LoginDisplay(this); // Saat aplikasi dimulai, tampilkan tampilan login
        currentDisplay.show();
    }

    public void changeDisplay(Display newDisplay) {
        currentDisplay = newDisplay;
        currentDisplay.show(); // Tampilkan tampilan baru
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AplikasiDosen());
    }
}

