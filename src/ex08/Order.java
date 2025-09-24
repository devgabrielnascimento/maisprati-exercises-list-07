package ex08;

import java.math.BigDecimal;

public class Order {

    private BigDecimal totalValue;
    private String cepDeliver;
    private ShippingCalculator shippingCalculator;


    public Order(BigDecimal totalValue, String cepDeliver, ShippingCalculator shippingCalculator) {
        this.totalValue = totalValue;
        this.cepDeliver = cepDeliver;
        this.shippingCalculator = shippingCalculator;
    }


    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public String getCepDeliver() {
        return cepDeliver;
    }


    public void setShippingCalculator(ShippingCalculator shippingCalculator) {
        this.shippingCalculator = shippingCalculator;
    }


    public BigDecimal calculateShipping() {
        return shippingCalculator.calculate(this);
    }
    
    
}
