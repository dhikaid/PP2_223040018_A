import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class PendaftaranNasabah {

    public PendaftaranNasabah() {

        JFrame frame = new JFrame("Data Nasabah Bank UNPAS");

        // Tambahkan layout manual
        frame.setLayout(null);

        // TABLE UNTUK MENAMPILKAN ISI FORM
        String[] columnNames = {"Nama", "WNA", "Jenis Kartu", "Lokasi Cabang", "Nomor Rekening", "Alasan", "Saldo", "Ratio Transaksi"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(10, 10, 500, 100);

        // FORM INPUT
        JLabel namaLabel = new JLabel("Nama Nasabah:");
        namaLabel.setBounds(10, 120, 100, 30);

        JTextField namaTextField = new JTextField();
        namaTextField.setBounds(10, 160, 200, 30);

        // CHECKBOX WNA ATAU TIDAK
        JCheckBox wnaCheckbox = new JCheckBox("Warga Negara Asing");
        wnaCheckbox.setBounds(10, 200, 150, 30);

        // GUNAKAN JLABEL UNTUK MEMILIH RADIO BUTTON JENISKARTU
        JLabel jenisKartuLabel = new JLabel("Jenis Kartu:");
        jenisKartuLabel.setBounds(10, 240, 100, 30);

        // PILIH JENIS KARTU MENGGUNAKAN RADIO BUTTON
        ButtonGroup jenisKartuGroup = new ButtonGroup();
        JRadioButton kartu1 = new JRadioButton("Kartu Junior");
        kartu1.setBounds(10, 280, 100, 30);
        jenisKartuGroup.add(kartu1);
        JRadioButton kartu2 = new JRadioButton("Kartu Reguler");
        kartu2.setBounds(10, 320, 140, 30);
        jenisKartuGroup.add(kartu2);
        JRadioButton kartu3 = new JRadioButton("Kartu Bisnis");
        kartu3.setBounds(10, 360, 100, 30);
        jenisKartuGroup.add(kartu3);

        // FIELD KANTOR CABANG YANG MENGGUNAKAN JCOMBOBOX
        JLabel alamatLabel = new JLabel("Lokasi cabang pendaftaran:");
        alamatLabel.setBounds(10, 400, 200, 30);
        JComboBox<String> alamatComboBox = new JComboBox<>(new String[]{"Jakarta", "Bandung", "Surabaya"});
        alamatComboBox.setBounds(10, 440, 200, 30);

        // FIELD NOMOR REKENING YANG MENGGUNAKAN JLIST
        JLabel nomorRekeningLabel = new JLabel("Nomor Rekening Tersedia:");
        nomorRekeningLabel.setBounds(10, 480, 200, 30);
        JList<String> nomorRekeningList = new JList<>(new String[]{"1234567890", "9876543210", "0987654321"});
        JScrollPane nomorRekeningScrollPane = new JScrollPane(nomorRekeningList);
        nomorRekeningScrollPane.setBounds(10, 520, 200, 100);

        // FIELD ALASAN MENGGUNAKAN JTEXTAREA
        JLabel alasanLabel = new JLabel("Alasan Menggunakan Rekening:");
        alasanLabel.setBounds(10, 630, 200, 30);
        JTextArea alasanTextArea = new JTextArea();
        alasanTextArea.setBounds(10, 670, 480, 100);


        // JSPINNER YANG DIGUNAKAN UNTUK MEMASUKAN JUMLAH SETORAN AWAL
        JLabel jumlahSetoranAwalLabel = new JLabel("Jumlah Setoran Awal:");
        jumlahSetoranAwalLabel.setBounds(300, 120, 150, 30);
        JSpinner jumlahSetoranAwalSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1000000000, 1000000));
        jumlahSetoranAwalSpinner.setBounds(300, 160, 200, 30);
       

        // JSLIDER YANG DIGUNAKAN UNTUK MEMASUKAN RATIO TRANSAKSI PERBULANNYA
        JLabel ratioTransaksiLabel = new JLabel("Ratio Transaksi Perbulan:");
        ratioTransaksiLabel.setBounds(300, 200, 200, 30);
        // JSLIDER UNTUK MENGATUR RATIO TRANSAKSI PERBULAN
        JSlider ratioTransaksiSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        ratioTransaksiSlider.setBounds(300, 240, 200, 50);  
        ratioTransaksiSlider.setMajorTickSpacing(20);
        ratioTransaksiSlider.setMinorTickSpacing(5);
        ratioTransaksiSlider.setPaintTicks(true);
        ratioTransaksiSlider.setPaintLabels(true);

        // CHANGE LISTENER UNTUK SLIDER
        ratioTransaksiSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int value = source.getValue();  // Dapatkan nilai slider
                    ratioTransaksiLabel.setText("Ratio Transaksi Perbulan: " + value); 
                }
            }
        });


    
        // TOMBOL SUBMIT
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(10, 780, 100, 30);

        // TAMBAHKAN ACTION LISTENER UNTUK TOMBOL SUBMIT
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ambil data dari form
                String nama = namaTextField.getText();
                String wna = wnaCheckbox.isSelected() ? "Ya" : "Tidak";
                String jenisKartu = "";
                if (kartu1.isSelected()) {
                    jenisKartu = "Kartu Junior";
                } else if (kartu2.isSelected()) {
                    jenisKartu = "Kartu Reguler";
                } else if (kartu3.isSelected()) {
                    jenisKartu = "Kartu Bisnis";
                }
                String lokasiCabang = (String) alamatComboBox.getSelectedItem();
                String nomorRekening = nomorRekeningList.getSelectedValue();
                String alasan = alasanTextArea.getText();
                // get value from jumlah setoran
                int jumlahSetoranAwal = (int) jumlahSetoranAwalSpinner.getValue();
                int ratio = (int) ratioTransaksiSlider.getValue();
         

                // Tambahkan data ke JTable
                tableModel.addRow(new Object[]{nama, wna, jenisKartu, lokasiCabang, nomorRekening, alasan, jumlahSetoranAwal, ratio});

                // Kosongkan form setelah submit
                namaTextField.setText("");
                wnaCheckbox.setSelected(false);
                jenisKartuGroup.clearSelection();
                alamatComboBox.setSelectedIndex(0);
                nomorRekeningList.clearSelection();
                alasanTextArea.setText("");
                jumlahSetoranAwalSpinner.setValue(0);
                ratioTransaksiSlider.setValue(0);
            }
        });

        // JMENU DAN JMENU BAR UNTUK RESET FORM
        JMenu resetMenu = new JMenu("Menu");
        JMenuItem resetItem = new JMenuItem("Reset");
        resetItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset semua inputan
                namaTextField.setText("");
                wnaCheckbox.setSelected(false);
                jenisKartuGroup.clearSelection();  // Reset pilihan radio button
                alamatComboBox.setSelectedIndex(0);  // Reset pilihan combo box
                nomorRekeningList.clearSelection();  // Reset pilihan JList
                alasanTextArea.setText("");  // Kosongkan text area
                jumlahSetoranAwalSpinner.setValue(0);
                ratioTransaksiSlider.setValue(0);
            }
        });
        resetMenu.add(resetItem);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(resetMenu);
        frame.setJMenuBar(menuBar);

        // Tambahkan komponen ke frame
        frame.add(tableScrollPane);
        frame.add(namaLabel);
        frame.add(namaTextField);
        frame.add(wnaCheckbox);
        frame.add(jenisKartuLabel);
        frame.add(kartu1);
        frame.add(kartu2);
        frame.add(kartu3);
        frame.add(alamatLabel);
        frame.add(alamatComboBox);
        frame.add(nomorRekeningLabel);
        frame.add(nomorRekeningScrollPane);
        frame.add(alasanLabel);
        frame.add(alasanTextArea);
        frame.add(jumlahSetoranAwalLabel);
        frame.add(jumlahSetoranAwalSpinner);
        frame.add(ratioTransaksiLabel);
        frame.add(ratioTransaksiSlider);
        frame.add(submitButton);
        

        // Konfigurasi frame
        frame.setSize(600, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
