import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableExample {
    public static void main(String[] args) {
        // membuat frame
        JFrame frame = new JFrame("JTable Example");

        // membuat table dengan data awal dan header kolom
        String[] columnNames = {"ID", "Name", "Age"};
        Object[][] data = {
                {"1", "John Doe", 25},
                {"2", "Jane Smith", 30},
                {"3", "Alice Johnson", 28}
        };

        // membuat model tabel
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // membuat table
        JTable table = new JTable(model);

        // menambahkan scroll pane ke frame
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        // konfirgurasi frame
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    

    }
}
