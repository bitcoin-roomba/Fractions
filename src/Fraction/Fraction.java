package Fraction;
import java.math.BigInteger;

/**
 * @author yeet-hard-yote-harder
 * Fraction class for Java, allows arithmetic with other fractions and integers. As of yet completely untested and mostly undocumented
 * 
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
	public Fraction(int numerator, int denominator) {
		if (denominator == 0) {
			throw new IllegalArgumentException("divide by zero");
		}
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public Fraction(int number) {
		this.numerator = number;
		this.denominator = 1;
	}
	
	//operations
	public Fraction simplify() {
		BigInteger num = BigInteger.valueOf(this.numerator);
	    BigInteger den = BigInteger.valueOf(this.denominator);
	    BigInteger gcd = num.gcd(den);
	    return new Fraction(this.numerator / gcd.intValueExact(), this.denominator / gcd.intValueExact());
	}
	
	public boolean isInteger() {
		return this.numerator == this.denominator;
	}
		
	public Fraction multiply(Fraction factor) {
		return new Fraction(this.numerator * factor.numerator, this.denominator * factor.denominator);
	}
	
	public Fraction multiply(int factor) {
		return new Fraction(this.numerator * factor, this.denominator);
	}
	
	public Fraction divide(Fraction divisor) {
		if (divisor.getNumerator() == 0) {
			throw new IllegalArgumentException("divide by zero");
		}
		return new Fraction(this.numerator * divisor.denominator, this.denominator * divisor.numerator);
	}
	
	public Fraction divide(int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException("divide by zero");
		}
		return new Fraction(this.numerator, this.denominator * divisor);
	}
	
	public Fraction add(Fraction summand) {
		return new Fraction((this.numerator * summand.denominator) + (summand.numerator * this.denominator), this.denominator * summand.denominator);
	}
	
	public Fraction subtract(Fraction subtrahend) {
		return new Fraction((this.numerator * subtrahend.denominator) - (subtrahend.numerator * this.denominator), this.denominator * subtrahend.denominator);
	}
	
	public Fraction add(int summand) {
		return new Fraction(this.numerator + (this.denominator * summand), this.denominator);
	}
	
	public Fraction subtract(int subtrahend) {
		return new Fraction(this.numerator - (this.denominator * subtrahend), this.denominator);
	}
	
	public int lowestCommonDenominator(Fraction other) {
		return (this.simplify().denominator * other.simplify().denominator);
	}
	
	
}
