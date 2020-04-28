
package main.java;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    protected int userAge;
    public List<Product> cart;
    private int dairyCount;
    private int meatCount;
    private int produceCount;
    private int alcoholCount;
    private int frozenCount;
    
    //SER316 TASK 2 SPOT-BUGS FIX


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
        this.countItems();
        int beforeTax;

        beforeTax = this.subTotal() - this.amountSaved();

        double tax = beforeTax * .08;

        double afterTax = beforeTax + tax;

        return afterTax;
    }
    
    
    public int subTotal() {
        int subTotal = 0;
        subTotal += dairyCount * 3; 
        subTotal += meatCount * 10;
        subTotal += produceCount * 2;
        subTotal += alcoholCount * 8;
        subTotal += frozenCount * 5; 
     
        return subTotal;    
    }
    
    public void countItems(){
        dairyCount = 0;
        meatCount = 0;
        produceCount = 0;
        alcoholCount = 0;
        frozenCount = 0;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getClass() == Dairy.class) {
                dairyCount ++;
            } else if (cart.get(i).getClass() == Meat.class) {
                meatCount ++;
            } else if (cart.get(i).getClass() == Produce.class) {
                produceCount ++;
            } else if (cart.get(i).getClass() == Alcohol.class) {
                alcoholCount ++;
            } else if (cart.get(i).getClass() == FrozenFood.class) {
                frozenCount ++;
            }
        } 
    }
    
    public void underAgeCheck() throws UnderAgeException {
        if (userAge < 21 && alcoholCount > 0) {
            throw new UnderAgeException("This buyer is under age!");
        }  
    }
    
   

    public int amountSaved() throws UnderAgeException {
        this.countItems();
        int produceDiscount = 0;
        int comboDiscount = 0;
        this.underAgeCheck();
        produceDiscount = produceCount / 3; 
        if (frozenCount != 0 && alcoholCount != 0) { 
            comboDiscount = ((alcoholCount + frozenCount) / 2) * 3; 
        }
        return (produceDiscount + comboDiscount);
    }


    /**
     * 
     * @param totalBt total price before tax 
     * @param twoLetterStateAbbreviation State abrev
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

    //SER316 TASK 2 SPOT-BUGS FIX
    //changed to .getClass to make it function correctly 
    public boolean removeItem(Product productToRemove) {
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
