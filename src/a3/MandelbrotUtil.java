package a3;

/**
 * This class provides a method for computing the number of iterations for which
 * z(n + 1) = z(n) * z(n) + c remains bounded where z(0) = 0 + 0i.
 *
 */
public class MandelbrotUtil {

	private MandelbrotUtil() {
		// A private constructor prevents users from creating a
		// MandelbrotUtil object.
	}

	/**
	 * Simple test method.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		Complex c = new Complex(0.0, 5.0);
		System.out.println(mandelbrotIterations(c, 100));
	}

	public static int mandelbrotIterations(Complex c, int max) {
		
	}
}
