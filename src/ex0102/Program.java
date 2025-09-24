package ex0102;

public class Program {
	public static void main(String[] args) {
        try {
            Product product = new Product("Bicycle", 349.99, 40);    
            product.showInfo();
            product.applyDiscount(30);
        } catch (InvalidDiscountException e) {
            System.out.println(e.getMessage());
        }
    }
}
