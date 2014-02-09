package croz.validator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import croz.bundle.ValidatorResources;
import croz.parser.IOUtils;
import croz.parser.ParseUtils;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stojan
 */
public class CrozFileValidator {

    private static final String KEY_VALUE_SEPARATOR = "=";
    private static final String COLUMN_SEPARATOR = ";";
    private static final String VALIDATION_RESULT = "validation_result";

    IOUtils io = new IOUtils();
    ParseUtils pu = new ParseUtils();

    public void processValidation(String path, String fileName, String resultsFileName) {
        BufferedWriter writer = null;
        try {
            List<String> rows = io.readAllLines(path, fileName);
            writer = io.openFileForWriting(
                    path, resultsFileName, Charset.defaultCharset());
            for (String row : rows) {
                String validRowStatus = processRow(row);
                writer.append(row)
                        .append(VALIDATION_RESULT)
                        .append(KEY_VALUE_SEPARATOR)
                        .append(validRowStatus)
                        .append(COLUMN_SEPARATOR);
                writer.newLine();
            }
            io.finishWriting(writer);

        } catch (IOException ex) {
            Logger.getLogger(CrozFileValidator.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(CrozFileValidator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // TODO: solve this using object mapper ??
    private String processRow(String row) {
        try {
            String[] columns = pu.parse(row, COLUMN_SEPARATOR);
            String typeColumn = columns[0];
            String valueColumn = columns[1];

            String type = pu.parse(typeColumn, KEY_VALUE_SEPARATOR)[1];
            String value = pu.parse(valueColumn, KEY_VALUE_SEPARATOR)[1];

            return validateRow(type, value);

        } catch (Exception e) {
            throw new FormatNotValidException(
                    "Row format: " + row
                    + ", is not valid: " + e.getMessage(), e);
        }
    }

    private String validateRow(String type, String value) {
        boolean valid = false;

        ValidatorResources bundle = new ValidatorResources("validators");
        Validator validator = bundle.getValidator(type);
        valid = validator.validate(value);

        return valid ? "VALID" : "INVALID";
    }

}
