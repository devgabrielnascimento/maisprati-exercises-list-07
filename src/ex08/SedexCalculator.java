package ex08;

import java.math.BigDecimal;

public class SedexCalculator implements ShippingCalculator {

    @Override
    public BigDecimal calculate(Order order) {
        String regiao = order.getCepDeliver().substring(0, 2);
        switch (regiao) {
            case "SP": return new BigDecimal("15.00");
            case "RJ": return new BigDecimal("20.00");
            case "MG": return new BigDecimal("25.00");
            default: throw new InvalidCEPException("Invalid CEP for Sedex.");
        }
    }
}
