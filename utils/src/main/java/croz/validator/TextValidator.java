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
public class TextValidator implements Validator {

    // all printable + tab + new line
    private static final String REGEX = "[\\p{Print}\\t\\n]*";

    @Override
    public boolean validate(String value) {
        Pattern p = Pattern.compile(REGEX, Pattern.UNICODE_CHARACTER_CLASS);
        return p.matcher(value).matches();
    }

}
