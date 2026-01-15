
package models;
import java.util.Arrays;
import java.util.ArrayList;

//A class that defines a hamburger and it's toppings
//Provides methods for manipulating toppings, calculating the price, and getting the description
public class Drinks {
    //Static final variables make it easy to control data that may change once in a while in many places in the program
    public static final String[] SIZE_CHOICES = {"Small", "Medium", "Large"};
    public static final String[] DRINK_CHOICES = {"Lemonade", "Iced tea", "Coke", "Pepsi", "Root beer"};
    private static final double DRINK_COST = 1.99;
    private static final double SMALL_COST = 0.99;
    private static final double MEDIUM_COST = 1.99;
    private static final double LARGE_COST = 2.99;
    
    private String drinkChoice;
    private String sizeChoice;
    
    public Drinks() {
        drinkChoice = new String();
        sizeChoice = new String();
    }
    
    
    public String get_drink() {
        return drinkChoice;
    }
    
    public String get_size() {
        return sizeChoice;
    }
    
    
    public void drink_choice(String drink) {
        if (isAvailable(drinkChoice) && !this.drinkChoice.contains(drink)) {
            this.drinkChoice = drink;
        }
    }

    public void size_choice(String size) {
        if (isAvailable(sizeChoice) && !this.sizeChoice.contains(size)) {
            this.sizeChoice = size;
        }
    }
    
    
    private boolean isAvailable(String check) {
      if (Arrays.asList(DRINK_CHOICES).contains(check)) {
        for (String a : DRINK_CHOICES) {
            if (a.equals(check)) {
                return true;
            }
        }
      } else if (Arrays.asList(SIZE_CHOICES).contains(check)) {
          for (String b : SIZE_CHOICES) {
              if (b.equals(check)) {
                  return true;
              }
          }
        }
        return false;
    }
    
    
    public double get_price() {
        double cost = DRINK_COST;
        switch(this.sizeChoice) {
            case "Small":
                cost += SMALL_COST;
                break;
            case "Medium":
                cost += MEDIUM_COST;
                break;
            case "Large":
                cost += LARGE_COST;
                break;
            default:
                break;
        }
        return cost;
    }
    
    
    public double get_tax(double price) {
        return price * 0.08;
    }
    
    
    public double get_price_with_tax() {
        double price = get_price();
        return (price + get_tax(price));
    }
    
    
    @Override
    public String toString() {
        String output = "A hamburger with ";
        for (int i = 0; i < toppings.size() - 1; i++) {
            output += toppings.get(i).toLowerCase() + ", ";
        }
        if (toppings.size() > 1) {
            output += "and ";
        }
        output += toppings.get(toppings.size() - 1).toLowerCase();
        output = output.substring(0, output.length());
        output += " on a sesame seed bun";
        return output;
    }
}