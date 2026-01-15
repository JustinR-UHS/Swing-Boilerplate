
package controllers;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import models.Hotdog;
import views.Hotdog_Panel;

//A class that will track a list of hotdog orders
public class Hotdog_Controller {

    ArrayList<Hotdog> hotdogOrders;
    private final Hotdog_Panel view;
    private Hotdog currentOrder;
    private boolean isResetting = false;

    public Hotdog_Controller() {
        hotdogOrders = new ArrayList<>();
        view = new Hotdog_Panel(this);
    }

    public Hotdog_Panel getView() {
        return view;
    }

    public void newOrderListener(JButton btnStart) {
        btnStart.addActionListener(e -> {
            currentOrder = new Hotdog();
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
            hotdogOrders.add(currentOrder);
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



