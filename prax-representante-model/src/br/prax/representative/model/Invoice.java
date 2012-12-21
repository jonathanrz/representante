package br.prax.representative.model;

import java.util.ArrayList;
import java.util.List;

//Pedido = Invoice
public class Invoice {

	private int invoiceCode; // pk

	private int invoiceNumber; // numero do pedido, poderia ser o invoiceCode?
	private Representative representative;
	private Customer customer;
	private RepresentedCompany representedCompany;

	private BillDetails billDetails;
	private List<InvoiceItem> items = new ArrayList<>();

	public Representative getRepresentative() {
		return representative;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public int getInvoiceCode() {
		return invoiceCode;
	}

	public void setInvoiceCode(int invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public void setRepresentative(Representative representative) {
		this.representative = representative;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public RepresentedCompany getRepresentedCompany() {
		return representedCompany;
	}

	public void setRepresentedCompany(RepresentedCompany representedCompany) {
		this.representedCompany = representedCompany;
	}

	public BillDetails getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(BillDetails billDetails) {
		this.billDetails = billDetails;
	}

	public List<InvoiceItem> getItems() {
		return items;
	}

	public void setItems(List<InvoiceItem> items) {
		this.items = items;
	}

}
