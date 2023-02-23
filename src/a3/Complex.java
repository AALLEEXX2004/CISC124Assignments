package a3;

/*
 * A class that represents complex numbers. 
 * In the complex number (a + bi) the real value a is called 
 * the real part of the complex number and 
 * the real value b is called the imaginary part of the complex number. 
 * This class provides methods to perform addition and multiplication of complex numbers.
 * */
public final class Complex {
	private double realPart;
	private double imagPart;
	
	/*
	 * Class constructor
	 * Initializes this complex number to (0 + 0i).
	 * */
	public Complex() {
		realPart = 0.0;
		imagPart = 0.0;
	}
	
	/*
	 * Class constructor
	 * Initializes this complex number so that it has the given real and imaginary components.
	 * 
	 * @param re - the real part of the complex number
	 * @param im - the imaginary part of the complex number
	 * */
	public Complex(double realPart,double imagPart) {
		this.realPart = realPart;
		this.imagPart = imagPart;
	}
	
	/*
	 * Class constructor
	 * Initializes this complex number so that it has the same real and imaginary parts as another complex number.
	 * 
	 * @param other - the complex number to copy
	 * */
	public Complex(Complex other) {
		this.realPart = other.realPart;
		this.imagPart = other.imagPart;
	}
	
	/*
	 * A static factory method that returns a new complex number whose 
	 * real part is equal to re and whose imaginary part is equal to 0.0
	 * 
	 * @param re - the desired real part of the complex number
	 * @return newC - a new complex number whose real part is equal to re and whose imaginary part is equal to 0.0
	 * */
	public static Complex real​(double re) {
		Complex newC = new Complex(re,0.0);
		return newC;
	}
	
	/*
	 * A static factory method that returns a new complex number whose 
	 * real part is equal to 0.0 and whose imaginary part is equal to im.
	 * 
	 * @param im - the desired imaginary part of the complex number
	 * @return newC - a new complex number whose real part is equal to 0.0 and whose imaginary part is equal to im
	 * */
	public static Complex imag​(double im) {
		Complex newC = new Complex(0.0,im);
		return newC;
	}
	
	/*
	 * Gets the real part of this complex number.
	 * 
	 * @return realPart - the real part of this complex number
	 * */
	public double re() {
		return realPart;
	}
	
	/*
	 * Sets the real part of this complex number.
	 * 
	 * @param val - the value to set the real part of this complex number to
	 * */
	public void re(double val) {
		realPart = val;
	}
	
	/*
	 * Gets the imaginary part of the complex number.
	 * 
	 * @return imagPart - the imaginary part of this complex number
	 * */
	public double im() {
		return imagPart;
	}
	
	/*
	 * Sets the imaginary part of this complex number.
	 * 
	 * @param val - the value to set the imaginary part of this complex number to
	 * */
	public void im(double val) {
		imagPart = val;
	}
	
	
	/*
	 * Adds this complex number and another complex number to obtain a new complex number. 
	 * Neither this complex number nor c is changed by this method.
	 * 
	 * @param c - The complex number to add to this complex number
	 * @return newC - a new complex number equal to the sum of this complex number and c
	 * */
	public Complex add(Complex c) {
		double newReal = realPart+c.re();
		double newImag = imagPart+c.im();
		Complex newC = new Complex(newReal,newImag);
		return newC;
	}
	
	/*
	 * Multiplies this complex number with another complex number to obtain a new complex number. 
	 * Neither this complex number nor c is changed by this method.
	 * 
	 * <p>
	 * This is not an industrial strength implementation of complex number multiplication. 
	 * In particular, issues related to the differences between -0.0 and 0.0 and infinite real or 
	 * imaginary parts are not taken into account.
	 * 
	 * @param c - The complex number to add to this complex number
	 * @return newC - a new complex number equal to the sum of this complex number and c
	 * */
	public Complex multiply​(Complex c) {
		double newReal = (realPart*c.re())-(imagPart*c.im());
		double newImag = imagPart*c.re()+realPart*c.im();
		Complex newC = new Complex(newReal,newImag);
		return newC;
	}
	
	/*
	 * Compute the magnitude of this complex number without intermediate underflow or overflow. 
	 * 
	 * @return magnitude - the magnitude of this complex number
	 * */
	public double mag() {
		double magnitude;
		magnitude = Math.hypot(this.re(), this.im());
		return magnitude;
	}
	
	/*
	 * Returns a string representation of this complex number.
	 * 
	 * <p>
	 * The returned string is the real part of the complex number, followed by a space, 
	 * followed by a + or - sign, followed by a space, 
	 * followed by the absolute value of the imaginary part of the complex number, 
	 * followed by an i. The sign is + if the imaginary part of the complex number is positive, 
	 * and - if the imaginary part of the complex number is negative. 
	 * For example the complex number with real and imaginary parts equal to zero has the string representation 0.0 + 0.0i. 
	 * The complex number with real part equal to zero and imaginary part equal to -1 has the string representation 0.0 - 1.0i.
	 * 
	 * @return a string representation of this complex number
	 * */
	public String toString() {
		String str;
		if(imagPart <0) {
			 str = realPart +" - "+(-imagPart)+"i";
		}else{
			 str = realPart +" + "+imagPart+"i";
		}
		
		return str;
	}
	
	
}
