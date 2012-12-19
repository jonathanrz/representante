package br.prax.representative.ux;

import java.util.Arrays;
import java.util.List;

import br.prax.representative.ux.fragments.QuestionOption;

public class Question {
	
	public static final Question NULL = new Question(null, null);
	
	private String question;
	private List<QuestionOption> options;
	private IResponseEvent respEvent;
	
	public Question(String question, IResponseEvent respEvent, QuestionOption... options) {
		this.question = question;
		this.respEvent = respEvent;
		this.options =  Arrays.asList(options);
	}
	
	public List<QuestionOption> getOptions() {
		return options;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void onResponse(QuestionOption option) {
		this.respEvent.onResponse(option);
	}
	
}
