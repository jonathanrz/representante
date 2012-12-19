package br.prax.representative.model;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Severity;

public class CustomerModel implements IModelValidator {

	private int id;
	private String name;
	private Integer cnpj;
	private Integer stateRegistry;

	// location
	private int cep;
	private String address;
	private UF uf;
	private String country = "Brazil";
	// end- location

	// contact
	private int mobilePhone;
	private int pinnedPhone;
	private String email;

	// end- contact

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

	public int getStateRegistry() {
		return stateRegistry;
	}

	public void setStateRegistry(Integer stateRegistry) {
		this.stateRegistry = stateRegistry;
	}

	
	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public int getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(int mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public int getPinnedPhone() {
		return pinnedPhone;
	}

	public void setPinnedPhone(int pinnedPhone) {
		this.pinnedPhone = pinnedPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	private enum UF {
		SC;
	}

	@Override
	public List<ValidationMessage> validate() {
		List<ValidationMessage> l = new ArrayList<>();
		
		if (this.name == null) {
			l.add(new ValidationMessage(Severity.ERROR, "Campo nome obrigatório"));
		}

		
		return l;
		
	}

}
