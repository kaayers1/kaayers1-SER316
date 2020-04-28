package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.*; 

public class CartTest {


    Cart nodeCoverage1;
    Cart nodeCoverage2;
    Cart pathCoverage1;
    Cart pathCoverage2;
    Cart pathCoverage3;
    Cart pathCoverage4;
    Cart pathCoverage5;
    Cart pathCoverage6;
    Cart pathCoverage7;
    Cart pathCoverage8; 


    Cart taxTestCA;
    Cart taxTestCO;
    Cart taxTestNY; 



    /////////////////////////////////////////////////



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



    ///////////////////////////////////

    Cart cartAlcohol1UnderAge;
    Cart cartAlcohol5UnderAge;
    Cart cartAlcohol10UnderAge;
    Cart cartAlcohol100UnderAge;

    Cart cartAlcohol121;
    Cart cartAlcohol521;
    Cart cartAlcohol1021;
    Cart cartAlcohol10021;
    double cartAlcohol1Expected21;
    double cartAlcohol5Expected21;
    double cartAlcohol10Expected21;
    double cartAlcohol100Expected21;

    Cart cartEmpty;
    double cartEmptyExpected; 

    Cart cartEmpty21;
    double cartEmpty21Expected;

    Cart cartEmptyUnderAge;
    double cartEmptyUnderAgeExpected;

    //edger cases
    Cart edgeCaseAge20;


    Cart edgeCaseAge22;


    Cart edgeCaseProduce1;
    double edgeCaseProduce1Expected;

    Cart edgeCaseProduce2;
    double edgeCaseProduce2Expected;

    Cart edgeCaseAlcFroz1;
    double edgeCaseAlcFroz1Expected;

    Cart edgeCaseNoAlc1;
    double edgeCaseNoAlc1Expected;

    Cart edgeCaseNoAlc2;
    double edgeCaseNoAlc2Expected;

    Cart edgeCaseNoAlc3;
    double edgeCaseNoAlc3Expected; 


    private Cart createCart(int age) throws Exception {
        return new Cart(age); 
    }


