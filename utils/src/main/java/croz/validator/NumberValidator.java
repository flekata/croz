/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package croz.validator;

import java.util.regex.Pattern;

/**
 *
 * @author stojan
 */
public class NumberValidator implements Validator {

    private static final String REGEX = 
            "\\p{Digit}*";
//            "^([0-9])+$";

    @Override
    public boolean validate(String value) {
        return Pattern.matches(REGEX, value);
    }

}
