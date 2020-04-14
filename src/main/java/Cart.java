package main.java;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    protected int userAge;
    public List<Product> cart;
    public int cartStorage;

    /**
     * Calculates the final cost after all savings and tax has been applied. Also
     * checks that the user is of age to purchase alcohol if it is in their cart at
     * checkout. Sales tax is always AZ tax.
     * 
     * <p>Calculation is based off of the following prices and deals: 
     * Dairy -> $3 
     * Meat
     * -> $10 Produce -> $2 or 3 for $5 Alcohol -> $8 Frozen Food -> $5 Alcohol +
     * Frozen Food -> $10
     *
     * <p>If there is an alcohol product in the cart and the user is under 21, then an
     * UnderAgeException should be thrown.
     *
     * @return double totalCost
     * @throws UnderAgeException occurs when someone under the age of 21 attempts to buy alcohol 
     */
    public double calcCost() throws UnderAgeException {
        int subTotal = 0;
      

        int produceCount = 0;
        int produceDiscount;
        int alcoholCount = 0;
        int frozenCount = 0;
        int comboDiscount = 0;

        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getClass() == Dairy.class) {
                subTotal += 3;
            } else if (cart.get(i).getClass() == Meat.class) {
                subTotal += 10;
            } else if (cart.get(i).getClass() == Produce.class) {
                subTotal += 2;
                produceCount++;
            } else if (cart.get(i).getClass() == Alcohol.class) {
                subTotal += 8;
                alcoholCount++;
            } else if (cart.get(i).getClass() == FrozenFood.class) {
                subTotal += 5;
                frozenCount++;
            }
        }

        if (userAge < 21 && alcoholCount > 0) {
            throw new UnderAgeException("This buyer is under age!");
        }

        produceDiscount = produceCount / 3; 
        if (frozenCount != 0 && alcoholCount != 0) { 
            comboDiscount = ((alcoholCount + frozenCount) / 2) * 3; 
        }


        subTotal = subTotal - produceDiscount; 
        
        subTotal = subTotal - comboDiscount;
        
        double tax = subTotal * .08;

        double total = subTotal + tax;


        return total;
    }
    


    
    
    /**
    Method: None
    Inputs: None
    Returns: int
    Description: Throws underAgeException when someone under the age 
    * of 21 attempts to purchase alcohol. 
    */
    public int amountSaved() throws UnderAgeException {
        int produceCount = 0;
        int alcoholCount = 0;
        int frozenCount = 0;

        int produceDiscount = 0;
        int comboDiscount = 0;

        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getClass() == Produce.class) {
                produceCount++;
            } else if (cart.get(i).getClass() == Alcohol.class) {	
                alcoholCount++;
            } else if (cart.get(i).getClass() == FrozenFood.class) {
                frozenCount++;
            }
        }

        if (userAge < 21 && alcoholCount > 0) {
            throw new UnderAgeException("This buyer is under age!");
        }


        produceDiscount = produceCount / 3; 
        if(frozenCount != 0 && alcoholCount != 0) { 
            comboDiscount = ((alcoholCount + frozenCount) / 2) * 3; 
        }







        return (produceDiscount + comboDiscount);
    }

  
    /**
     * 
     * @param totalBt
     * @param twoLetterStateAbbreviation
     * @return Amount of tax for chosen state
     */
    public double getTax(double totalBt, String twoLetterStateAbbreviation) {
        double newTotal = 0;
        switch (twoLetterStateAbbreviation) {
        case "AZ":
              newTotal = totalBt * .08;
              break;
        case "CA":
              newTotal = totalBt * .09;
              break;
        case "NY":
              newTotal = totalBt * .1;
              break;
        case "CO":
              newTotal = totalBt * .07;
              break;
        default:
              return totalBt;
        }
        return newTotal;
    }

    public void addItem(Product np) {
        cart.add(np);
    }

    //changed to .getClass to make it function correctly 
    public boolean RemoveItem(Product productToRemove) {
        boolean test = false;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getClass() == productToRemove.getClass()) {
                cart.remove(i);
                test = true;
                return test;
            }
        }
        return false;
    }

    public Cart(int age) {
        userAge = age;
        cart = new ArrayList<Product>();
    }


}
