package ex05;

import java.math.BigDecimal;

public abstract class PaymentMethod {

	public abstract void validatePayment();

	public abstract void processPayment(BigDecimal amount);
}