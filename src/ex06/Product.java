package ex06;

import java.util.Objects;

public class Product {
	private final String name;
	private final Money price;
	
	public Product(String name, Money price) {
		this.name = Objects.requireNonNull(name);
		this.price = Objects.requireNonNull(price);
	}




	public String getName() {
		return name;
	}

	public Money getPrice() {
		return  price;
	}
	
	
}
