package Fraction;
import java.math.BigInteger;

/**
 * @author yeetboi
 * All static methods offer the same functionality as their nonstatic counterparts but without modifying input variables unlike their nonstatic counterparts, 
 * which will modify the calling instance. Fraction.lowestCommonDenominator, despite being nonstatic, does not modify input variables.
 *
 */
public class Fraction {

	private int numerator;
	private int denominator;
	
	//getters, setters
	public int getNumerator() {
		return numerator;
	}
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	public void setDenominator(int denominator) {
		if (denominator == 0) {
			throw new IllegalArgumentException("divide by zero");
		}
		this.denominator = denominator;
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
	
	//nonstatic methods
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
		this.numerator *= factor.numerator;
		this.denominator *= factor.denominator;
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
		Fraction a = new Fraction(this.numerator, this.denominator);
		Fraction b = new Fraction(other.numerator, other.denominator);
		a.simplify();
		b.simplify();
		return (a.denominator * b.denominator);
	}
	
	
	//static methods
	static Fraction multiply(Fraction a, Fraction b) {
		Fraction res = new Fraction(a.getNumerator(), a.getDenominator());
		res.multiply(b);
		return res;
	}
	
	static Fraction multiply(Fraction a, int b) {
		Fraction res = new Fraction(a.getNumerator(), a.getDenominator());
		res.multiply(b);
		return res;
	}
	
	static Fraction divide(Fraction a, Fraction b) {
		Fraction res = new Fraction(a.getNumerator(), a.getDenominator());
		res.divide(b);
		return res;
	}
	
	static Fraction divide(Fraction a, int b) {
		Fraction res = new Fraction(a.getNumerator(), a.getDenominator());
		res.divide(b);
		return res;
	}
	
	static Fraction add(Fraction a, Fraction b) {
		Fraction res = new Fraction(a.getNumerator(), a.getDenominator());
		res.add(b);
		return res;
	}
	
	static Fraction add(Fraction a, int b) {
		Fraction res = new Fraction(a.getNumerator(), a.getDenominator());
		res.add(b);
		return res;
	}
	
	static Fraction subtract(Fraction a, Fraction b) {
		Fraction res = new Fraction(a.getNumerator(), a.getDenominator());
		res.subtract(b);
		return res;
	}
	
	static Fraction subtract(Fraction a, int b) {
		Fraction res = new Fraction(a.getNumerator(), a.getDenominator());
		res.subtract(b);
		return res;
	}
	
	
	
	
}
