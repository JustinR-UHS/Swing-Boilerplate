package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Title_Panel extends JPanel{
    
    public Title_Panel(String title) {
        super();
        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 26));
        add(lblTitle);
        setBackground(Color.WHITE);
    }
}
