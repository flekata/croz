/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package croz.bundle;

import croz.validator.Validator;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stojan
 */
public class ValidatorResources extends ResourceBundle {

    public ValidatorResources(String baseName) {
        setParent(getBundle(baseName));
    }

    @Override
    protected Validator handleGetObject(String key) {
        try {
            String validatorClass = parent.getString(key);
            return (Validator) Class.forName(validatorClass).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(ValidatorResources.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Enumeration<String> getKeys() {
        return parent.getKeys();
    }

    public Validator getValidator(String key) {
        return (Validator) getObject(key);
    }

}