    @Before
    public void setUp() throws Exception {

        //Cart must have several items including more than 3 produce 
        //and multiple alcohol and frozen food items.
        nodeCoverage1 = new Cart(30);

        for(int i = 0; i < 2; i++) {
            nodeCoverage1.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            nodeCoverage1.addItem(new Produce());
        }
        for(int i = 0; i< 3; i++) {
            nodeCoverage1.addItem(new Alcohol());
        }
        for(int i = 0; i< 3; i++) {
            nodeCoverage1.addItem(new FrozenFood());
        }

        //same as node coverage 1 but under age

        nodeCoverage2 = new Cart(15); 

        for(int i = 0; i < 2; i++) {
            nodeCoverage2.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            nodeCoverage2.addItem(new Produce());
        }
        for(int i = 0; i< 3; i++) {
            nodeCoverage2.addItem(new Alcohol());
        }
        for(int i = 0; i< 3; i++) {
            nodeCoverage2.addItem(new FrozenFood());
        }

        //mult items in the cart no alc, no frozen, no produce 

        pathCoverage1 = new Cart(30);

        for(int i = 0; i < 2; i++) {
            pathCoverage1.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            pathCoverage1.addItem(new Meat());
        }

        //mult items in cart, 1 produce, no alc no frozen food
        pathCoverage2 = new Cart(30);
        pathCoverage2.addItem(new Produce());

        for(int i = 0; i < 2; i++) {
            pathCoverage2.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            pathCoverage2.addItem(new Meat());
        }

        //Multiple items 6 produce, no alcohol, no frozen food

        pathCoverage3 = new Cart(30);

        for(int i = 0; i < 2; i++) {
            pathCoverage3.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            pathCoverage3.addItem(new Meat());
        }

        for(int i = 0; i < 6; i++) {
            pathCoverage3.addItem(new Produce());
        }

        //Multiple items no produce, 2 alcohol, no frozen food

        pathCoverage4 = new Cart(30);
        for(int i = 0; i< 2;i++) {
            pathCoverage4.addItem(new Alcohol());
        }
        for(int i = 0; i < 2; i++) {
            pathCoverage4.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            pathCoverage4.addItem(new Meat());
        }

        //Multiple items no produce 2 alcohol, no frozen food under age
        pathCoverage5 = new Cart(15);
        for(int i = 0; i< 2;i++) {
            pathCoverage5.addItem(new Alcohol());
        }
        for(int i = 0; i < 2; i++) {
            pathCoverage5.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            pathCoverage5.addItem(new Meat());
        }

        //Multiple items no produce, no alcohol, 2 frozen food.

        pathCoverage6 = new Cart(30);

        for(int i = 0; i< 2;i++) {
            pathCoverage6.addItem(new FrozenFood());
        }
        for(int i = 0; i < 2; i++) {
            pathCoverage6.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            pathCoverage6.addItem(new Meat());
        }

        //Multiple items no produce , 2 alchohol, 2 frozen food. 
        pathCoverage7 = new Cart(30);

        for(int i = 0; i< 2;i++) {
            pathCoverage7.addItem(new FrozenFood());
        }
        for(int i = 0; i < 2; i++) {
            pathCoverage7.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            pathCoverage7.addItem(new Meat());
        }
        for(int i = 0; i< 2;i++) {
            pathCoverage7.addItem(new Alcohol());
        }

        //mult items under age no alcohol
        pathCoverage8 = new Cart(15);

        for(int i = 0; i < 2; i++) {
            pathCoverage8.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            pathCoverage8.addItem(new Produce());
        }

        for(int i = 0; i< 3; i++) {
            pathCoverage8.addItem(new FrozenFood());
        }


        //Testing getTax
        taxTestCA = new Cart(30);
        taxTestNY = new Cart(30);
        taxTestCO = new Cart(30);


        ////////////////////////////////////////////////////////////

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

        cartDairy1 = createCart(21);
        for (int i = 0; i< 1; i++) {
            cartDairy1.addItem(new Dairy());
        }
        cartDairy1Expected = 3.24;

        cartDairy5 = createCart(21);
        for (int i = 0; i< 5; i++) {
            cartDairy5.addItem(new Dairy());
        }
        cartDairy5Expected = 16.2;

        cartDairy10 = createCart(21);
        for (int i = 0; i< 10; i++) {
            cartDairy10.addItem(new Dairy());
        }
        cartDairy10Expected = 32.4;

        cartDairy100 = createCart(21);
        for (int i = 0; i< 100; i++) {
            cartDairy100.addItem(new Dairy());
        }
        cartDairy100Expected = 324;

        cartMeat1 = createCart(21);
        for (int i =0; i < 1; i++) {
            cartMeat1.addItem(new Meat());
        }
        cartMeat1Expected = 10.80; 

        cartMeat5 = createCart(21);
        for (int i =0; i < 5; i++) {
            cartMeat5.addItem(new Meat());
        }

        cartMeat5Expected = 54.0; 

        cartMeat10 = createCart(21);
        for (int i =0; i < 10; i++) {
            cartMeat10.addItem(new Meat());
        }

        cartMeat10Expected = 108; 

        cartMeat100 = createCart(21);
        for (int i =0; i < 100; i++) {
            cartMeat100.addItem(new Meat());
        }

        cartMeat100Expected = 1080.0; 

        cartProduce1 = createCart(21);
        for (int i =0; i < 1; i++) {
            cartProduce1.addItem(new Produce());
        }

        cartProduce1Expected = 2.16;

        cartProduce5 = createCart(21);
        for (int i =0; i < 5; i++) {
            cartProduce5.addItem(new Produce());
        }

        cartProduce5Expected = 9.72;


        cartProduce10 = createCart(21);
        for (int i =0; i < 10; i++) {
            cartProduce10.addItem(new Produce());
        }

        cartProduce10Expected = 18.36;

        cartProduce100 = createCart(21);
        for (int i =0; i < 100; i++) {
            cartProduce100.addItem(new Produce());
        }

        cartProduce100Expected = 180.36;

        cartProduce3= createCart(21);
        for (int i = 0; i < 3; i++) {
            cartProduce3.addItem(new Produce());
        }

        cartProduce3Expected = 5.40;


        cartAlcohol1 = createCart(21);
        for (int i = 0; i < 1; i++) {
            cartAlcohol1.addItem(new Alcohol());
        }

        cartAlcohol1Expected = 8.64;

        cartAlcohol5 = createCart(21);
        for (int i = 0; i < 5; i++) {
            cartAlcohol5.addItem(new Alcohol());
        }

        cartAlcohol5Expected = 43.2;

        cartAlcohol10 = createCart(21);
        for (int i = 0; i < 10; i++) {
            cartAlcohol10.addItem(new Alcohol());
        }

        cartAlcohol10Expected = 86.4;

        cartAlcohol100 = createCart(21);
        for (int i = 0; i < 100; i++) {
            cartAlcohol100.addItem(new Alcohol());
        }

        cartAlcohol100Expected = 864;

        cartFrozenFood1 = createCart(21);
        for (int i = 0; i < 1; i++) {
            cartFrozenFood1.addItem(new FrozenFood());
        }

        cartFrozenFood1Expected = 5.4; 

        cartFrozenFood5 = createCart(21);
        for (int i = 0; i < 5; i++) {
            cartFrozenFood5.addItem(new FrozenFood());
        }

        cartFrozenFood5Expected = 27; 

        cartFrozenFood10 = createCart(21);
        for (int i = 0; i < 10; i++) {
            cartFrozenFood10.addItem(new FrozenFood());
        }

        cartFrozenFood10Expected = 54; 

        cartFrozenFood100 = createCart(21);
        for (int i = 0; i < 100; i++) {
            cartFrozenFood100.addItem(new FrozenFood());
        }

        cartFrozenFood100Expected = 540; 


        cartAlcFrozen2 = createCart(21);
        for (int i =0; i < 2; i++) {
            cartAlcFrozen2.addItem(new Alcohol());
            cartAlcFrozen2.addItem(new FrozenFood());; 
        }

        cartAlcFrozenExpected2 = 21.6; 

        mixedCartNoDisc = createCart(21);
        for (int i =0; i< 1; i++) {
            mixedCartNoDisc.addItem(new Meat());
            mixedCartNoDisc.addItem(new Dairy());
            mixedCartNoDisc.addItem(new FrozenFood());
        }
        mixedCartNoDiscExpected = 19.44;

        mixedCartDiscType1 = createCart(21);
        for (int i = 0; i < 1; i++) {
            mixedCartDiscType1.addItem(new Dairy());
            mixedCartDiscType1.addItem(new Meat());
            mixedCartDiscType1.addItem(new Produce());
            mixedCartDiscType1.addItem(new Produce());;
            mixedCartDiscType1.addItem(new Produce());;

        }

        mixedCartDiscType1Expected = 19.44; 


        mixedCartDiscType2 = createCart(21);
        for (int i = 0; i< 1; i++) {
            mixedCartDiscType2.addItem(new Alcohol());
            mixedCartDiscType2.addItem(new FrozenFood());
            mixedCartDiscType2.addItem(new Dairy());
            mixedCartDiscType2.addItem(new Meat());

        }

        mixedCartDiscType2Expected = 24.84; 


        mixedCartDiscTwoTypes = createCart(21);
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






        ////////////////////////////////////////

        cartAlcohol1UnderAge = createCart(15);
        for (int i = 0; i < 1; i++) {
            cartAlcohol1UnderAge.addItem(new Alcohol());
        }



        cartAlcohol5UnderAge = createCart(15);
        for (int i = 0; i < 5; i++) {
            cartAlcohol5UnderAge.addItem(new Alcohol());
        }



        cartAlcohol10UnderAge = createCart(15);
        for (int i = 0; i < 10; i++) {
            cartAlcohol10UnderAge.addItem(new Alcohol());
        }



        cartAlcohol100UnderAge = createCart(15);
        for (int i = 0; i < 100; i++) {
            cartAlcohol100UnderAge.addItem(new Alcohol());
        }


        /////////////////////////////////////////////

        cartAlcohol121 = createCart(30);
        for (int i = 0; i < 1; i++) {
            cartAlcohol121.addItem(new Alcohol());
        }

        cartAlcohol1Expected21 = 8.64;

        cartAlcohol521 = createCart(30);
        for (int i = 0; i < 5; i++) {
            cartAlcohol521.addItem(new Alcohol());
        }

        cartAlcohol5Expected21 = 43.2;

        cartAlcohol1021 = createCart(30);
        for (int i = 0; i < 10; i++) {
            cartAlcohol1021.addItem(new Alcohol());
        }

        cartAlcohol10Expected21 = 86.4;

        cartAlcohol10021 = createCart(30);
        for (int i = 0; i < 100; i++) {
            cartAlcohol10021.addItem(new Alcohol());
        }

        cartAlcohol100Expected21 = 864;

        cartEmpty = createCart(30);


        cartEmptyExpected = 0.0;

        cartEmpty21 = createCart(21);


        cartEmpty21Expected = 0.0; 

        cartEmptyUnderAge = createCart(15);

        cartEmptyUnderAgeExpected = 0.0; 

        //edgeCases

        edgeCaseAge20 = createCart(20);
        for (int i = 0; i < 2; i++) {
            edgeCaseAge20.addItem(new Alcohol());
        }
        for(int i = 0; i < 3; i++) {
            edgeCaseAge20.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            edgeCaseAge20.addItem(new Meat());
        }

        edgeCaseAge22 = createCart(22);
        for (int i = 0; i < 2; i++) {
            edgeCaseAge22.addItem(new Alcohol());
        }
        for(int i = 0; i < 3; i++) {
            edgeCaseAge22.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            edgeCaseAge22.addItem(new Meat());
        }


        //edgeCasesProduce

        edgeCaseProduce1 = createCart(20);
        for(int i = 0; i < 3; i++) {
            edgeCaseProduce1.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            edgeCaseProduce1.addItem(new Meat());
        }
        for(int i =0; i< 2; i++) {
            edgeCaseProduce1.addItem(new Produce());

        }

        edgeCaseProduce1Expected = 57.24;

        edgeCaseProduce2 = createCart(20);
        for(int i = 0; i < 3; i++) {
            edgeCaseProduce2.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            edgeCaseProduce2.addItem(new Meat());
        }
        for(int i =0; i< 4; i++) {
            edgeCaseProduce2.addItem(new Produce());

        }

        edgeCaseProduce2Expected = 60.48; 

        /////////////////////////////

        edgeCaseAlcFroz1 = createCart(22);
        for(int i = 0; i < 3; i++) {
            edgeCaseAlcFroz1.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            edgeCaseAlcFroz1.addItem(new Meat());
        }
        for(int i = 0; i < 2; i++) {
            edgeCaseAlcFroz1.addItem(new Alcohol());;

        }
        edgeCaseAlcFroz1.addItem(new FrozenFood());

        edgeCaseAlcFroz1Expected = 72.36; 

        //////////////////////////////////////

        edgeCaseNoAlc1 = createCart(20);
        for(int i = 0; i < 3; i++) {
            edgeCaseNoAlc1.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            edgeCaseNoAlc1.addItem(new Meat());
        }

        edgeCaseNoAlc1Expected = 52.92; 


        edgeCaseNoAlc2 = createCart(21);
        for(int i = 0; i < 3; i++) {
            edgeCaseNoAlc2.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            edgeCaseNoAlc2.addItem(new Meat());
        }

        edgeCaseNoAlc2Expected = 52.92;


        edgeCaseNoAlc3 = createCart(22);
        for(int i = 0; i < 3; i++) {
            edgeCaseNoAlc3.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            edgeCaseNoAlc3.addItem(new Meat());
        }

        edgeCaseNoAlc3Expected = 52.92;






















    }


