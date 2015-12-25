package com.egen.bookstore.model;

import java.util.ArrayList;
import java.util.List;

public class ValidationError {

	private List<FieldError> errors = new ArrayList<FieldError>();
	 
    public List<FieldError> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldError> errors) {
		this.errors = errors;
	}

	public ValidationError() {
 
    }
 
    public void addFieldError(String field, String message) {
        FieldError error = new FieldError(field, message);
        errors.add(error);
    }
 
    
}

