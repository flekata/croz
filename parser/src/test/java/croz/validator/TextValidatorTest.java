/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package croz.validator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stojan
 */
public class TextValidatorTest {
    
    public TextValidatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validate method, of class TextValidator.
     */
    @Test
    public void testValidateSigns() {
        System.out.println("testValidateSigns");
        String value = " !@$#%%&^**(&) 1 ";
        TextValidator instance = new TextValidator();
        boolean expResult = true;
        boolean result = instance.validate(value);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validate method, of class TextValidator.
     */
    @Test
    public void testValidateChars() {
        System.out.println("testValidateChars");
        String value = " sto jan ";
        TextValidator instance = new TextValidator();
        boolean expResult = true;
        boolean result = instance.validate(value);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validate method, of class TextValidator.
     */
    @Test
    public void testValidateNumberAsString() {
        System.out.println("testValidateNumberAsString");
        String value = " 1234";
        TextValidator instance = new TextValidator();
        boolean expResult = true;
        boolean result = instance.validate(value);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validate method, of class TextValidator.
     */
    @Test
    public void testValidateCyrilic() {
        System.out.println("testValidateCyrilic");
        String value = " стојан";
        TextValidator instance = new TextValidator();
        boolean expResult = true;
        boolean result = instance.validate(value);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validate method, of class TextValidator.
     */
    @Test
    public void testValidateMix() {
        System.out.println("testValidateMix");
        String value = " сто jan 12 ~!@ 	"; // ends with tab
        TextValidator instance = new TextValidator();
        boolean expResult = true;
        boolean result = instance.validate(value);
        assertEquals(expResult, result);
    }
    
}
