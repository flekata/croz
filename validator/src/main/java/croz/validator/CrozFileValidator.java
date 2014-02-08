package croz.validator;

import croz.parser.IOUtils;
import croz.parser.ParseUtils;
import java.io.File;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author stojan
 */
public class CrozFileValidator {

    private static final String KEY_VALUE_SEPARATOR = "=";
    private static final String COLUMN_SEPARATOR = ";";

    IOUtils io = new IOUtils();
    ParseUtils pu = new ParseUtils();

    public File processValidation(String path, String fileName) {

        List<String> rows = io.readAllLines(path, fileName);
        for (String row : rows) {
            processRow(row);

        }

        return null;
    }

    private void processRow(String row) {
        try {
            String[] columns = pu.parse(row, COLUMN_SEPARATOR);
            String type = columns[0];
            String value = columns[1];
            processColumn(type);
            processColumn(value);
            
        } catch (IndexOutOfBoundsException e) {
            throw new FormatNotValidException(
                    "File Structure is not valid: " + e.getMessage(), e);
        }
    }
    
    // TODO: solve this using object mapper ??
    private void processColumn(String column) {
        String[] parse = pu.parse(column, KEY_VALUE_SEPARATOR);
    }

}
