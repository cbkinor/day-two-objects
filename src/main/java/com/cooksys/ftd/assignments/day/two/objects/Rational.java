package com.cooksys.ftd.assignments.day.two.objects;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Rational implements IRational {
    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * No simplification of the numerator/denominator pair should occur in this method.
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
	private int num;
	private int den;
	
    public Rational(int numerator, int denominator) throws IllegalArgumentException {
    	if(denominator == 0)
    	{
    		throw new IllegalArgumentException();
    	}
    	else
    	{
        num = numerator;
        den = denominator;
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
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public Rational construct(int numerator, int denominator) throws IllegalArgumentException {
    	if(denominator == 0)
    	{
    		throw new IllegalArgumentException("this is not a legal argument");
    	}
    	Rational r = new Rational(numerator, denominator);
		return r;
    }

    /**
     * @param obj the object to check this against for equality
     * @return true if the given obj is a rational value and its
     * numerator and denominator are equal to this rational value's numerator and denominator,
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) {
    	try{
    		
    	
    	if (obj instanceof Rational) {
			Rational obj1 = (Rational) obj;
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
	    	}catch (ArithmeticException e){
	    		 System.out.println("Error: Don't divide a number by zero");
				
	    	}
    	return false;
    }

    /**
     * If this is positive, the string should be of the form `numerator/denominator`
     * <p>
     * If this is negative, the string should be of the form `-numerator/denominator`
     *
     * @return a string representation of this rational value
     */
    @Override
    public String toString() {
    	 if ((getNumerator() < 0 != getDenominator() < 0))
    		 return "-" + Math.abs(getNumerator()) + "/" + Math.abs(getDenominator());
		else
			return Math.abs(getNumerator()) + "/" + Math.abs(getDenominator());
    }
}
