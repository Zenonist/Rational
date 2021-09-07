class Rational {
    long numerator,denominator;

    class Illegal extends Exception {
        String reason;
        Illegal (String reason) {
            this.reason = reason;
        }
    }

    Rational() {
        // to be completed
        this.numerator = 1;
        this.denominator = 2;
    }

    Rational(long numerator, long denominator) throws Illegal {
        // to be completed
        this.numerator = numerator;
        this.denominator = denominator;
        if (this.denominator == 0){
            throw new Illegal("Denominator should not be 0");
        } else {
            simplestForm();
        }
    }

    // find the reduce form
    private void simplestForm() {
        long computeGCD;
        computeGCD = GCD(Math.abs(numerator), denominator);
        numerator /= computeGCD;
        denominator /= computeGCD;
    }

    // find the greatest common denominator
    private long GCD(long a, long b) {
        if (a%b ==0) return b;
        else return GCD(b,a%b);
    }

    /***
     * Compute an addition of the current rational number to another given rational number
     * @param x the rational number to be added to the current rational number
     */
    public void add(Rational x) {
        numerator = (numerator * x.denominator) + (x.numerator * denominator);
        denominator = (denominator * x.denominator);
        simplestForm();
    }

    /***
     * Compute a subtraction of the current rational number to another given rational number
     * @param x the rational number to be subtracted from the current rational number
     */
    public void subtract(Rational x) {
        // to be completed
        numerator = (numerator * x.denominator) - (x.numerator * denominator);
        denominator = (denominator * x.denominator);
        simplestForm();
    }

    /***
     * Compute a multiplication of the current rational number to another given rational number
     * @param x the rational number to be multiplied to the current rational number
     */
    public void multiply(Rational x) {
        // to be completed
        numerator = (numerator * x.numerator);
        denominator = (denominator * x.denominator);
        simplestForm();
    }

    /***
     * Compute a division of the current rational number to another given rational number
     * @param x the rational number to be divided by the current rational number
     */
    public void divide(Rational x) {
        // to be completed
        numerator = (numerator * x.denominator);
        denominator = (denominator * x.numerator);
        simplestForm();
    }

    /***
     * Check if the given rational number equals to the current rational number
     * @param x the rational number to be compared to the current rational number
     * @return true if the given rational number equals to the current, false otherwise
     */
    public boolean equals(Object x) {
        // to be completed
        try {
            Rational r = (Rational) x;
            if (numerator == r.numerator && denominator == r.denominator) {
                return true;
            } else {
                return false;
            }
        }catch (ClassCastException e){
            throw new ClassCastException();
        }


    }

    /***
     * Compare the current rational number to the current rational number
     * @param x the rational number to be compared to the current rational number
     * @return -1 if the current rational number is less than the given number, 0 if they're equal, 1 if the current
     * rational number is larger than the given number
     */
    public long compareTo(Object x) throws Illegal{
        // to be completed
        try{
            Rational r = (Rational) x;
            if (numerator == r.numerator && denominator == r.denominator) {
                return 0;
            } else if (numerator > r.numerator && denominator == r.denominator) {
                return -1;
            } else if (denominator < r.denominator) { //The smaller denominator means the that rational is larger < 1/2 && 1/3 >
                return -1;
            } else {
                return 1;
            }
        } catch (ClassCastException e){
            throw new Illegal("Object could not be casted to Rational");
        }


//        return -1; // TODO: this needs to be modified.
    }

    /***
     * Give the formatted string of the rational number
     * @return the string representation of the rational number. For example, "1/2", "3/4".
     */
    public String toString() {
        // to be completed "\""
        String result = this.numerator + "/" + this.denominator;
        return result; // TODO: This needs to be modified.
    }

    public static void main(String[] args) {
        System.out.println("This is Rational class.");
    }
}