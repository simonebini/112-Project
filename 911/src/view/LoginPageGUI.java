package view;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class LoginPageGUI extends JFrame implements ActionListener {

    private JLabel lblUsername, lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnCancel;

    public LoginPageGUI() {
        super("Login");

        // Creazione dei controlli dell'interfaccia
        lblUsername = new JLabel("Username:");
        lblPassword = new JLabel("Password:");
        txtUsername = new JTextField(20);
        txtPassword = new JPasswordField(20);
        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");

        // Aggiunta dei controlli al pannello
        JPanel pnlMain = new JPanel(new GridLayout(3, 2));
        pnlMain.add(lblUsername);
        pnlMain.add(txtUsername);
        pnlMain.add(lblPassword);
        pnlMain.add(txtPassword);
        pnlMain.add(btnLogin);
        pnlMain.add(btnCancel);

        // Aggiunta del pannello alla finestra
        add(pnlMain);

        // Aggiunta dell'handler per gli eventi dei pulsanti
        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);

        // Configurazione della finestra
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            // Lettura delle credenziali dal file di testo
            try (BufferedReader br = new BufferedReader(new FileReader("credenziali.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    String fileUsername = parts[0];
                    String filePassword = parts[1];

                    if (username.equals(fileUsername) && password.equals(filePassword)) {
                        JOptionPane.showMessageDialog(this, "Accesso eseguito!");
                        dispose(); // Chiude la finestra di login
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Username o Passowrd errati!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Errore durante la lettura del file!");
                ex.printStackTrace();
            }
        } else if (e.getSource() == btnCancel) {
            dispose(); // Chiude la finestra di login
        }
    }

    public static void main(String[] args) {
        new LoginPageGUI();
    }
}

