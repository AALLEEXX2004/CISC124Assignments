import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestMoreMethods {

	@Test
	public void testConstructor() {
		Declet a = new Declet(-100);
		assertFalse(a.equals(null));
	}
	
	@Test
	public void testToDecimal() {
		Declet a = new Declet(-100);
		assertEquals("1110011100",a.toString());
	}

	@Test
	public void testIsNegative() {
		Declet a = new Declet(-52);
		assertTrue(a.isNegative());
	}

	@Test
	public void testCompareTo() {
		Declet a = new Declet(-500);
		Declet b = new Declet(500);
		assertTrue(a.compareTo(b) < 0);
	}

	@Test
	public void testCompareTo2() {
		Declet a = new Declet(100);
		Declet b = new Declet(20*5);
		assertTrue(a.compareTo(b) == 0);
	}

	@Test
	public void testCompareTo3() {
		Declet a = new Declet(300);
		Declet b = new Declet(0);
		assertEquals(1, a.compareTo(b));
	}

	@Test
	public void testEquals() {
		Declet a = new Declet(13);
		assertTrue(a.equals(a));
	}

	@Test
	public void testEquals1() {
		Object a = new Declet(13);
		assertTrue(a.equals(a));
	}

	@Test
	public void testEquals2() {
		Object a = new Object();
		Declet b = new Declet(13);
		assertFalse(b.equals(a));
	}
	
	@Test
	public void testAdd() {
		Declet a = new Declet(10);
		Declet b = new Declet(-13);
		a.add(b);
		assertEquals(-3,a.toDecimal());
	}
	
	@Test
	public void testAdd1() {
		Declet a = new Declet(510);
		Declet b = new Declet(100);
		a.add(b);
		assertEquals("1001100010",a.toString());
	}

	@Test
	public void testAdd2() {
		Declet a = new Declet(-100);
		Declet b = new Declet(-500);
		a.add(b);
		assertEquals("0110101000",a.toString());
	}

	
	@Test
	public void testNot() {
		Declet a = new Declet(-512);
		a.not();
		assertEquals(511,a.toDecimal());	
	}

}
