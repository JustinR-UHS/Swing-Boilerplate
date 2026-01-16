
package views;
import controllers.Drinks_Controller;
import controllers.Hamburger_Controller;
import controllers.Hotdog_Controller;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Body_Panel extends JPanel{
    CardLayout layout;
    public Body_Panel() {
        super();
        layout = new CardLayout();
        setLayout(layout);
        Hotdog_Controller hotdogController = new Hotdog_Controller();
        Hotdog_Panel hotdogPanel = hotdogController.getView();
        
        Hamburger_Controller hamburgerController = new Hamburger_Controller();
        Hamburger_Panel hamburgerPanel = hamburgerController.getView();
        
        JPanel dessertsPanel = new JPanel();
        dessertsPanel.setBackground(Color.decode("#3D1C02"));
        JLabel lblDesserts = new JLabel("Desserts Panel is showing");
        dessertsPanel.add(lblDesserts);
        
        //* Drinks_Controller drinksController = new Drinks_Controller();
        //* Drinks_Panel drinksPanel = drinksController.getView();
        
        add(hotdogPanel, "hot dogs");
        add(hamburgerPanel, "hamburgers");
        add(dessertsPanel, "desserts");
        //* add(drinksPanel, "drinks");
    }
    
    public void setPanel(String panelName) {
        layout.show(this, panelName);
    }
}
