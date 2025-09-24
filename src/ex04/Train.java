package ex04;

public class Train implements Vehicle {
	private int speed;
	private final int maxSpeed;
	
	public Train() {
		this.speed = 0;
		this.maxSpeed = 300;
	}
	
	
	   @Override
	    public void accelerate() {
	        if(this.speed < this.maxSpeed){
	            this.speed += 10;
	            System.out.println("Train accelerating. Current speed:  " + this.speed);
	        } else {
	            throw new IllegalStateException("The train reached the speed limit!");
	        }
	    }

	    @Override
	    public void brake() {
	        if(this.speed > 0) {
	            this.speed -= 10;
	            System.out.println("Train braking, current speed: " + this.speed);
	        }
	    }
}
