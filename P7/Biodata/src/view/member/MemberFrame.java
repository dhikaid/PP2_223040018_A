package view.member;

import dao.MemberDao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.*;
import model.Member;
import view.detailmember.DetailMember;



public class MemberFrame extends JFrame {
    private List<Member> jenisMemberList;
    private JTextField textFieldNama;
    private JSpinner spinnerTanggalLahir; // Ganti JDateChooser dengan JSpinner
    private JTextField textFieldAlamat;
    private JTextField textFieldEmail;
    private JTextField textFieldNoHp;
    private MemberTableModel tableModel;
    private MemberDao memberDao;

    public MemberFrame(MemberDao memberDao) {
        this.memberDao = memberDao;
        this.jenisMemberList = memberDao.findAll();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Membuat Label dan TextField untuk Nama
        JLabel labelInput = new JLabel("Nama:");
        labelInput.setBounds(15, 40, 350, 10);
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        // Membuat Label dan JSpinner untuk Tanggal Lahir
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        labelTanggalLahir.setBounds(15, 100, 350, 10);
        spinnerTanggalLahir = new JSpinner(new SpinnerDateModel()); // Inisialisasi JSpinner
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy");
        spinnerTanggalLahir.setEditor(dateEditor);
        spinnerTanggalLahir.setBounds(15, 120, 350, 30);

        // Membuat Label dan TextField untuk Alamat
        JLabel labelAlamat = new JLabel("Alamat:");
        labelAlamat.setBounds(15, 160, 350, 10);
        textFieldAlamat = new JTextField();
        textFieldAlamat.setBounds(15, 180, 350, 30);

        // Membuat Label dan TextField untuk Email
        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(15, 220, 350, 10);
        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(15, 240, 350, 30);

        // Membuat Label dan TextField untuk No HP
        JLabel labelNoHp = new JLabel("No HP:");
        labelNoHp.setBounds(15, 280, 350, 10);
        textFieldNoHp = new JTextField();
        textFieldNoHp.setBounds(15, 300, 350, 30);

        // Membuat Tombol Simpan
        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 340, 100, 40);

        // Membuat JTable dan JScrollPane
        JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 400, 350, 200);

        // Inisialisasi tabel model
        tableModel = new MemberTableModel(jenisMemberList);
        table.setModel(tableModel);

        // Tambahkan ActionListener untuk tombol Simpan
        MemberButtonSimpanActionListener actionListener = new MemberButtonSimpanActionListener(this, memberDao);
        buttonSimpan.addActionListener(actionListener);


        // Add mouse listener to the table
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // cek jika dia double click
                if(e.getClickCount() == 2){
                    int row = table.getSelectedRow();
                    if (row != -1) {
                        Member selectedMember = tableModel.getMemberAt(row);
                        openDetailMember(selectedMember);
                        dispose();
                    }
                }
            }
        });



        // Menambahkan komponen ke JFrame
        this.add(labelInput);
        this.add(textFieldNama);
        this.add(labelTanggalLahir);
        this.add(spinnerTanggalLahir); // Menambahkan JSpinner
        this.add(labelAlamat);
        this.add(textFieldAlamat);
        this.add(labelEmail);
        this.add(textFieldEmail);
        this.add(labelNoHp);
        this.add(textFieldNoHp);
        this.add(buttonSimpan);
        this.add(scrollableTable);

        // Set ukuran dan layout
        this.setSize(400, 650);
        this.setLayout(null);
        


    }
    private void openDetailMember(Member member) {
        DetailMember detailMember = new DetailMember(member, memberDao, this);
        detailMember.setVisible(true);
    }
    
    public String getNama() {
        return textFieldNama.getText();
    }
    
    public Date getTanggalLahir() {
        return (Date) spinnerTanggalLahir.getValue(); // Mengambil tanggal dari JSpinner
    }
    
    public String getAlamat() {
        return textFieldAlamat.getText();
    }
    
    public String getEmail() {
        return textFieldEmail.getText();
    }
    
    public String getNoHp() {
        return textFieldNoHp.getText();
    }

    public void addJenisMember(Member member) {
        tableModel.add(member);
        textFieldNama.setText("");
        spinnerTanggalLahir.setValue(new Date()); // Reset JSpinner ke tanggal sekarang
        textFieldAlamat.setText("");
        textFieldEmail.setText("");
        textFieldNoHp.setText("");
    }

    
}
