package main.java;

/*
File: Colorado
Author:	Kevin Ayers
Date: 04/06/20	

Description: Child class Colorado extends state
 */

/**
Class: Colorado

Description: State object to represent Colorado contains tax rate
 */

public class Colorado extends State {

    /**
	  Method: Colorado Constructor
	  Inputs: None
	  Returns: None 

	  Description: Constructs Colorado class with .07 percent tax rate
     */

    public Colorado() {
        super(.07);
    }

    public double getRate() {
        return super.getRate();
    }

    public void setRate(double rate) {
        super.setRate(rate);

    }


}
