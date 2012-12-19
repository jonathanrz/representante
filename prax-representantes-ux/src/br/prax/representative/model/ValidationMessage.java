package br.prax.representative.model;

import javax.print.attribute.standard.Severity;

public class ValidationMessage {
	
	private Severity severity;
	private String message;
	
	public ValidationMessage(Severity severity, String message) {
		this.severity = severity;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	public Severity getSeverity() {
		return severity;
	}

}
