package model;

public class Line {
	private Product product;
	private int quantity;
	private double discount;
	
	public Line (Product product) {
		this.product = product;
		this.quantity = 1;
	}
	
	public void addOne() {
		this.quantity += 1;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getProductName() {
		return product.getName();
	}
	public double getPrice() {
		return product.getRetailPrice();
	}
	public String getBarcode() {
		return product.getBarcode();
	}
}
