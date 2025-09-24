package ex0102;

public class Product {

	private String name;
	private double price;
	private int availableStock;

	public Product(String name, double price, int availableStock) {
		this.name = name;
		this.price = price;
		this.availableStock = availableStock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("The name could not be empty ot null.");
		}
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price < 0) {
			throw new IllegalArgumentException("The price could be greater or equal than 0.");
		}
		this.price = price;
	}

	public int getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(int availableStock) {
		if (availableStock < 0) {
			throw new IllegalArgumentException("The available stock could be greater or equal than 0.");
		}
		this.availableStock = availableStock;
	}

	public void showInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("Price: " + this.price);
		System.out.println("Available Stock: " + this.availableStock);
	}

	public void applyDiscount(double percentage) {
		if (percentage < 0 || percentage > 50) {
			throw new InvalidDiscountException("The discount percentage is invalid.");
		} else {
			this.price = this.price - (this.price * (percentage / 100));
			System.out.println("After the discount: ");
			showInfo();
		}
	}

}
