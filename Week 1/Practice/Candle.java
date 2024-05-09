public class Candle 
{
	// attributes
	public String color;
	public int height;
	public double diameter;
	public boolean isLit;
	
	// constructor
	public Candle(String color, int height, double diameter) {
		// Can do validation that height and diameter are not less than 0
		if (height <= 0 || diameter <= 0) {
			System.out.println("Height and diameter must be greater than 0. No values have been set");
			return; // this should be an exception to be covered later in the course
		}
		// set values
		this.color = color;
		this.height = height;
		this.diameter = diameter;
		// candle state must be unlit
		isLit = false;
	}

	// method to light candle
	public void lightCandle() {
		if (isLit) // validation
			System.out.println("Candle is already lit");
		else
			isLit = true;
	}

	// method to extinguish candle
	public void extinguishCandle() {
		if (!isLit) // validation
			System.out.println("Candle is already extinguished");
		else
			isLit = false;
	}

	// method to change height (e.g. as it burns may need to update height)
	public void updateHeight(int height) {
		// validate
		if (height > this.height || height <= 0)
			System.out.println("New candle height must be less than current height but greater than 0");
		else
			this.height = height;
	}

	public String toString() {
		return "Candle [color=" + color + ", height=" + height + ", diameter=" + diameter + ", isLit=" + isLit + "]";
	}
}