package br.prax.representative.model;

import java.util.List;


public interface IModelValidator {
	List<ValidationMessage> validate();
}
