package ex03;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {

		Employee manager = new Manager("Lucas", new BigDecimal("7000"));
		Employee developer = new Developer("Gabriel", new BigDecimal("2500"));

		List<Employee> employees = new ArrayList<>();
		
		employees.add(manager);
		employees.add(developer);
		
		System.out.println("----------------------------------");
		for(Employee employee : employees) {
			System.out.println("Funcionário: " + employee.getName());
            System.out.println("Salário: " + employee.getSalary());
            System.out.println("Bônus: " + employee.calculateBonus());
            System.out.println("----------------------------------");
		}

	}

}
