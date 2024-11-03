package view.main;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import model.*;
import view.member.MemberFrame;
import dao.MemberDao;

public class MainFrame extends JFrame {
    private MemberFrame jenisMemberFrame;
    private JButton buttonJenisMember;
    private MemberDao memberDao;

    public MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        // Inisialisasi DAO
        this.memberDao = new MemberDao();

        // Inisialisasi frame
        this.jenisMemberFrame = new MemberFrame(memberDao);


        this.setLayout(new FlowLayout());
        MainButtonActionListener actionListener = new MainButtonActionListener(this);

        this.buttonJenisMember = new JButton("Jenis Member");

        this.buttonJenisMember.addActionListener(actionListener);

        this.add(buttonJenisMember);
    }

    public JButton getButtonJenisMember(){
        return buttonJenisMember;
    }

    public void showJenisMemberFrame(){
        if(jenisMemberFrame != null){
            jenisMemberFrame = new MemberFrame(memberDao);
        }

        jenisMemberFrame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            }
        });   
    }
}
