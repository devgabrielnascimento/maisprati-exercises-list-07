package ex04;

public class Bicycle implements Vehicle{
	
	private int speed;
	private final int maxSpeed;
	
	public Bicycle() {
		this.speed = 0;
		this.maxSpeed = 100;
	}
	
	
	
	   @Override
	    public void accelerate() {
	        if(this.speed < this.maxSpeed){
	            this.speed += 10;
	            System.out.println("Bicycle accelerating. Current speed:  " + this.speed);
	        } else {
	            throw new IllegalStateException("The bicycle reached the speed limit!");
	        }
	    }

	    @Override
	    public void brake() {
	        if(this.speed > 0) {
	            this.speed -= 10;
	            System.out.println("Bicycle braking, current speed: " + this.speed);
	        }
	    }

}
