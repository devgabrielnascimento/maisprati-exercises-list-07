package ex08;

import java.math.BigDecimal;

public class PacCalculator implements ShippingCalculator {

    @Override
    public BigDecimal calculate(Order order) {
        String region = order.getCepDeliver().substring(0, 2);
        switch (region) {
            case "SP": return new BigDecimal("10.00"); 
            case "RJ": return new BigDecimal("15.00"); 
            case "MG": return new BigDecimal("20.00"); 
            default: throw new InvalidCEPException("Invalid CEP for PAC.");
        }
    }
}
