package br.prax.representative.model;

public class InvoiceItem {
	
	public String reference;
	public String description;
	public String color;
	public String tamanho; //depois mudamos para ser uma lista de "tamanhoXquantidade, por enquanto cada item é um
	public int quantity;
	public double unitValue;
	
	public String getReference() {
		return reference;
	}
	
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getUnitValue() {
		return unitValue;
	}
	
	public void setUnitValue(double unitValue) {
		this.unitValue = unitValue;
	}
	
	public double getTotalValue() {
		return this.unitValue * this.quantity;
	}
	
}