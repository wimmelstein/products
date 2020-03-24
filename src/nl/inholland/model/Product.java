package nl.inholland.model;

public class Product {

	private String name;
	private int stock;
	private double price;
	
	public Product(String name, int stock, double price) {
		super();
		this.name = name;
		this.stock = stock;
		this.price = price;
	}
	
	public Product() {
		this.name = ""; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [name=").append(name).append(", stock=").append(stock).append(", price=").append(price)
				.append("]");
		return builder.toString();
	}
	
	

}
