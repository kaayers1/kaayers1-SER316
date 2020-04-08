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
	 * Calculation is based off of the following prices and deals: Dairy -> $3 Meat
	 * -> $10 Produce -> $2 or 3 for $5 Alcohol -> $8 Frozen Food -> $5 Alcohol +
	 * Frozen Food -> $10
	 *
	 * If there is an alcohol product in the cart and the user is under 21, then an
	 * UnderAgeException should be thrown.
	 *
	 * @return double totalCost
	 * @throws UnderAgeException
	 */
	public double calcCost() throws UnderAgeException {
		int subTotal = 0;
		double total;
		double tax;

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
		
		if(userAge < 21 && alcoholCount > 0) {
			throw new UnderAgeException("This buyer is under age!");
		}else {
			
		}

	
		produceDiscount = produceCount/3; 
		if(frozenCount != 0 && alcoholCount != 0) { 
		comboDiscount = ((alcoholCount+frozenCount)/2) * 3; 
		}
		 
		 
		subTotal = subTotal - produceDiscount; subTotal = subTotal - comboDiscount;
		tax = subTotal * .08;
		 
		total = subTotal + tax;
		 

		return total;
	}

	// calculates how much was saved in the current shopping cart based on the
	// deals, returns the saved amount
	// throws exception if alcohol is bought from under age person
	// TODO: Create node graph for this method in assign 4: create white box tests
	// and fix the method, reach at least 98% coverage
	public int Amount_saved() throws UnderAgeException {
		int subTotal = 0;
		int costAfterSavings = 0;

		double produce_counter = 0;
		int alcoholCounter = 0;
		int frozenFoodCounter = 0;
		int dairyCounter = 0;

		for (int i = 0; i < cart.size(); i++) {
			subTotal += cart.get(i).getCost();
			costAfterSavings = costAfterSavings + cart.get(i).getCost();

			if (cart.get(i).getClass().toString() == Produce.class.toString()) {
				produce_counter++;

				if (produce_counter >= 3) {
					costAfterSavings -= 1;
					produce_counter = 0;
				}
			} else if (cart.get(i).getClass().toString() == Alcohol.class.toString()) {
				alcoholCounter++;
				if (userAge < 21) {
					throw new UnderAgeException("The User is not of age to purchase alcohol!");
				}
			} else if (cart.get(i).getClass().toString() == FrozenFood.class.toString()) {
				frozenFoodCounter++;
			}

			if (alcoholCounter >= 1 && frozenFoodCounter >= 1) {
				costAfterSavings = costAfterSavings + 3;
				alcoholCounter--;
				frozenFoodCounter--;
			}
		}

		return subTotal - costAfterSavings;
	}

	// Gets the tax based on state and the total
	public double getTax(double totalBT, String twoLetterUSStateAbbreviation) {
		double newTotal = 0;
		switch (twoLetterUSStateAbbreviation) {
		case "AZ":
			newTotal = totalBT * .08;
			break;
		case "CA":
			newTotal = totalBT * .09;
			break;
		case "NY":
			newTotal = totalBT * .1;
		case "CO":
			newTotal = totalBT * .07;
			break;
		default:
			return totalBT;
		}
		return newTotal;
	}

	public void addItem(Product np) {
		cart.add(np);
	}

	public boolean RemoveItem(Product productToRemove) {
		boolean test = false;
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i) == productToRemove) {
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
