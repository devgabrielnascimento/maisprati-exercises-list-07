package ex05;

import java.math.BigDecimal;
import java.time.YearMonth;

class InvalidPaymentException extends IllegalArgumentException {
	public InvalidPaymentException(String message) {
		super(message);
	}
}

public class CreditCard extends PaymentMethod {

	private String cardNumber;
	private String cardHolderName;
	private YearMonth expirationDate;
	private BigDecimal creditLimit;
	private BigDecimal availableBalance;

	public void setCardNumber(String cardNumber) {
		if (cardNumber == null || !cardNumber.matches("\\d{16}")) {
			throw new InvalidPaymentException("Card number must be exactly 16 digits");
		}
		this.cardNumber = cardNumber;
	}

	public void setCardHolderName(String cardHolderName) {
		if (cardHolderName == null || cardHolderName.isBlank()) {
			throw new InvalidPaymentException("Card holder name cannot be empty");
		}
		this.cardHolderName = cardHolderName;
	}

	public void setExpirationDate(YearMonth expirationDate) {
		if (expirationDate == null || expirationDate.isBefore(YearMonth.now())) {
			throw new InvalidPaymentException("Card is expired or date is invalid");
		}
		this.expirationDate = expirationDate;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		if (creditLimit == null || creditLimit.compareTo(BigDecimal.ZERO) <= 0) {
			throw new InvalidPaymentException("Credit limit must be positive");
		}
		this.creditLimit = creditLimit;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		if (availableBalance == null || availableBalance.compareTo(BigDecimal.ZERO) < 0) {
			throw new InvalidPaymentException("Available balance must be positive");
		}
		if (creditLimit != null && availableBalance.compareTo(creditLimit) > 0) {
			throw new InvalidPaymentException("Available balance cannot exceed credit limit");
		}
		this.availableBalance = availableBalance;
	}

	@Override
	public void validatePayment() {
		setCardNumber(this.cardNumber);
		setCardHolderName(this.cardHolderName);
		setExpirationDate(this.expirationDate);
		setCreditLimit(this.creditLimit);
		setAvailableBalance(this.availableBalance);
	}

	@Override
	public void processPayment(BigDecimal amount) {
		if (amount == null) {
			throw new InvalidPaymentException("Payment amount cannot be null");
		}
		if (amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new InvalidPaymentException("Payment amount must be positive");
		}
		if (availableBalance.compareTo(amount) < 0) {
			throw new InvalidPaymentException("Insufficient available balance");
		}
		availableBalance = availableBalance.subtract(amount);
		System.out.println("Payment of " + amount + " processed successfully.");
	}

	public void showInfo() {
		System.out.println("Card Number: " + cardNumber);
		System.out.println("Card Holder: " + cardHolderName);
		System.out.println("Expiration Date: " + expirationDate);
		System.out.println("Credit Limit: " + creditLimit.setScale(2));
		System.out.println("Available Balance: " + availableBalance.setScale(2));
	}

	public static void main(String[] args) {
		try {
			CreditCard creditCard = new CreditCard();
			creditCard.setCardNumber("1012101210121012");
			creditCard.setCardHolderName("Gabriel");
			creditCard.setExpirationDate(YearMonth.of(2025, 12));
			creditCard.setCreditLimit(new BigDecimal("1200"));
			creditCard.setAvailableBalance(new BigDecimal("1000"));
			creditCard.validatePayment();
			creditCard.processPayment(new BigDecimal("200"));
			creditCard.showInfo();
		} catch (InvalidPaymentException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
