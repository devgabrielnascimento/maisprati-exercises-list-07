package ex04;

public class Car implements Vehicle {

	private int speed;
	private final int maxSpeed;

	public Car() {
		this.speed = 0;
		this.maxSpeed = 200;
	}

	@Override
	public void accelerate() {
		if (this.speed < this.maxSpeed) {
			this.speed += 10;
			System.out.println("Car accelerating. Current speed:  " + this.speed);
		} else {
			throw new IllegalStateException("The car reached the speed limit!");
		}
	}

	@Override
	public void brake() {
		if (this.speed > 0) {
			this.speed -= 10;
			System.out.println("Car braking, current speed: " + this.speed);
		}
	}
}
