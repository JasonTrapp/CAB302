package applications.temperature;

import java.util.Random;

import patterns.observer.Subject;

/**
 * The Concrete Subject class for the Observer Pattern example 
 * @author Richard Thomas
 *
 */
public class TempSensor extends Subject {
	private double temp; 
	private double low; 
	private double high;
	private Random rng; 
 
	
	public TempSensor(long seed, double high, double low) {
		rng = new Random(seed); 
		this.high = high;
		this.low = low;
	}
	
	public void setState() {
		double range = high - low;
		temp = Math.round(rng.nextDouble() * range + low);
	}
	
	public String getState() {
		return Double.toString(temp);
	}

}
