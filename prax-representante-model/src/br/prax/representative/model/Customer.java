package br.prax.representative.model;

public class Customer {

	private String code; // nao eh pk, a nossa pk eh outro campo, sendo q esse
							// pode ser um dado bem especifico do sistema da
							// empresa representada, talvez mudar o nome
	private String corporateName; // razao social
	private String cnpj;

	private String stateInscription; // inscricao estadual, depois que
										// definirmos que estes sao bons nomes
										// tiramos os comentarios que só sujam o
										// código, qq mudamos para portugues
										// tamb
	private String customerName;

	private int phone;
	private String email;
	private String contactName;
	private String contactPhone;
	private String contactEmail;

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
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	public void FillWithMyData(){
		setCorporateName("Jonathan Rafael Zanella");
		setCnpj("01.001.001/0001-00");
		setStateInscription("123.456.789");
		address = new Address();
		address.FillWithMyData();
		setContactName("Jean Kirchner");
		setContactPhone("(47) 8836-5837");
		setContactEmail("jean@praxworks.com.br");
	}
}
