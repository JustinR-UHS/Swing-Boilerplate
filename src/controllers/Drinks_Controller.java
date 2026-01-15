
package controllers;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import models.Drinks;
import views.Drinks_Panel;

//A class that will track a list of drinks orders
public class Drinks_Controller {

    ArrayList<Drinks> drinksOrders;
    private final Drinks_Panel view;
    private Drinks currentOrder;
    private boolean isResetting = false;

    public Drinks_Controller() {
        drinksOrders = new ArrayList<>();
        view = new Drinks_Panel(this);
    }

    public Drinks_Panel getView() {
        return view;
    }

    public void newOrderListener(JButton btnStart) {
        btnStart.addActionListener(e -> {
            currentOrder = new Drinks();
            view.showOrderForm();
        });
    }

    public void toppingListener(JCheckBox cbx) {
        cbx.addActionListener(e -> {
            if (!isResetting) {
                JCheckBox cb = (JCheckBox) e.getSource();
                String topping = cb.getText();
                if (cb.isSelected()) {
                    currentOrder.addTopping(topping);
                } else {
                    currentOrder.removeTopping(topping);
                }
            }
        });
    }

    public void submitListenter(JButton btn) {
        btn.addActionListener(e -> {
            String orderName = view.getOrderName();
            drinksOrders.add(currentOrder);
            double cost = currentOrder.getPrice();
            double tax = currentOrder.getTax(cost);
            double total = currentOrder.getPriceWithTax();
            isResetting = true;
            view.addOrder(orderName, currentOrder.toString(), cost, tax, total);
            currentOrder = null;
            view.reset();
            isResetting = false;
        });
    }

    public void cancelListenter(JButton btn) {
        btn.addActionListener(e -> {
            currentOrder = null;
            isResetting =  true;
            view.reset();
            isResetting = false;
        });
    }
}



