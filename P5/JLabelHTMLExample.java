import javax.swing.*;
public class JLabelHTMLExample {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("JFrame HTML Example");

        // membuat jlabel dengan teks html
        JLabel label = new JLabel("<html><body><h1>Hello, <span style='color:red;'>World!</span></h1></body></html>");

        // menambahkan jlabel ke frame
        frame.add(label);

        // konfirgurasi frame
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
