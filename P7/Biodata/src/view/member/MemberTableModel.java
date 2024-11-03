package view.member;

import java.util.List;
import javax.swing.table.*;
import model.Member;


public class MemberTableModel extends AbstractTableModel {
    private String[] columnNames = {"Nama","Tanggal Lahir", "Alamat", "Email", "No. HP"};
    private List<Member> data;

    public MemberTableModel(List<Member> data ){
        this.data = data;
    }


    public int getColumnCount(){
        return columnNames.length;
    }

    public int getRowCount(){
        return data.size();
    }

    public String getColumnName(int col){
        return columnNames[col];
    }

    public Object getValueAt(int row, int col){
        Member member = data.get(row);
        String value = "";
        switch (col) {
            case 0:
                value = member.getNama();
                break;
            case 1:
                value = member.getTanggalLahir();
                break;
            case 2:
                value = member.getAlamat();
                break;
            case 3:
                value = member.getEmail();
                break;
            case 4:
                value = member.getNoHP();
                break;
        }

        return value;
    }

    public boolean isCellEditable(int row, int col){
        return false;
    }
    
    public void add(Member value){
        data.add(value);
        fireTableRowsInserted(data.size() -1 , data.size() -1);
    }

    public Member getMemberAt(int row) {
        return data.get(row);
    }
}
