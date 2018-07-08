package Fraction;
import java.math.BigInteger;
import java.util.Objects;

/**
 * @author bitcoin-roomba
 * Fraction class for Java, allows arithmetic with other fractions and integers, as well as some other utility. As of yet completely untested and mostly undocumented.
 * Fractions are immutable.
 *
 */
public class Fraction {

	private int numerator;
	private int denominator;
	
	//getters
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	
	//constructors
	/**
	 * Creates a Fraction with a numerator and a denominator, as such that Fraction(x,y) would be equivalent to x/y.
	 * @throws IllegalArgumentException if denominator == 0
	 * @param numerator the numerator
	 * @param denominator the denominator
	 */
	public Fraction(int numerator, int denominator) {
		if (denominator == 0) {
			throw new IllegalArgumentException("divide by zero");
		}
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	/**
	 * Creates a fraction out of an integer, as such that an integer x would be expressed as x/1
	 * @param number Integer
	 */
	public Fraction(int number) {
		this.numerator = number;
		this.denominator = 1;
	}
	
	//operations
	/**
	 * Simplifies the fraction as far as possible. E.g. Fraction(6, 8).simplify returns Fraction (3, 4) as 6/8 == 3/4
	 * @return simplified Fraction
	 */
	public Fraction simplify() {
		if (this.numerator == 0) {
			return new Fraction(0);
		}
		BigInteger num = BigInteger.valueOf(this.numerator);
	    BigInteger den = BigInteger.valueOf(this.denominator);
	    BigInteger gcd = num.gcd(den);
	    return new Fraction(this.numerator / gcd.intValueExact(), this.denominator / gcd.intValueExact());
	}
	
	/**
	 * Checks if the fraction can be expressed as an integer, e.g. 4/4 or 9/9. If true, Fraction x is equivalent to x.getNumerator()
	 * @return Returns true if the fraction can be expressed as an integer
	 */
	public boolean isInteger() {
		return this.numerator == this.denominator;
	}
	
	/**
	 * Multiplies the Fraction with another Fraction.
	 * @param factor other Fraction
	 * @return product of both fractions
	 */
	public Fraction multiply(Fraction factor) {
		return new Fraction(this.numerator * factor.numerator, this.denominator * factor.denominator);
	}
	
	/**
	 * Multiplies the Fraction with an integer
	 * @param factor integer
	 * @return Product of fraction and integer
	 */
	public Fraction multiply(int factor) {
		return new Fraction(this.numerator * factor, this.denominator);
	}
	
	/**
	 * Divides the Fraction by another Fraction.
	 * @throws IllegalArgumentException if the divisor is equal to zero e.g. divisor = 0/2
	 * @param divisor divisor, fraction to be divided by.
	 * @return Quotient of this and divisor
	 */
	public Fraction divide(Fraction divisor) {
		if (divisor.getNumerator() == 0) {
			throw new IllegalArgumentException("divide by zero");
		}
		return new Fraction(this.numerator * divisor.denominator, this.denominator * divisor.numerator);
	}
	
	/**
	 * Divides the Fraction by an integer
	 * @throws IllegalArgumentException if divisor == 0
	 * @param divisor divisor, integer to be divided by.
	 * @return Quotient of this and divisor
	 */
	public Fraction divide(int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException("divide by zero");
		}
		return new Fraction(this.numerator, this.denominator * divisor);
	}
	
	/**
	 * Adds a Fraction to another Fraction
	 * @param summand Fraction to be added to this
	 * @return sum of both fractions
	 */
	public Fraction add(Fraction summand) {
		return new Fraction((this.numerator * summand.denominator) + (summand.numerator * this.denominator), this.denominator * summand.denominator);
	}
	
	/**
	 * Subtracts a Fraction from this Fraction
	 * @param subtrahend Fraction to be subtracted from this
	 * @return difference of both fractions, (this - subtrahend)
	 */
	public Fraction subtract(Fraction subtrahend) {
		return new Fraction((this.numerator * subtrahend.denominator) - (subtrahend.numerator * this.denominator), this.denominator * subtrahend.denominator);
	}
	
	/**
	 * Adds an integer to a Fraction
	 * @param summand integer to be added to this
	 * @return sum of fraction and integer
	 */
	public Fraction add(int summand) {
		return new Fraction(this.numerator + (this.denominator * summand), this.denominator);
	}
	
	/**
	 * Subtracts an integer from a Fraction
	 * @param subtrahend integer to be subtracted from this
	 * @return difference between fraction and integer (this - subtrahend)
	 */
	public Fraction subtract(int subtrahend) {
		return new Fraction(this.numerator - (this.denominator * subtrahend), this.denominator);
	}
	
	/**
	 * Finds the lowest common denominator between this and another fraction.
	 * @param other other fraction
	 * @return lowest common denominator as integer
	 */
	public int lowestCommonDenominator(Fraction other) {
		return (this.simplify().denominator * other.simplify().denominator);
	}
	
	/**
	 * Returns the inverse of the fraction if fraction is nonzero, such that for a fraction x, x * x.inverse() is equivalent to 1
	 * @throws IllegalArgumentException if fraction is equivalent to zero 
	 * @return Inverse of this
	 */
	public Fraction inverse() {
		if (this.numerator == 0) {
			throw new IllegalArgumentException("divide by zero");
		}
		return new Fraction(this.denominator, this.numerator);
	}
	
	/**
	 * Raises a fraction to the power of an integer, simplifies as far as possible
	 * @throws IllegalArgumentException if fraction equivalent to 0 AND exponent is negative
	 * @param exponent power to raise to
	 * @return this to the power of exponent
	 */
	public Fraction pow(int exponent) {
		if (exponent >= 0) {
			return pospow(this.simplify(), exponent);
		}
		else return pospow(this.inverse().simplify(), -exponent);
	}
	//pow for nonnegative exponents
	private Fraction pospow(Fraction f, int exp) {
		Fraction out = new Fraction(1);
		for (int i = 1; i <= exp; i++) {
			out = out.multiply(f);
			//simplify to maximise usage of 32 bit int
			out = out.simplify();
		}
		return out;
	}
	
	
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Fraction)) {
			return false;
		}
		Fraction check = (Fraction) other;
		check = check.simplify();
		Fraction current = this.simplify();
		return(current.numerator == check.numerator && current.denominator == check.denominator);
	}
	
	@Override
	public int hashCode() {
		Fraction check = this.simplify();
		return Objects.hash(check.numerator, check.denominator);
	}
	
	
	
}
