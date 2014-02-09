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
public class NumberValidatorTest {
    
    public NumberValidatorTest() {
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
     * Test of validate method, of class NumberValidator.
     */
    @Test
    public void testValidateNormal() {
        System.out.println("testValidateNormal");
        String value = "1234";
        NumberValidator instance = new NumberValidator();
        boolean expResult = true;
        boolean result = instance.validate(value);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validate method, of class NumberValidator.
     */
    @Test
    public void testValidateSpaces() {
        System.out.println("testValidateSpaces");
        String value = "12 34";
        NumberValidator instance = new NumberValidator();
        boolean expResult = false;
        boolean result = instance.validate(value);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validate method, of class NumberValidator.
     */
    @Test
    public void testValidateUntrimed() {
        System.out.println("testValidateUntrimed");
        String value = " 1234 ";
        NumberValidator instance = new NumberValidator();
        boolean expResult = false;
        boolean result = instance.validate(value);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validate method, of class NumberValidator.
     */
    @Test
    public void testValidateLeadZero() {
        System.out.println("testValidateLeadZero");
        String value = "0001234";
        NumberValidator instance = new NumberValidator();
        boolean expResult = true;
        boolean result = instance.validate(value);
        assertEquals(expResult, result);
    }
}
