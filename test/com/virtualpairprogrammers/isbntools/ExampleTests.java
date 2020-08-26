package com.virtualpairprogrammers.isbntools;

import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class ExampleTests {
    @Test
    public void checkAValidISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116");
        assertTrue("first value",result);
        result = validator.checkISBN("0140177396");
        assertTrue("second value",result);
    }
    @Test
    public void checkAValid13DigitISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9780262533058");
        assertTrue("first value",result);
        result = validator.checkISBN("9781849967204");
        assertTrue("second value",result);

    }
    @Test
    public void tenIsbnNumberEndingWithXIsValid(){
        ValidateISBN validate = new ValidateISBN();
        boolean result = validate.checkISBN("012000030X");
        assertTrue(result);
    }
    @Test
    public void checkAn13DigitInValidISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781849967205");
        assertFalse(result);
    }
    @Test
    public void checkAnTenDigitInValidISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }
    @Test(expected =  NumberFormatException.class)
    public void nineDigitISBNNumbersAreNotAllowed(){
        ValidateISBN validate = new ValidateISBN();
        validate.checkISBN("123456789");
    }
    @Test(expected = InputMismatchException.class)
    public void otherThanInteger(){
        ValidateISBN validate = new ValidateISBN();
        validate.checkISBN("helloworld");
    }


}
