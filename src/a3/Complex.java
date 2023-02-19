package a3;


public final class Complex {
	private double realPart;
	private double imagPart;
	public Complex() {
	
	}
	public Complex(double realPart,double imagPart) {
		this.realPart = realPart;
		this.imagPart = imagPart;
	}
	public Complex(Complex other) {
		this.realPart = other.realPart;
		this.imagPart = other.imagPart;
	}
	public double[] re() {}
	public double[] im() {}
	public void assertEquals(String string, double second, double[] im, double ulp) {
		// TODO Auto-generated method stub
		
	}
}
