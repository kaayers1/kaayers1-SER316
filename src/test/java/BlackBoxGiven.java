package test.java;

import main.java.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import main.java.Cart;
import main.java.Cart1;
import main.java.Cart2;
import main.java.Cart3;
import main.java.Cart4;
import main.java.Cart5;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BlackBoxGiven {

    private Class<Cart> classUnderTest;

    @SuppressWarnings("unchecked")
    public BlackBoxGiven(Object classUnderTest) {
        this.classUnderTest = (Class<Cart>) classUnderTest;
    }

    // Define all classes to be tested
    @Parameterized.Parameters
    public static Collection<Object[]> cartClassUnderTest() {
        Object[][] classes = {
            {Cart0.class},
            {Cart1.class},
            {Cart2.class},
            {Cart3.class},
            {Cart4.class},
            {Cart5.class}
        };
        return Arrays.asList(classes);
    }

    private Cart createCart(int age) throws Exception {
        Constructor<Cart> constructor = classUnderTest.getConstructor(Integer.TYPE);
        return constructor.newInstance(age);
    }

    // A sample Cart

    Cart cart1;
    Cart cartDairy1;
    Cart cartDairy5;
    Cart cartDairy10;
    Cart cartDairy100;
    double cart1Expected;
    double cartDairy1Expected; 
    double cartDairy5Expected;
    double cartDairy10Expected; 
    double cartDairy100Expected; 
    
    Cart cartMeat1;
    Cart cartMeat5;
    Cart cartMeat10;
    Cart cartMeat100;
    double cartMeat1Expected;
    double cartMeat5Expected;
    double cartMeat10Expected;
    double cartMeat100Expected;
    
    Cart cartProduce1;
    Cart cartProduce5;
    Cart cartProduce10;
    Cart cartProduce100;
    Cart cartProduce3;
    double cartProduce1Expected;
    double cartProduce5Expected;
    double cartProduce10Expected;
    double cartProduce100Expected;
    double cartProduce3Expected;
    
    Cart cartAlcohol1;
    Cart cartAlcohol5;
    Cart cartAlcohol10;
    Cart cartAlcohol100;
    double cartAlcohol1Expected;
    double cartAlcohol5Expected;
    double cartAlcohol10Expected;
    double cartAlcohol100Expected;
    
    Cart cartFrozenFood1;
    Cart cartFrozenFood5;
    Cart cartFrozenFood10;
    Cart cartFrozenFood100;
    double cartFrozenFood1Expected;
    double cartFrozenFood5Expected;
    double cartFrozenFood10Expected;
    double cartFrozenFood100Expected;
    
 
    Cart cartAlcFrozen2;
    double cartAlcFrozenExpected2; 
    
    Cart mixedCartNoDisc;
    double mixedCartNoDiscExpected;
    
    Cart mixedCartDiscType1;
    double mixedCartDiscType1Expected;
    
    Cart mixedCartDiscType2;
    double mixedCartDiscType2Expected;
    
    Cart mixedCartDiscTwoTypes;
    double mixedCartTwoTypesExpected;
    
    
   
    
    
    


    @org.junit.Before
    public void setUp() throws Exception {

        // all carts should be set up like this

        // cart created with an age 40 shopper
        cart1 = createCart(40);
        for (int i = 0; i < 2; i++) {
            cart1.addItem(new Alcohol());
        }
        for(int i = 0; i < 3; i++) {
            cart1.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            cart1.addItem(new Meat());
        }

        cart1Expected = 70.2;
        
        cartDairy1 = createCart(30);
        for (int i = 0; i< 1; i++) {
        	cartDairy1.addItem(new Dairy());
        }
        cartDairy1Expected = 3.24;
        
        cartDairy5 = createCart(30);
        for (int i = 0; i< 5; i++) {
        	cartDairy5.addItem(new Dairy());
        }
        cartDairy5Expected = 16.2;
        
        cartDairy10 = createCart(30);
        for (int i = 0; i< 10; i++) {
        	cartDairy10.addItem(new Dairy());
        }
        cartDairy10Expected = 32.4;
        
        cartDairy100 = createCart(30);
        for (int i = 0; i< 100; i++) {
        	cartDairy100.addItem(new Dairy());
        }
        cartDairy100Expected = 324;
        
        cartMeat1 = createCart(30);
        for (int i =0; i < 1; i++) {
        	cartMeat1.addItem(new Meat());
        }
        cartMeat1Expected = 10.80; 
        
        cartMeat5 = createCart(30);
        for (int i =0; i < 5; i++) {
        	cartMeat5.addItem(new Meat());
        }
        
        cartMeat5Expected = 54.0; 
       
        cartMeat10 = createCart(30);
        for (int i =0; i < 10; i++) {
        	cartMeat10.addItem(new Meat());
        }
        
        cartMeat10Expected = 108; 
        
        cartMeat100 = createCart(30);
        for (int i =0; i < 100; i++) {
        	cartMeat100.addItem(new Meat());
        }
        
        cartMeat100Expected = 1080.0; 
        
        cartProduce1 = createCart(30);
        for (int i =0; i < 1; i++) {
        	cartProduce1.addItem(new Produce());
        }
        
        cartProduce1Expected = 2.16;
        
        cartProduce5 = createCart(30);
        for (int i =0; i < 5; i++) {
        	cartProduce5.addItem(new Produce());
        }
        
        cartProduce5Expected = 9.72;
        

        cartProduce10 = createCart(30);
        for (int i =0; i < 10; i++) {
        	cartProduce10.addItem(new Produce());
        }
        
        cartProduce10Expected = 18.36;
        
        cartProduce100 = createCart(30);
        for (int i =0; i < 100; i++) {
        	cartProduce100.addItem(new Produce());
        }
        
        cartProduce100Expected = 180.36;
        
        cartProduce3= createCart(30);
        for (int i = 0; i < 3; i++) {
        	cartProduce3.addItem(new Produce());
        }
        
        cartProduce3Expected = 5.40;
        
        
        cartAlcohol1 = createCart(30);
        for (int i = 0; i < 1; i++) {
        	cartAlcohol1.addItem(new Alcohol());
        }
        
        cartAlcohol1Expected = 8.64;
        
        cartAlcohol5 = createCart(30);
        for (int i = 0; i < 5; i++) {
        	cartAlcohol5.addItem(new Alcohol());
        }
        
        cartAlcohol5Expected = 43.2;
        
        cartAlcohol10 = createCart(30);
        for (int i = 0; i < 10; i++) {
        	cartAlcohol10.addItem(new Alcohol());
        }
        
        cartAlcohol10Expected = 86.4;
        
        cartAlcohol100 = createCart(30);
        for (int i = 0; i < 100; i++) {
        	cartAlcohol100.addItem(new Alcohol());
        }
        
        cartAlcohol100Expected = 864;
        
        cartFrozenFood1 = createCart(30);
        for (int i = 0; i < 1; i++) {
        	cartFrozenFood1.addItem(new FrozenFood());
        }
        
        cartFrozenFood1Expected = 5.4; 
        
        cartFrozenFood5 = createCart(30);
        for (int i = 0; i < 5; i++) {
        	cartFrozenFood5.addItem(new FrozenFood());
        }
        
        cartFrozenFood5Expected = 27; 
        
        cartFrozenFood10 = createCart(30);
        for (int i = 0; i < 10; i++) {
        	cartFrozenFood10.addItem(new FrozenFood());
        }
        
        cartFrozenFood10Expected = 54; 
        
        cartFrozenFood100 = createCart(30);
        for (int i = 0; i < 100; i++) {
        	cartFrozenFood100.addItem(new FrozenFood());
        }
        
        cartFrozenFood100Expected = 540; 
        
        
        cartAlcFrozen2 = createCart(30);
        for (int i =0; i < 2; i++) {
        	cartAlcFrozen2.addItem(new Alcohol());
        	cartAlcFrozen2.addItem(new FrozenFood());; 
        }
        
       cartAlcFrozenExpected2 = 21.6; 
       
       mixedCartNoDisc = createCart(30);
       for (int i =0; i< 1; i++) {
    	   mixedCartNoDisc.addItem(new Meat());
    	   mixedCartNoDisc.addItem(new Dairy());
    	   mixedCartNoDisc.addItem(new FrozenFood());
       }
       mixedCartNoDiscExpected = 19.44;
       
       mixedCartDiscType1 = createCart(30);
       for (int i = 0; i < 1; i++) {
    	   mixedCartDiscType1.addItem(new Dairy());
    	   mixedCartDiscType1.addItem(new Meat());
    	   mixedCartDiscType1.addItem(new Produce());
    	   mixedCartDiscType1.addItem(new Produce());;
    	   mixedCartDiscType1.addItem(new Produce());;
    	   
       }
       
       mixedCartDiscType1Expected = 19.44; 
       
       mixedCartDiscType2 = createCart(30);
       for (int i = 0; i< 1; i++) {
    	   mixedCartDiscType2.addItem(new Alcohol());
    	   mixedCartDiscType2.addItem(new FrozenFood());
    	   mixedCartDiscType2.addItem(new Dairy());
    	   mixedCartDiscType2.addItem(new Meat());
    	   
       }
       
       mixedCartDiscType2Expected = 24.84; 
       
       mixedCartDiscTwoTypes = createCart(30);
       for (int i = 0; i<1; i++) {
    	   mixedCartDiscTwoTypes.addItem(new Dairy());
    	   mixedCartDiscTwoTypes.addItem(new Produce());
    	   mixedCartDiscTwoTypes.addItem(new Produce());
    	   mixedCartDiscTwoTypes.addItem(new Produce());
    	   mixedCartDiscTwoTypes.addItem(new Meat());
    	   mixedCartDiscTwoTypes.addItem(new FrozenFood());
    	   mixedCartDiscTwoTypes.addItem(new Alcohol());

       }
       mixedCartTwoTypesExpected = 30.24; 
       
       
       
        
        
    }

    // sample test
    @Test
    public void calcCostCart1() throws UnderAgeException {
        double amount = cart1.calcCost();
        assertEquals(cart1Expected, amount, .01);
    }
    
    @Test
    public void calcCostCartDairy1() throws UnderAgeException {
    	double amount = cartDairy1.calcCost();
    	assertEquals(cartDairy1Expected, amount, .01); 
    	
    }
    
    @Test
    public void calcCostCartDairy5() throws UnderAgeException {
    	double amount = cartDairy5.calcCost();
    	assertEquals(cartDairy5Expected, amount, .01); 
    	
    }
    
    @Test
    public void calcCostCartDairy10() throws UnderAgeException {
    	double amount = cartDairy10.calcCost();
    	assertEquals(cartDairy10Expected, amount, .01); 
    	
    }
    
    @Test
    public void calcCostCartDairy100() throws UnderAgeException {
    	double amount = cartDairy100.calcCost();
    	assertEquals(cartDairy100Expected, amount, .01); 
    	
    }
    
    @Test
    public void calcCostCartMeat1() throws UnderAgeException{
    	double amount = cartMeat1.calcCost();
    	assertEquals(cartMeat1Expected, amount, .01);
    }
    
    @Test
    public void calcCostCartMeat5() throws UnderAgeException{
    	double amount = cartMeat5.calcCost();
    	assertEquals(cartMeat5Expected, amount, .01);
    }
    
    @Test
    public void calcCostCartMeat10() throws UnderAgeException{
    	double amount = cartMeat10.calcCost();
    	assertEquals(cartMeat10Expected, amount, .01);
    }
    
    @Test
    public void calcCostCartMeat100() throws UnderAgeException{
    	double amount = cartMeat100.calcCost();
    	assertEquals(cartMeat100Expected, amount, .01);
    } 
    
    @Test
    public void calcCostCartProduce1() throws UnderAgeException {
    	double amount = cartProduce1.calcCost();
    	assertEquals(cartProduce1Expected, amount, .01);
    }
    
    @Test
    public void calcCostCartProduce5() throws UnderAgeException {
    	double amount = cartProduce5.calcCost();
    	assertEquals(cartProduce5Expected, amount, .01);
    }
    
    @Test
    public void calcCostCartProduce10() throws UnderAgeException {
    	double amount = cartProduce10.calcCost();
    	assertEquals(cartProduce10Expected, amount, .01);
    }
    
    @Test
    public void calcCostCartProduce100() throws UnderAgeException {
    	double amount = cartProduce100.calcCost();
    	assertEquals(cartProduce100Expected, amount, .01);
    }
    
    @Test
    public void calcCostCartProduce3() throws UnderAgeException {
    	double amount = cartProduce3.calcCost();
    	assertEquals(cartProduce3Expected, amount, .01);
    }
    
    @Test
    public void calcCostCartAlcohol1() throws UnderAgeException {
    	double amount = cartAlcohol1.calcCost();
    	assertEquals(cartAlcohol1Expected, amount, .01);
    	
    }
    
    @Test
    public void calcCostCartAlcohol5() throws UnderAgeException {
    	double amount = cartAlcohol5.calcCost();
    	assertEquals(cartAlcohol5Expected, amount, .01);
    	
    }
    
    @Test
    public void calcCostCartAlcohol10() throws UnderAgeException {
    	double amount = cartAlcohol10.calcCost();
    	assertEquals(cartAlcohol10Expected, amount, .01);
    	
    }
    
    @Test
    public void calcCostCartAlcohol100() throws UnderAgeException {
    	double amount = cartAlcohol100.calcCost();
    	assertEquals(cartAlcohol100Expected, amount, .01);
    	
    }
    
    @Test
    public void calcCostFrozenFood1() throws UnderAgeException {
    	double amount = cartFrozenFood1.calcCost();
    	assertEquals(cartFrozenFood1Expected, amount, .01);
    }
    

    @Test
    public void calcCostFrozenFood5() throws UnderAgeException {
    	double amount = cartFrozenFood5.calcCost();
    	assertEquals(cartFrozenFood5Expected, amount, .01);
    }
    
    @Test
    public void calcCostFrozenFood10() throws UnderAgeException {
    	double amount = cartFrozenFood10.calcCost();
    	assertEquals(cartFrozenFood10Expected, amount, .01);
    }
    

    @Test
    public void calcCostFrozenFood100() throws UnderAgeException {
    	double amount = cartFrozenFood100.calcCost();
    	assertEquals(cartFrozenFood100Expected, amount, .01);
    }
    
    @Test
    public void calcCostAlcFrozen2() throws UnderAgeException {
    	double amount = cartAlcFrozen2.calcCost();
    	assertEquals(cartAlcFrozenExpected2, amount, .01); 
    }
    
    @Test
    public void calcCostMixedCartNoDisc() throws UnderAgeException {
    	double amount = mixedCartNoDisc.calcCost();
    	assertEquals(mixedCartNoDiscExpected, amount, .01);
    }
    
    @Test
    public void calcCostMixedCartDiscType1() throws UnderAgeException {
    	double amount = mixedCartDiscType1.calcCost();
    	assertEquals(mixedCartDiscType1Expected, amount, .01);
    }
    
    @Test
    public void calcCostMixedCartDiscType2() throws UnderAgeException {
    	double amount = mixedCartDiscType2.calcCost();
    	assertEquals(mixedCartDiscType2Expected, amount, .01);
    }
    
    @Test
    public void calcCostMixedCartTwoTypes() throws UnderAgeException {
    	double amount = mixedCartDiscTwoTypes.calcCost();
    	assertEquals(mixedCartTwoTypesExpected, amount, .01); 
    }
    
    
    
    
    
    
    
    
    
}