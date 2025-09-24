package ex08;

import java.math.BigDecimal;

public class Program {

	public static void main(String[] args) {
		Order order = new Order(new BigDecimal("250"), "SP123456", new SedexCalculator());

		order.setShippingCalculator(
				o -> o.getTotalValue().compareTo(new BigDecimal("200")) > 0 ? BigDecimal.ZERO : new BigDecimal("20"));

		System.out.println("Ship: " + order.calculateShipping());
	}

}
