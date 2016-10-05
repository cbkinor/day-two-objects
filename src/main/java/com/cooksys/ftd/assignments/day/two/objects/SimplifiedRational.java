package com.cooksys.ftd.assignments.day.two.objects;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SimplifiedRational implements IRational {
	private int num;
	private int den;

	/**
	 * Determines the greatest common denominator for the given values
	 *
	 * @param a
	 *            the first value to consider
	 * @param b
	 *            the second value to consider
	 * @return the greatest common denominator, or shared factor, of `a` and `b`
	 * @throws IllegalArgumentException
	 *             if a <= 0 or b < 0
	 */
	public static int gcd(int a, int b) throws IllegalArgumentException {
		if (a <= 0 || b < 0) {
			throw new IllegalArgumentException("your argument is incorrect");
		} else if (a == 0 || b == 0) {
			return a + b;
		}
		return gcd(b, a % b);

	}

	/**
	 * Simplifies the numerator and denominator of a rational value.
	 * <p>
	 * For example: `simplify(10, 100) = [1, 10]` or: `simplify(0, 10) = [0, 1]`
	 *
	 * @param numerator
	 *            the numerator of the rational value to simplify
	 * @param denominator
	 *            the denominator of the rational value to simplify
	 * @return a two element array representation of the simplified numerator
	 *         and denominator
	 * @throws IllegalArgumentException
	 *             if the given denominator is 0
	 */
	public static int[] simplify(int numerator, int denominator) throws IllegalArgumentException {
		if (denominator == 0) {
			throw new IllegalArgumentException("this is not a legal argument");
		}
		// IF STATEMENT
		if (numerator == 0)
			return new int[] { numerator, denominator };

		int multiplyer = gcd(Math.abs(numerator), Math.abs(denominator));
		int[] sr = new int[] { numerator / multiplyer, denominator / multiplyer };
		return sr;
	}

	/**
	 * Constructor for rational values of the type:
	 * <p>
	 * `numerator / denominator`
	 * <p>
	 * Simplification of numerator/denominator pair should occur in this method.
	 * If the numerator is zero, no further simplification can be performed
	 *
	 * @param numerator
	 *            the numerator of the rational value
	 * @param denominator
	 *            the denominator of the rational value
	 * @throws IllegalArgumentException
	 *             if the given denominator is 0
	 */
	public SimplifiedRational(int numerator, int denominator) throws IllegalArgumentException {
		if (denominator == 0) {
			throw new IllegalArgumentException("this is not a legal argument");
		} else {
			int[] simplifiedRatio = simplify(numerator, denominator);
			num = simplifiedRatio[0];
			den = simplifiedRatio[1];
		}

	}

	/**
	 * @return the numerator of this rational number
	 */
	@Override
	public int getNumerator() {
		return num;
	}

	/**
	 * @return the denominator of this rational number
	 */
	@Override
	public int getDenominator() {
		return den;
	}

	/**
	 * Specializable constructor to take advantage of shared code between
	 * Rational and SimplifiedRational
	 * <p>
	 * Essentially, this method allows us to implement most of IRational methods
	 * directly in the interface while preserving the underlying type
	 *
	 * @param numerator
	 *            the numerator of the rational value to construct
	 * @param denominator
	 *            the denominator of the rational value to construct
	 * @return the constructed rational value (specifically, a
	 *         SimplifiedRational value)
	 * @throws IllegalArgumentException
	 *             if the given denominator is 0
	 */
	@Override
	public SimplifiedRational construct(int numerator, int denominator) throws IllegalArgumentException {
		if (denominator == 0) {
			throw new IllegalArgumentException("this is not a legal argument");
		}
		SimplifiedRational sr = new SimplifiedRational(numerator, denominator);
		return sr;
	}

	/**
	 * @param obj
	 *            the object to check this against for equality
	 * @return true if the given obj is a rational value and its numerator and
	 *         denominator are equal to this rational value's numerator and
	 *         denominator, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		try {

			if (obj instanceof SimplifiedRational) {
				SimplifiedRational obj1 = (SimplifiedRational) obj;
				int n2 = obj1.getNumerator();
				int d2 = obj1.getDenominator();

				if (d2 == 0) {
					return false;
				}
				if ((num == n2 && den == d2)) {
					return true;
				}
				return false;
			}
		} catch (ArithmeticException e) {
			System.out.println("Error: Don't divide a number by zero");

		}
		return false;
		
		// another way
		//if (obj == null || !(obj instanceof IRational))
		//	return false;
		//return (((IRational) obj).getNumerator() == this.numerator)  // cast IRational to access getNumerator
		//&& (((IRational) obj).getDenominator() == this.denominator)
	}

	/**
	 * If this is positive, the string should be of the form
	 * `numerator/denominator`
	 * <p>
	 * If this is negative, the string should be of the form
	 * `-numerator/denominator`
	 *
	 * @return a string representation of this rational value
	 */
	@Override
	public String toString() {
		if (getNumerator() == 0) {
			return "0";
		} else if ((getNumerator() > 0 && getDenominator() > 0) || (getNumerator() < 0 && getDenominator() < 0))
			return Math.abs(getNumerator()) + "/" + Math.abs(getDenominator());
		else
			return "-" + Math.abs(getNumerator()) + "/" + Math.abs(getDenominator());
	}
}
