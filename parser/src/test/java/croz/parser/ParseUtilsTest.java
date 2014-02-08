/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package croz.parser;

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
public class ParseUtilsTest {

    public ParseUtilsTest() {
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
     * Test of parse method, of class ParseUtils.
     */
    @Test
    public void testParse() {
        System.out.println("parse");
        String text = "type=NUMBER;value=1234;";
        String separator = ";";
        ParseUtils instance = new ParseUtils();
        String[] expResult = {"type=NUMBER", "value=1234"};
        String[] result = instance.parse(text, separator);
        assertArrayEquals(expResult, result);
    }

}
