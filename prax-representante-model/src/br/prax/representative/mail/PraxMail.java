package br.prax.representative.mail;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class PraxMail {
	private MultiPartEmail email;
	private String authenticatorMail = "geradorpedidos@gmail.com";
	private String authenticatorPassword = "praxworks";
	
	/**
	 * @param args
	 * @throws EmailException 
	 */
	/*public static void main(String[] args) throws EmailException {
		PraxMail mail = new PraxMail();
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("C:\\temp\\Modelo4.pdf");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Modelo4");
		attachment.setName("Modelo4.pdf");
		mail.send("jean.kirchner@gmail.com", "assunto", "agora com anexo :)", attachment);
	}*/
	
	public void send(String toMail, String subject, String msg) throws EmailException{
		send(toMail, subject, msg, new ArrayList<EmailAttachment>());
	}
	
	public void send(String toMail, String subject, String msg, EmailAttachment attachment) throws EmailException{
		List<EmailAttachment> attachments = new ArrayList<EmailAttachment>();
		attachments.add(attachment);
		send(toMail, subject, msg, attachments);
	}
	
	public void send(String toMail, String subject, String msg, List<EmailAttachment> attachments) throws EmailException{
		email = new MultiPartEmail();
		
		addAttachments(attachments);
		
		setConfig();
		
		email.setFrom(authenticatorMail);
		email.addTo(toMail);
		email.setSubject(subject);
		email.setMsg(msg);
		
		email.send();
	}

	private void setConfig() throws EmailException {
		email.setDebug(true);
		email.setAuthenticator(new DefaultAuthenticator(authenticatorMail, authenticatorPassword));
		email.setSmtpPort(587);
		email.setHostName("smtp.gmail.com");
		email.getMailSession().getProperties().put("mail.smtps.auth", "true");
		email.getMailSession().getProperties().put("mail.debug", "true");
		email.getMailSession().getProperties().put("mail.smtps.port", "587");
		email.getMailSession().getProperties().put("mail.smtps.socketFactory.port", "587");
		email.getMailSession().getProperties().put("mail.smtps.socketFactory.class",   "javax.net.ssl.SSLSocketFactory");
		email.getMailSession().getProperties().put("mail.smtps.socketFactory.fallback", "false");
		email.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
		email.setTLS(true);
	}

	private void addAttachments(List<EmailAttachment> attachments) throws EmailException {
		for (EmailAttachment emailAttachment : attachments) {
			email.attach(emailAttachment);
		}		
	}
}
