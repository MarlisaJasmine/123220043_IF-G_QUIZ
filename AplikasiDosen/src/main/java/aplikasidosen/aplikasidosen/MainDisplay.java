/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasidosen.aplikasidosen;

/**
 *
 * @author ASUS
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainDisplay implements Display {
    private final JDialog dialog;
    private JTextField textFieldNama, textFieldNIM, textFieldNilaiTugas, textFieldNilaiQuiz;
    private JComboBox<String> comboBoxKelas, comboBoxMataKuliah;
    private JButton buttonSubmit, buttonLogout;

    public MainDisplay(JDialog dialog) {
        this.dialog = dialog;
    }

    public void show() {
        dialog.getContentPane().removeAll();
        dialog.setTitle("Aplikasi Input Nilai Mahasiswa");
        dialog.setLayout(new GridLayout(6, 2, 10, 10));

        textFieldNama = new JTextField();
        textFieldNIM = new JTextField();
        textFieldNilaiTugas = new JTextField();
        textFieldNilaiQuiz = new JTextField();
        comboBoxKelas = new JComboBox<>(new String[]{"Kelas Praktikum", "Kelas Teori"});
        comboBoxMataKuliah = new JComboBox<>(new String[]{"PBO", "SCPK", "Algo Lanjut"});
        buttonSubmit = new JButton("Submit");
        buttonLogout = new JButton("Logout");

        dialog.add(new JLabel("Nama Mahasiswa:"));
        dialog.add(textFieldNama);
        dialog.add(new JLabel("NIM Mahasiswa:"));
        dialog.add(textFieldNIM);
        dialog.add(new JLabel("Nilai Tugas:"));
        dialog.add(textFieldNilaiTugas);
        dialog.add(new JLabel("Nilai Quiz:"));
        dialog.add(textFieldNilaiQuiz);
        dialog.add(new JLabel("Kelas:"));
        dialog.add(comboBoxKelas);
        dialog.add(new JLabel("Mata Kuliah:"));
        dialog.add(comboBoxMataKuliah);
        dialog.add(buttonSubmit);
        dialog.add(buttonLogout);

        buttonSubmit.addActionListener(e -> hitungDanTampilkanNilai());
        buttonLogout.addActionListener(e -> dialog.dispose());

        dialog.revalidate();
        dialog.repaint();
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void hitungDanTampilkanNilai() {
        String nama = textFieldNama.getText();
        String nim = textFieldNIM.getText();
        double nilaiTugas = Double.parseDouble(textFieldNilaiTugas.getText());
        double nilaiQuiz = Double.parseDouble(textFieldNilaiQuiz.getText());
        String kelas = (String) comboBoxKelas.getSelectedItem();
        String mataKuliah = (String) comboBoxMataKuliah.getSelectedItem();

        double totalNilai;
        if (kelas.equals("Kelas Praktikum")) {
            totalNilai = nilaiTugas * 0.3 + nilaiQuiz * 0.7;
        } else {
            totalNilai = nilaiTugas * 0.7 + nilaiQuiz * 0.3;
        }

        String hasil = totalNilai >= 85 ? "Pass" : "Not Pass";

        JOptionPane.showMessageDialog(dialog, String.format("Nama: %s\nNIM: %s\nMata Kuliah: %s\nHasil: %s\nTotal Nilai: %.2f", nama, nim, mataKuliah, hasil, totalNilai), "Hasil Nilai", JOptionPane.INFORMATION_MESSAGE);
    }
}

