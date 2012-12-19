package br.prax.representative.ux.fragments;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import br.prax.representative.ux.Question;

public class QuestionMaker {

	public void makeQuestion(Shell parent, Question q) {
		if (q == Question.NULL) return;
		if (MessageDialog.openConfirm(parent, "Confirmação de operação", q.getQuestion())) {
			q.onResponse(QuestionOption.YES);
		} else {
			q.onResponse(QuestionOption.NO);
		}
	}
	
}
