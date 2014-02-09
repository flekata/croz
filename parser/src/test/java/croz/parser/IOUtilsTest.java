/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package croz.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private static String path;

    @BeforeClass
    public static void setUpClass() {
        try {
            URL classpath = IOUtilsTest.class.getResource(".");
            File classpathFile = new File(classpath.toURI());
            path = classpathFile.getAbsolutePath();
        } catch (URISyntaxException ex) {
            Logger.getLogger(IOUtilsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
     * @throws java.io.IOException
     */
    @Test
    public void testReadAllLines() throws IOException {
        System.out.println("readAllLines");
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
     * @throws java.io.IOException
     */
    @Test
    public void testWriteFileBytes() throws IOException {
        System.out.println("writeFileBytes");
        String filename = "ValidationResults.txt";
        IOUtils instance = new IOUtils();
        
        BufferedWriter writer = instance.openFileForWriting(
                path, filename, Charset.defaultCharset());
        for (String content : expectedLines) {
            writer.append(content);
            writer.newLine();
        }
        instance.finishWriting(writer);
        
        // check the written content
        List<String> result = instance.readAllLines(path, filename);
        assertEquals(Arrays.asList(expectedLines), result);
                
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
