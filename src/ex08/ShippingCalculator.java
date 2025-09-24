package ex08;
import java.math.BigDecimal;
public interface ShippingCalculator {
	
	BigDecimal calculate(Order order);
}
