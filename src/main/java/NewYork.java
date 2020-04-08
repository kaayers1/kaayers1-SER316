package main.java;

/*
File: New York
Author:	Kevin Ayers
Date: 04/07/20

Description: Child class New York extends State
*/

/**
Class: NewYork

Description: State object to represent New York contains tax rate attribute
*/



public class NewYork extends State {
	
	/**
	Method: NewYork
	Inputs: None
	Returns: None

	Description: Constructor
	*/
	
	public NewYork() {
		super(.1);
	}
	
	public double getRate() {
		return super.getRate();
	}
	
	public void setRate(double rate) {
		
		super.setRate(rate);
	}

}
