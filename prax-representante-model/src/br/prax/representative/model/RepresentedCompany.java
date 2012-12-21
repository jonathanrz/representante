package br.prax.representative.model;

import java.awt.Image;
import java.util.Date;

public class RepresentedCompany {

	private String name;
	private Image logo; // nao tenho certeza se é a melhor classe para
						// representar imagem

	private String email;
	private int phone;
	private String furtherInformation;

	private Date sellDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getFurtherInformation() {
		return furtherInformation;
	}

	public void setFurtherInformation(String furtherInformation) {
		this.furtherInformation = furtherInformation;
	}

	public Date getSellDate() {
		return sellDate;
	}

	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}

}
