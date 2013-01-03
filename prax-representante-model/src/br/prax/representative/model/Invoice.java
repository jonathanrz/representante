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

	public void Fill(){
		customer = new Customer();
		customer.FillWithMyData();
		billDetails = new BillDetails();
		billDetails.Fill();
		representative = new Representative();
		representative.setTitulo("JR");
		representative.setSubTitulo("Representações");
		representative.setName("Jair Antônio");
		representative.setFone("Fone: (47)9658-2140 / 3232-0378");
		representative.setEmail("jair.bnu@hotmail.com");
		
		InvoiceItem item = new InvoiceItem();
		item.setReference("189");
		item.setColor("Marinho Escuro");
		item.setQuantity(1, 2, 1, 3);
		item.setUnitValue(5103);
		items.add(item);
		item = new InvoiceItem();
		item.setReference("190");
		item.setColor("Vermelho");
		item.setQuantity(2, 1, 3, 1);
		item.setUnitValue(6120);
		items.add(item);
		item = new InvoiceItem();
		item.setReference("Verde Militar");
		item.setColor("Cinza");
		item.setQuantity(1, 2, 3, 1);
		item.setUnitValue(11200);
		item = new InvoiceItem();
		item.setReference("254");
		item.setColor("Preto");
		item.setQuantity(2, 2, 3, 4);
		item.setUnitValue(11300);
		items.add(item);
		item = new InvoiceItem();
		item.setReference("258");
		item.setColor("Amarelo");
		item.setQuantity(1, 1, 1, 1);
		item.setUnitValue(9800);
		items.add(item);
	}
}
