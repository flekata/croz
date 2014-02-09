/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package croz.bundle;

import croz.validator.TextValidator;
import java.util.Enumeration;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author stojan
 */
public class ValidatorResourcesTest {

    public ValidatorResourcesTest() {
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
     * Test of handleGetObject method, of class ValidatorResources.
     */
    @Test
    public void testHandleGetObject() {
        System.out.println("handleGetObject");
        String key = "TEXT";
        ValidatorResources bundle = new ValidatorResources("validators");
        Class expResult = TextValidator.class;
        Object result = bundle.getObject(key);
        assertEquals(expResult, result.getClass());
    }

    /**
     * Test of getKeys method, of class ValidatorResources.
     */
    @Test
    @Ignore
    public void testGetKeys() {
        System.out.println("getKeys");
        ValidatorResources instance = new ValidatorResources("validators");
        Enumeration<String> expResult = null;
        Enumeration<String> result = instance.getKeys();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
