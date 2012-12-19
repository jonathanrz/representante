package br.prax.representative.model;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
	
	private CustomerModel customer;
	private List<Product> products = new ArrayList<>();
	
	private class InvoiceProduct {
		
		private Product product;
		
	}
	
}
