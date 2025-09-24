package ex06;

public class CartItem {

	private final Product product;
	private final int quantity;

	public CartItem(Product product, int quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("The item quantity could be greater than zero.");
		}
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

}
