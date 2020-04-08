package main.java;

/*
File: California	
Author:	Kevin Ayers
Date: 4/7/20	

Description: Child class California extends state
*/

/**
Class: California

Description: State object to represent California contains tax rate attribute
*/

public class California extends State {
	
	/**
	  Method: California
	  Inputs: None	
	  Returns: None

	  Description: Constructor
	*/
	
	public California() {
		super(.09);
	}
	
	public double getRate() {
		return super.getRate(); 
	}
	
	public void setRate(double rate) {
		super.setRate(rate);
	}

}
