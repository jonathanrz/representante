package br.prax.representative.ux.fragments;

import java.util.List;

import br.prax.representative.model.ValidationMessage;
import br.prax.representative.ux.Question;

public interface IFormFragment {

	boolean supportsSave();
	boolean supportsNew();
	boolean supportsCancel();
	
	List<ValidationMessage> onSave();
	Question onCancel();
	Question onNew();
	
}
