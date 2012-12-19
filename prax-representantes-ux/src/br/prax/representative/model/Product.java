package br.prax.representative.model;

import java.util.List;

public class Product {
	
	private int id;
	private String name;
	private double price;
	private String category;
	
	private List<ProductDetail> details;
	private List<ProductGrade> grade;
	
	private class ProductDetail {
		private String name;
		private Object value;
		private FieldType type;
	}
	
	private class ProductGrade {
		private String gradeName;
		private Object gradeValue;
		private GradeType gradeType;
	}
	
	private enum FieldType {
		
	}
	
	private enum GradeType {
	}
	
}
