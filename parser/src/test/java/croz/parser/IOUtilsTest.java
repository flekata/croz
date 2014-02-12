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
     * Test of readAllLines method, of class ParserUtils.
     *
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
    public void testReadAllLinesLargeFile() throws IOException {
        System.out.println("readLargeFileLines");
        String name = "";
        IOUtils instance = new IOUtils();
        List<String> expResult = null;
        instance.readAllLinesLargeFile(path, name,
                new TestLineProcessor()
        );
        List<String> result = null;
        assertEquals(expResult, result);
    }

    /**
     * Test of writeFileBytes method, of class ParserUtils.
     *
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

    private class TestLineProcessor implements LineProcessor {

        @Override
        public void processLine(String line) {
            // parse each line ...
        }

    }

}
