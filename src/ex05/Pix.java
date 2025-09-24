package ex05;

import java.math.BigDecimal;

public class Pix extends PaymentMethod {

    private BigDecimal availableBalance;
    private PixKeyType keyType;
    private String key;
    
    public Pix(PixKeyType keyType, String key, BigDecimal availableBalance) {
        if (keyType == null) {
            throw new InvalidPaymentException("Pix key type cannot be null");
        }
        if (key == null || key.isBlank()) {
            throw new InvalidPaymentException("Pix key cannot be empty");
        }
        if (availableBalance == null || availableBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidPaymentException("Available balance must be positive");
        }

        this.keyType = keyType;
        this.key = key;
        this.availableBalance = availableBalance;
    }


    @Override
    public void validatePayment() {

        switch (keyType) {
            case EMAIL -> {
                if (!key.contains("@")) {
                    throw new InvalidPaymentException("Invalid email Pix key");
                }
            }
            case CPF -> {
                if (!key.matches("\\d{11}")) {
                    throw new InvalidPaymentException("Invalid CPF Pix key");
                }
            }
            case PHONE -> {
                if (!key.matches("\\+?\\d{10,15}")) {
                    throw new InvalidPaymentException("Invalid phone Pix key");
                }
            }
            default -> throw new InvalidPaymentException("Unknown Pix key type");
        }
    }

    @Override
    public void processPayment(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPaymentException("Payment amount must be positive");
        }
        if (availableBalance.compareTo(amount) < 0) {
            throw new InvalidPaymentException("Insufficient available balance");
        }

        availableBalance = availableBalance.subtract(amount);
        System.out.println("Pix payment of " + amount + " processed successfully to key: " + key);
    }


    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public String getKey() {
        return key;
    }

    public PixKeyType getKeyType() {
        return keyType;
    }

    public void showInfo() {
		System.out.println("KeyTipe: " + keyType);
		System.out.println("Available Balance: " + availableBalance.setScale(2));
	}
    

    public static void main(String[] args) {
        try {
            Pix pix = new Pix(PixKeyType.EMAIL, "gabriel@email.com", new BigDecimal("500"));
            pix.showInfo();
            pix.validatePayment();
            pix.processPayment(new BigDecimal("200"));
            pix.showInfo();
        } catch (InvalidPaymentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
