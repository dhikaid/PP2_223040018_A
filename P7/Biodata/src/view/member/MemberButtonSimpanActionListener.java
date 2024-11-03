package view.member;

import dao.MemberDao;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.UUID;
import model.Member;

public class MemberButtonSimpanActionListener implements ActionListener{
    private MemberFrame jenisMemberFrame;
    private MemberDao memberDao;

    public MemberButtonSimpanActionListener(MemberFrame jenisMemberFrame, MemberDao memberDao){
        this.jenisMemberFrame = jenisMemberFrame;
        this.memberDao = memberDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = this.jenisMemberFrame.getNama();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(this.jenisMemberFrame.getTanggalLahir());
        String tanggalLahir = sdf.format(this.jenisMemberFrame.getTanggalLahir()).toString();
        String alamat = this.jenisMemberFrame.getAlamat();
        String email = this.jenisMemberFrame.getEmail();
        String noHP = this.jenisMemberFrame.getNoHp();
        Member member = new Member();
        member.setId(UUID.randomUUID().toString());
        member.setNama(nama);
        member.setTanggalLahir(tanggalLahir);
        member.setAlamat(alamat);
        member.setEmail(email);
        member.setNoHP(noHP);

        this.jenisMemberFrame.addJenisMember(member);
        this.memberDao.insert(member);
    }
}