    //Cart must have several items including more than 3 produce 
    //and multiple alcohol and frozen food items.
    @Test
    public void asNodeCoverage1() throws UnderAgeException {
        double saved = nodeCoverage1.amountSaved();
        double expected = 10;
        assertEquals(expected,saved, .01 ); 
    }

    //same as node coverage 1 but underAge
    @Test(expected = UnderAgeException.class) 
    public void asNodeCoverage2() throws UnderAgeException {
        nodeCoverage2.amountSaved();
    }

    //mult items in the cart no alc, no frozen, no produce

    @Test
    public void testpathCoverage1() throws UnderAgeException {
        double saved = pathCoverage1.amountSaved();
        double expected = 0;
        assertEquals(expected, saved, .01);
    }


    //mult items in cart, 1 produce, no alc no frozen food
    @Test
    public void testPathCoverage2() throws UnderAgeException {
        double saved = pathCoverage2.amountSaved();
        double expected = 0;
        assertEquals(expected, saved, .01);
    }

    //Multiple items 6 produce, no alcohol, no frozen food

    @Test
    public void testPathCoverage3() throws UnderAgeException {
        double saved = pathCoverage3.amountSaved();
        double expected = 2;
        assertEquals(expected, saved, .01);
    }

    //Multiple items no produce, 2 alcohol, no frozen food

