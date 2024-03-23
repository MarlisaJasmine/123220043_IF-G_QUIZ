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

public class LoginDisplay implements Display {
    private final JDialog dialog;

    public LoginDisplay(JDialog dialog) {
        this.dialog = dialog;
    }

    public void show() {
        dialog.getContentPane().removeAll();
        dialog.setTitle("Login");
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));

        JTextField nimField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton cancelButton = new JButton("Cancel");

        loginPanel.add(new JLabel("NIM:"));
        loginPanel.add(nimField);
        loginPanel.add(new JLabel("Sandi:"));
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(cancelButton);

        loginButton.addActionListener(e -> {
            String nim = nimField.getText();
            String password = new String(passwordField.getPassword());
            if (nim.equals("043") && password.equals("123123")) {
                new MainDisplay(dialog).show();
            } else {
                JOptionPane.showMessageDialog(dialog, "NIM atau Sandi salah.", "Login Gagal", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> System.exit(0));

        dialog.setContentPane(loginPanel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}

