/**
 * 
 */
package fractionTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Fraction.Fraction;

/**
 * @author Yeetboi
 *
 */
class fractionTest {

	@Test
	public void fractionMultTest() {
		Fraction a = new Fraction(1, 2);
		Fraction b = new Fraction(3, 4);
		Fraction res = a.multiply(b);
		assertTrue(res.getNumerator() == 3 && res.getDenominator() == 8);
	}
	
	@Test
	public void intMultTest() {
		Fraction a = new Fraction(3, 4);
		int b = 2;
		Fraction res = a.multiply(b);
		assertTrue(res.getNumerator() == 6 && res.getDenominator() == 4);
	}
	
	@Test
	public void zeroFracMultTest() {
		Fraction a = new Fraction(1, 2);
		Fraction b = new Fraction(0, 1);
		Fraction res = a.multiply(b);
		assertTrue(res.getNumerator() == 0);
	}
	
	@Test
	public void zeroIntMultTest() {
		Fraction a = new Fraction(1, 2);
		int b = 0;
		assertTrue(a.multiply(b).getNumerator() == 0);
	}
	
	@Test
	public void simplifyTest() {
		Fraction a = new Fraction (80, 100);
		a = a.simplify();
		assertTrue(a.getNumerator() == 4 && a.getDenominator() == 5);
	}
	
	@Test
	public void divZeroFractionTest() {
		Fraction a = new Fraction(1, 2);
		Fraction b = new Fraction(0);
		assertThrows(IllegalArgumentException.class, () -> {a.divide(b);});
	}
	
	@Test
	public void divZeroIntTest() {
		Fraction a = new Fraction(1, 2);
		int b = 0;
		assertThrows(IllegalArgumentException.class, () -> {a.divide(b);});
	}
	
	@Test
	public void divZeroByFractionTest() {
		Fraction a = new Fraction(0);
		Fraction b = new Fraction(1, 2);
		assertTrue(a.divide(b).getNumerator() == 0);
	}
	
	@Test
	public void divZeroByIntTest() {
		Fraction a = new Fraction(0);
		int b = 2;
		assertTrue(a.divide(b).getNumerator() == 0);
	}
	
	@Test
	public void powerPositiveTest() {
		Fraction a = new Fraction(1, 2);
		Fraction res = a.pow(3);
		assertTrue(res.getNumerator()==1 && res.getDenominator()==8);
	}
	
	@Test
	public void powerZeroTest() {
		Fraction a = new Fraction(1, 2);
		Fraction res = a.pow(0);
		assertTrue(res.getNumerator()==1 && res.getDenominator()==1);
	}
	
	@Test
	public void powerNegativeTest() {
		Fraction a = new Fraction(1, 2);
		Fraction res = a.pow(-3);
		assertTrue(res.getNumerator()==8 && res.getDenominator()==1);
	}
}
