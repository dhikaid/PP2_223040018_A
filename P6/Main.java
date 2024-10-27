import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Universitas Pasundan Bank");

        // membuat jlabel dengan teks html
        JLabel label = new JLabel("<html><body><h1>Hello, <span style='color:red;'>Admin!</span> Welcome to BANK OF UNPAS</h1><h2>Mohon untuk memilih form yang ada pada menu</h2></body></html>");

        // menambahkan jlabel ke frame
        frame.add(label);

        // konfigurasi frame
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // JMenu untuk ke tiap class
        JMenu formMenu = new JMenu("Menu");
        JMenuItem form1Item = new JMenuItem("Pendaftaran Nasabah");
        form1Item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // panggil constructor pada class FormDataDiri
                new PendaftaranNasabah();
            }
        });
        formMenu.add(form1Item);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(formMenu);
        frame.setJMenuBar(menuBar);
    }
}
