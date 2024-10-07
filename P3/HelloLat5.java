import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class HelloLat5 extends JFrame {


    private boolean checkedWNA ;
    public HelloLat5()  {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel judul = new JLabel("Form Bio Data",JLabel.CENTER);
      

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());


        JLabel nameLabel = new JLabel("Nama : ");
        JTextField nameField = new JTextField();

        JLabel nohpLabel = new JLabel("Nomor HP : ");
        JTextField nohpField = new JTextField();

        JLabel jenisKelaminLabel = new JLabel("Jenis Kelamin :");
        JRadioButton priaRadioButton = new JRadioButton("Pria");
        JRadioButton wanitaRadioButton = new JRadioButton("Wanita");
        ButtonGroup bg = new ButtonGroup();
        bg.add(priaRadioButton);
        bg.add(wanitaRadioButton); 

        JCheckBox checkWNA = new JCheckBox("Warga Negara Asing");

        JTextArea resultArea = new JTextArea(5, 30); // Atur ukuran preferensi area teks
        
      
        JButton simpan = new JButton("Simpan");



        JPanel panel = new JPanel();
        panel.setSize(300,300);

        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(judul, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(nameField, gbc);
       
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(nohpLabel, gbc);
       
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(nohpField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(jenisKelaminLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(priaRadioButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(wanitaRadioButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(checkWNA, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        panel.add(simpan, gbc);
       

     

        controlPanel.add(panel);

        

        this.setLayout(new BorderLayout());
        this.add(judul, BorderLayout.NORTH);
        this.add(controlPanel, BorderLayout.CENTER);
        this.add(resultArea , BorderLayout.SOUTH);



        this.setSize(400,400);


        checkWNA.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                checkedWNA = e.getStateChange() == 1;
            }
        });

        simpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = nameField.getText();
                String nohp = nohpField.getText();
                String jenisKelamin = "";
                String statusWNA = "";
                if(priaRadioButton.isSelected()){
                    jenisKelamin = priaRadioButton.getText();
                }
                if(wanitaRadioButton.isSelected()){
                    jenisKelamin = wanitaRadioButton.getText();
                }
                
                if(checkedWNA){
                    statusWNA = "Iya";
                } else {
                    statusWNA = "Tidak";
                }

                String msg = "Nama: " + nama + "\nNomor HP: " + nohp + "\nJenis Kelamin :" + jenisKelamin + "\nStatus WNA: " + statusWNA + "\n";

                resultArea.setText(msg);
            }
        });


    }
     public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloLat5 helloLat5 = new HelloLat5();
                helloLat5.setVisible(true);
            }
        });
    }
    
}
