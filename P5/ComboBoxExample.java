import java.awt.event.*;
import javax.swing.*;

public class ComboBoxExample{
    public static void main(String[] args) {
        JFrame frame = new JFrame("JComboBox Example");
        String[] options = {"Option 1", "Option 2", "Option 3", "Option 4"};

        // Membuat JComboBox dengan opsi
        JComboBox<String> comboBox = new JComboBox<>(options);

        // Tambahkan pendengar aksi
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // mengambil item yang dipilih
                String selected = (String) comboBox.getSelectedItem();
                System.out.println("Selected Option: " + selected);
            }    
        });

        // ATUR LAYOUT DAN TAMBAHKAN KE FRAME
        frame.setLayout(null);
        comboBox.setBounds(50, 50, 150, 20);
        frame.add(comboBox);
        
        // Konfigurasi frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);  // Menampilkan frame
    }
}