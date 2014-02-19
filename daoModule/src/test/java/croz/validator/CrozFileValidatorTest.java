package croz.validator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import croz.model.ValidationResult;
import croz.repo.FileRepository;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.util.Arrays;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author stojan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-config.xml")
public class CrozFileValidatorTest {

    ValidationResult[] expectedRows = {
        new ValidationResult(0, true),
        new ValidationResult(1, true),
        new ValidationResult(2, false),
        new ValidationResult(3, true),
        new ValidationResult(4, false),
        new ValidationResult(5, true),
        new ValidationResult(6, true)
    };

    @Autowired
    CrozFileValidation validator;

    @Autowired
    FileRepository fileRepository;

    @Test
    public void validateFile() throws IOException {
        System.out.println("validateFile");
        String fileName = "FileToValidate.txt";
        validator.processValidation(fileName);

        List<ValidationResult> expectedResult = Arrays.asList(expectedRows);
        List<ValidationResult> result = fileRepository.findResultsByFileName(fileName);
        assertEquals(expectedResult, result);
    }

}
