/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package croz.validator;

import croz.bundle.ValidatorResources;
import croz.model.Content;
import croz.model.ValidationResult;
import croz.repo.FileRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author stojan
 */
@Service
public class CrozFileValidation {

    @Autowired
    FileRepository fileRepository;

    ValidatorResources bundle = new ValidatorResources("validators");

    // TODO: use RowCallbackHandler to handle bigger data sets
    public void processValidation(String fileName) {
        List<Content> contentRows = fileRepository.findContentByFileName(fileName);
        for (Content content : contentRows) {
            boolean valid = validateRow(content.getType(), content.getValue());
            ValidationResult result = new ValidationResult(content.getId(), valid);
            fileRepository.updateValidationResult(result);
        }
    }

    private boolean validateRow(String type, String value) {
        Validator validator = bundle.getValidator(type);
        return validator.validate(value);
    }

}
