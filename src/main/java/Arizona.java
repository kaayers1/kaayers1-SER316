package main.java;

/*
File: Arizona
Author:	Kevin Ayers
Date: 04/06/20	

Description: Child  class Arizona extends state
*/

/**
Class: Arizona

Description: State object to represent Arizona, contains tax rate attribute
*/

public class Arizona extends State {
	
	/**
	  Method: Arizona
	  Inputs: None
	  Returns: None 

	  Description: Constructor sets tax rate for super 
	*/
	
	public Arizona() {
		super(.08); 
	}
	
	public double getRate() {
		return super.getRate();
	}
	
	public void setRate(double rate){
		super.setRate(rate);
	}

}
