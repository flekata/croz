package croz.validator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import croz.parser.IOUtils;
import java.io.IOException;

/**
 *
 * @author stojan
 */
public class CrozFileValidatorTest {

    private static String path;

    @BeforeClass
    public static void setUpClass() {
        try {
            URL classpath = CrozFileValidatorTest.class.getResource(".");
            File classpathFile = new File(classpath.toURI());
            path = classpathFile.getAbsolutePath();
        } catch (URISyntaxException ex) {
            Logger.getLogger(CrozFileValidatorTest.class.getName()).log(Level.SEVERE, null, ex);
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

    @Test
    public void validateFile() throws IOException {
        System.out.println("validateFile");
        String fileName = "FileToValidate.txt";
        String resultsFileName = "ValidationResults.txt";
        String expectedResultsName = "ExpectedValidationResults.txt";
        CrozFileValidator validator = new CrozFileValidator();
//        File expResult = new File(path, expectedResultsName);
        validator.processValidation(path, fileName, resultsFileName);
//        File resultsFile = new File(path, resultsFileName);

        IOUtils ioUtils = new IOUtils();
        List<String> expectedResult = ioUtils.readAllLines(path, expectedResultsName);
        List<String> result = ioUtils.readAllLines(path, resultsFileName);
        assertEquals(expectedResult, result);
//        assertEquals(expResult, resultsFile);
    }
}
