package com.virtualpairprogrammers.isbntools;

import java.util.InputMismatchException;

public class ValidateISBN {

    public static final int Long_ISBN = 13;
    public static final int Short_ISBN = 10;
    public static final int Short_ISBN_Multiplier = 11;
    public static final int Long_ISBN_Mulitplier = 10;

    public boolean checkISBN(String isbn) {

        if (isbn.length() == Long_ISBN) {
            return isValidLongISBN(isbn);

        } else if (isbn.length() == Short_ISBN) {
            return isValidShortISBN(isbn);
        }
      throw new NumberFormatException("ISBN length is less than 10");
    }

    private boolean isValidShortISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < Short_ISBN; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == 9 && isbn.charAt(i) == 'X') {
                    total += 10;

                } else {
                    throw new InputMismatchException("It's not an Integer");
                }
            }
            total += Character.getNumericValue(isbn.charAt(i)) * (Short_ISBN - i);
        }
        return  (total % Short_ISBN_Multiplier == 0);

    }

    private boolean isValidLongISBN(String isbn) {
        int total=0;
        for(int i=0; i<Long_ISBN; i++){
            if(i % 2==0){
                total += Character.getNumericValue(isbn.charAt(i));
            }else{
                total += Character.getNumericValue(isbn.charAt(i)) * 3;
            }
        }
        return (total% Long_ISBN_Mulitplier ==0);
    }
}