    @Test
    public void teatPathCoverage4() throws UnderAgeException {
        double saved = pathCoverage4.amountSaved();
        double expected = 0;
        assertEquals(expected, saved, .01); 
    }


    //Multiple items no produce 2 alcohol, no frozen food under age
    @Test(expected = UnderAgeException.class)
    public void teatPathCoverage5() throws UnderAgeException {
        pathCoverage5.amountSaved(); 
    }

    //Multiple items no produce, no alcohol, 2 frozen food.
    @Test
    public void teatPathCoverage6() throws UnderAgeException {
        double saved = pathCoverage6.amountSaved();
        double expected = 0;
        assertEquals(expected, saved, .01); 
    }

    //Multiple items no produce , 2 alcohol, 2 frozen food. 
    @Test
    public void teatPathCoverage7() throws UnderAgeException {
        double saved = pathCoverage7.amountSaved();
        double expected = 6;
        assertEquals(expected, saved, .01); 
    }

    //under age no alcohol
    @Test
    public void testPathCoverage8() throws UnderAgeException {
        double saved = pathCoverage8.amountSaved();
        double expected = 1;
        assertEquals(expected,saved, .01);
    }


    ///////Testing getTax

    @Test
    public void thetaxTestCa(){
        double tax = taxTestCA.getTax(10, "CA");
        double expected = .9; 
        assertEquals(expected, tax, .01); 
    }

