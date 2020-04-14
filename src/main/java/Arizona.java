package main.java;


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