package ex03;

import java.math.BigDecimal;

public class Manager extends Employee{

public Manager(String name, BigDecimal salary) {
	super(name,salary);
}

@Override
public BigDecimal calculateBonus() {
	return salary.multiply(new BigDecimal("0.20"));
}

}
