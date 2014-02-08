/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package croz.parser;

import java.util.Arrays;
import java.util.List;
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
public class IOUtilsTest {

    String[] expectedLines = {
        "type=TEXT;value=Prvi primjer nekog teksta;",
        "type=TEXT;value=Drugi primjer nekog teksta;",
        "type=NUMBER;value=Prvi primjer nekog teksta;",
        "type=NUMBER;value=1234;",
        "type=NUMBER;value=1234aaa;",
        "type=TEXT;value=1234aaa;",
        "type=TEXT;value=1235;"
    };

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
     * Test of readSmallFileBytes method, of class ParserUtils.
     */
    @Test
    @Ignore
    public void testReadSmallFileBytes() {
        System.out.println("readSmallFileBytes");
        String name = "";
        IOUtils instance = new IOUtils();
        byte[] expResult = null;
        byte[] result = instance.readSmallFileBytes(name);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readAllLines method, of class ParserUtils.
     */
    @Test
    public void testReadAllLines() {
        System.out.println("readAllLines");
        String path = "C:\\dev\\sources\\cro\\croz\\parser\\src\\test\\resources";
        String fileName = "FileToValidate.txt";
        IOUtils instance = new IOUtils();
        List<String> result = instance.readAllLines(path, fileName);
        assertEquals(Arrays.asList(expectedLines), result);
    }

    /**
     * Test of readLargeFileLines method, of class ParserUtils.
     */
    @Test
    @Ignore
    public void testReadLargeFileLines() {
        System.out.println("readLargeFileLines");
        String name = "";
        IOUtils instance = new IOUtils();
        List<String> expResult = null;
        List<String> result = instance.readLargeFileLines(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readLargeFileLinesMixed method, of class ParserUtils.
     */
    @Test
    @Ignore
    public void testReadLargeFileLinesMixed() {
        System.out.println("readLargeFileLinesMixed");
        String name = "";
        IOUtils instance = new IOUtils();
        List<String> expResult = null;
        List<String> result = instance.readLargeFileLinesMixed(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeFileBytes method, of class ParserUtils.
     */
    @Test
    @Ignore
    public void testWriteFileBytes() {
        System.out.println("writeFileBytes");
        String filename = "";
        String content = "";
        IOUtils instance = new IOUtils();
        instance.writeFileBytes(filename, content);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeFileBytesBuffered method, of class ParserUtils.
     */
    @Test
    @Ignore
    public void testWriteFileBytesBuffered() {
        System.out.println("writeFileBytesBuffered");
        String filename = "";
        String content = "";
        IOUtils instance = new IOUtils();
        instance.writeFileBytesBuffered(filename, content);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
