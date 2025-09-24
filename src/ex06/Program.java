package ex06;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		 Product laptop = new Product("Laptop", new Money(new BigDecimal("5000.00"), Currency.BRL));
	        Product mouse = new Product("Mouse", new Money(new BigDecimal("150.00"), Currency.BRL));
	        Product keyboard = new Product("Keyboard", new Money(new BigDecimal("300.00"), Currency.BRL));


	        CartItem item1 = new CartItem(laptop, 1);
	        CartItem item2 = new CartItem(mouse, 2);
	        CartItem item3 = new CartItem(keyboard, 1);


	        Cart cart = new Cart(new ArrayList<>(), BigDecimal.ZERO);


	        cart = cart.add(item1).add(item2).add(item3);

	        cart = cart.applyCoupon(new BigDecimal("0.20"));


	        Money total = cart.calculateTotal();

	        cart.showInfo();

	        System.out.println("Applied Discount: " + cart.getCouponDiscount().multiply(new BigDecimal("100")) + "%");
	        System.out.println("Total: " + total.getAmount() + " " + total.getCurrency());

	}

}
