package br.prax.representative.model;

import java.util.List;

public class BillDetails {

	private String paymentConditions; // String? bom, até que se faça fica assim
	private String deliveryDate; // Date do java, velocidade em DEV, em geral se
								// usa outras apis de date pq a do java tem
								// alguns bugs, mas nenhum que iremos vivenciar
								// por enquanto

	private String dispatch; // despacho / transportadora CIF FOB
	private List<Address> addresses; // end entrega. end cobrança, talvez a
										// classe Address tenha que ter um
										// "name" para saber qual é qual

	public String getPaymentConditions() {
		return paymentConditions;
	}

	public void setPaymentConditions(String paymentConditions) {
		this.paymentConditions = paymentConditions;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDispatch() {
		return dispatch;
	}

	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public void Fill(){
		paymentConditions = "30/60/90";
		deliveryDate = "01/13";
		dispatch = "FOB";
	}
}
