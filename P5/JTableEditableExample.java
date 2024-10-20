import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableEditableExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable Editable Example");
           // membuat table dengan data awal dan header kolom
           String[] columnNames = {"ID", "Name", "Age"};
           Object[][] data = {
                   {"1", "John Doe", 25},
                   {"2", "Jane Smith", 30},
                   {"3", "Alice Johnson", 28}
           };

        //    Membuat defaulttable model dengan data dan header
        DefaultTableModel model = new DefaultTableModel(data, columnNames){
            // menonaktifkan edit pada cell
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 1; // hanya kolom ID yang dapat diedit
            };
        };
        
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
