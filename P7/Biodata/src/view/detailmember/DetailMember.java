package view.detailmember;

import dao.MemberDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import model.Member;
import view.member.MemberFrame;

public class DetailMember extends JFrame {
    private Member member;
    private MemberDao memberDao;
    private MemberFrame memberFrame;

    private JTextField textFieldNama;
    private JSpinner spinnerTanggalLahir;
    private JTextField textFieldAlamat;
    private JTextField textFieldEmail;
    private JTextField textFieldNoHp;

    public DetailMember(Member member, MemberDao memberDao, MemberFrame memberFrame) {
        this.member = member;
        this.memberDao = memberDao;
        this.memberFrame = memberFrame;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(null);

        // Initialize UI components with member data
        JLabel labelInput = new JLabel("Nama:");
        labelInput.setBounds(15, 20, 100, 25);
        textFieldNama = new JTextField(member.getNama());
        textFieldNama.setBounds(120, 20, 250, 25);

        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        labelTanggalLahir.setBounds(15, 60, 100, 25);

         try {
        // Use "yyyy-MM-dd" to match the database date format
        Date tanggalLahir = new SimpleDateFormat("yyyy-MM-dd").parse(member.getTanggalLahir());
        spinnerTanggalLahir = new JSpinner(new SpinnerDateModel(tanggalLahir, null, null, Calendar.DAY_OF_MONTH));
        } catch (Exception ex) {
            spinnerTanggalLahir = new JSpinner(new SpinnerDateModel());
        }
        
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy");
        spinnerTanggalLahir.setEditor(dateEditor);
        spinnerTanggalLahir.setBounds(120, 60, 250, 25);

        JLabel labelAlamat = new JLabel("Alamat:");
        labelAlamat.setBounds(15, 100, 100, 25);
        textFieldAlamat = new JTextField(member.getAlamat());
        textFieldAlamat.setBounds(120, 100, 250, 25);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(15, 140, 100, 25);
        textFieldEmail = new JTextField(member.getEmail());
        textFieldEmail.setBounds(120, 140, 250, 25);

        JLabel labelNoHp = new JLabel("No HP:");
        labelNoHp.setBounds(15, 180, 100, 25);
        textFieldNoHp = new JTextField(member.getNoHP()); // Ganti ke getNoHP
        textFieldNoHp.setBounds(120, 180, 250, 25);

        JButton buttonUpdate = new JButton("Update");
        buttonUpdate.setBounds(120, 220, 100, 30);
        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateMember();
            }
        });

        JButton buttonDelete = new JButton("Hapus");
        buttonDelete.setBounds(230, 220, 100, 30);
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteMember();
            }
        });

        // Add components to the JFrame
        this.add(labelInput);
        this.add(textFieldNama);
        this.add(labelTanggalLahir);
        this.add(spinnerTanggalLahir);
        this.add(labelAlamat);
        this.add(textFieldAlamat);
        this.add(labelEmail);
        this.add(textFieldEmail);
        this.add(labelNoHp);
        this.add(textFieldNoHp);
        this.add(buttonUpdate);
        this.add(buttonDelete);
    }

    private void updateMember() {
        member.setNama(textFieldNama.getText());
        Date date = (Date) spinnerTanggalLahir.getValue();
        String tanggalLahirString = new SimpleDateFormat("yyyy-MM-dd").format(date); // Ubah format di sini
        member.setTanggalLahir(tanggalLahirString);
        member.setAlamat(textFieldAlamat.getText());
        member.setEmail(textFieldEmail.getText());
        member.setNoHP(textFieldNoHp.getText()); // Pastikan ini setNoHP
        memberDao.update(member); // Update the member in the database
        JOptionPane.showMessageDialog(this, "Member updated successfully!");
        dispose(); // Close the window
        // buka kembali memberframe
        memberFrame.setVisible(true); 

    }
    
    private void deleteMember() {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this member?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            memberDao.delete(member); // Assuming the Member class has a method to get ID
            JOptionPane.showMessageDialog(this, "Member deleted successfully!");
            dispose(); // Close the window
        }
    }
}
