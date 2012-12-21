package br.prax.representative.model;

public class Customer {

	private String code; // nao eh pk, a nossa pk eh outro campo, sendo q esse
							// pode ser um dado bem especifico do sistema da
							// empresa representada, talvez mudar o nome
	private String corporateName; // razao social
	private String stateInscription; // inscricao estadual, depois que
										// definirmos que estes sao bons nomes
										// tiramos os comentarios que só sujam o
										// código, qq mudamos para portugues
										// tamb
	private String customerName;

	private int phone;
	private String email;

	private Address address;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getStateInscription() {
		return stateInscription;
	}

	public void setStateInscription(String stateInscription) {
		this.stateInscription = stateInscription;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
