package ex03;

import java.math.BigDecimal;

public abstract class Employee {

	protected String name;
	protected BigDecimal salary;
	public Employee(String name, BigDecimal salary) {
		
		if(salary.compareTo(BigDecimal.ZERO)  <= 0) {
			throw new  IllegalArgumentException("Salary could be positive");
		}
		this.name = name;
		this.salary = salary;
	}

	public abstract BigDecimal calculateBonus();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
}




