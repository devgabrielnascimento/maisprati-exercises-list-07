package ex06;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Money {
	private final BigDecimal amount;
	private final Currency currency;

	public Money(BigDecimal amount, Currency currency) {
		if (amount == null || currency == null) {
			throw new IllegalArgumentException("Amount and currency cannot be null");
		}
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
		    throw new IllegalArgumentException("Amount cannot be negative");
		}
		this.amount = amount.setScale(2, RoundingMode.HALF_EVEN);
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	
	@Override
	public boolean equals(Object o) {
		if  (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Money money = (Money) o;
		return amount.equals(money.amount) && currency.equals(money.currency);
	}
	
	@Override
	public int hashCode () {
		return Objects.hash(amount, currency);
	}
}
