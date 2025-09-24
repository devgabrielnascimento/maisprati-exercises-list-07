package ex08;

import java.math.BigDecimal;

public class StorePickupCalculator implements ShippingCalculator {

    @Override
    public BigDecimal calculate(Order order) {
        return BigDecimal.ZERO; 
    }
    
}