    @Test
    public void thetaxTestCO(){
        double tax = taxTestCO.getTax(10, "CO");
        double expected = .7; 
        assertEquals(expected, tax, .01); 
    }

    @Test
    public void thetaxTestNY(){
        double tax = taxTestNY.getTax(10, "NY");
        double expected = 1.0; 
        assertEquals(expected, tax, .01); 
    }

    @Test
    public void theTaxTest() {
        double tax = taxTestNY.getTax(10, "");
        double expected = 10; 
        assertEquals(expected, tax, .01); 

    }


    //Testing remove produce

    @Test
    public void testRemove() throws UnderAgeException {
        Cart removeCart = new Cart(30); 
        removeCart.addItem(new Dairy());
        removeCart.removeItem(new Dairy()); 
        double cost = removeCart.calcCost();
        assertEquals(0,cost,.01); 
    }

    ////////////////////////////////////////////////////////////////////

    // sample test
    @Test
    public void calcCostCart1() throws UnderAgeException {
        double amount = cart1.calcCost();


    
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

    ////////////////////////////////////////////////////////

    @Test(expected = UnderAgeException.class)
    public void underAgeAlcohol1() throws UnderAgeException{
        cartAlcohol1UnderAge.calcCost(); 
    }

    @Test(expected = UnderAgeException.class)
    public void underAgeAlcohol5() throws UnderAgeException{
        cartAlcohol5UnderAge.calcCost(); 
    }

    @Test(expected = UnderAgeException.class)
    public void underAgeAlcohol10() throws UnderAgeException{
        cartAlcohol10UnderAge.calcCost(); 
    }

    @Test(expected = UnderAgeException.class)
    public void underAgeAlcohol100() throws UnderAgeException{
        cartAlcohol100UnderAge.calcCost(); 
    }

    ////////////////////////////////////////////////////////

    @Test
    public void calcCostCartAlcohol121() throws UnderAgeException {
        double amount = cartAlcohol121.calcCost();
        assertEquals(cartAlcohol1Expected21, amount, .01);

    }

    @Test
    public void calcCostCartAlcohol521() throws UnderAgeException {
        double amount = cartAlcohol521.calcCost();
        assertEquals(cartAlcohol5Expected21, amount, .01);

    }

    @Test
    public void calcCostCartAlcohol1021() throws UnderAgeException {
        double amount = cartAlcohol1021.calcCost();
        assertEquals(cartAlcohol10Expected21, amount, .01);

    }

    @Test
    public void calcCostCartAlcohol10021() throws UnderAgeException {
        double amount = cartAlcohol10021.calcCost();
        assertEquals(cartAlcohol100Expected21, amount, .01);

    }

    @Test
    public void calcCostCartEmpty() throws UnderAgeException {
        double amount = cartEmpty.calcCost();
        assertEquals(cartEmptyExpected, amount, .01);
    }

    @Test
    public void calcCostCartEmpty21() throws UnderAgeException {
        double amount = cartEmpty21.calcCost();
        assertEquals(cartEmpty21Expected, amount, .01);
    }

    @Test
    public void calcCostCartEmptyUnderAge() throws UnderAgeException {
        double amount = cartEmptyUnderAge.calcCost();
        assertEquals(cartEmptyUnderAgeExpected, amount, .01);
    }


    ////////////////////////////////////////////////////////////////

    @Test(expected = UnderAgeException.class)
    public void testedgeCaseAge20() throws UnderAgeException{
        edgeCaseAge20.calcCost(); 
    }


    @Test
    public void testedgeCaseProduce1() throws UnderAgeException {
        double amount = edgeCaseProduce1.calcCost();
        assertEquals(edgeCaseProduce1Expected, amount, .01); 
    }

    @Test
    public void testedgeCaseProduce() throws UnderAgeException {
        double amount = edgeCaseProduce2.calcCost();
        assertEquals(edgeCaseProduce2Expected, amount, .01);
    }

    @Test
    public void testedgeCaseAlcFroz1() throws UnderAgeException {
        double amount = edgeCaseAlcFroz1.calcCost();
        assertEquals(edgeCaseAlcFroz1Expected, amount, .01); 
    }

    @Test
    public void testegdeCaseNoAlc1() throws UnderAgeException {
        double amount = edgeCaseNoAlc1.calcCost();
        assertEquals(edgeCaseNoAlc1Expected, amount, 0.01); 
    }

    @Test
    public void testegdeCaseNoAlc2() throws UnderAgeException {
        double amount = edgeCaseNoAlc2.calcCost();
        assertEquals(edgeCaseNoAlc2Expected, amount, 0.01); 
    }

    @Test
    public void testegdeCaseNoAlc3() throws UnderAgeException {
        double amount = edgeCaseNoAlc3.calcCost();
        assertEquals(edgeCaseNoAlc3Expected, amount, 0.01); 
    }













}
