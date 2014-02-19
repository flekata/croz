/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package croz.model;

/**
 *
 * @author stojan
 */
public class ValidationResult {

    private int id;
    private boolean valid;

    public ValidationResult(int id, boolean valid) {
        this.id = id;
        this.valid = valid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        hash = 79 * hash + (this.valid ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ValidationResult other = (ValidationResult) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.valid != other.valid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ValidationResult{" + "id=" + id + ", valid=" + valid + '}';
    }

}
