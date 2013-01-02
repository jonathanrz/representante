package br.prax.representative.model;

public class InvoiceItem {
	
	public String reference;
	public String description;
	public String color;
	public int quantityP;
	public int quantityM;
	public int quantityG;
	public int quantityGG;
	public int unitValue;
	
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
	
	public int getUnitValue() {
		return unitValue;
	}
	
	public String getUnitValueAsString(){
		String s = new String();
		//s += "R$";
		s += unitValue / 100;
		s += ",";
		s += unitValue % 100;
		return s;
	}
	
	public void setUnitValue(int unitValue) {
		this.unitValue = unitValue;
	}
	
	public int getTotalValue() {
		return this.unitValue * getQuantity();
	}
	
	public String getTotalValueAsString(){
		String s = new String();
		//s += "R$";
		s += getTotalValue() / 100;
		s += ",";
		s += getTotalValue() % 100;
		return s;
	}

	public int getQuantityP() {
		return quantityP;
	}

	public void setQuantityP(int quantityP) {
		this.quantityP = quantityP;
	}

	public int getQuantityM() {
		return quantityM;
	}

	public void setQuantityM(int quantityM) {
		this.quantityM = quantityM;
	}

	public int getQuantityG() {
		return quantityG;
	}

	public void setQuantityG(int quantityG) {
		this.quantityG = quantityG;
	}

	public int getQuantityGG() {
		return quantityGG;
	}

	public void setQuantityGG(int quantityGG) {
		this.quantityGG = quantityGG;
	}
	
	public void setQuantity(int qtdP, int qtdM, int qtdG, int qtdGG){
		setQuantityP(qtdP);
		setQuantityM(qtdM);
		setQuantityG(qtdG);
		setQuantityGG(qtdGG);
	}
	
	public int getQuantity(){
		return getQuantityP() + getQuantityM() + getQuantityG() + getQuantityGG();  
	}
}