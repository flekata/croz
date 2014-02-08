/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package croz.parser;

/**
 *
 * @author stojan
 */
public class ParseUtils {
    
    /**
     *  TODO: could use apache commons lang3 StringUtils instead
     * 
     * @param text
     * @param separator 
     * @return  
     */
    public String[] parse(String text, String separator) {
         return text.split(separator);
    }
    
}
