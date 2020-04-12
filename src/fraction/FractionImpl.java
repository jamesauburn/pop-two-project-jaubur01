package fraction;

public class FractionImpl implements Fraction {
    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>fraction.Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */

    private int numerator;
    private int denominator;

    public FractionImpl(int numerator, int denominator) {
        if(denominator == 0){
            throw new ArithmeticException("Divide by zero");
        }

        this.numerator = numerator;
        this.denominator = denominator;
        norm();
    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {
        if (fraction.contains(" ")){
            fraction = fraction.replaceAll("\\s","");
        }
        if (fraction.contains("/")){
            String[] f = fraction.split("/");
            numerator = Integer.parseInt(f[0]);
            if(Integer.parseInt(f[1]) == 0){
                throw new ArithmeticException("Divide by zero");
            }
            else{
                denominator = Integer.parseInt(f[1]);
            }
        }
        else{
            numerator = Integer.parseInt(fraction);
            denominator = 1;
        }
        norm();
    }

    protected static int gcd(int numerator, int denominator){
        int num = numerator;
        int den = denominator;
        int temp  = 0;
        while (den != 0) {
            temp = den;
            den = num % den;
            num = temp;
        }
        return Math.abs(num);
    }

    protected void norm(){
        int low = gcd(numerator, denominator);
        if(denominator < 0) {
            denominator *= -1;
            numerator *= -1;
        }

        if(numerator == 0 && denominator > 1) {
            denominator = 1;
        }
        else{
            numerator = numerator / low;
            denominator = denominator / low;
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        int num = this.numerator * ((FractionImpl)f).denominator + this.denominator * ((FractionImpl)f).numerator;
        int den = this.denominator * ((FractionImpl)f).denominator;
        return new FractionImpl(num, den);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        int num = this.numerator * ((FractionImpl)f).denominator - this.denominator * ((FractionImpl)f).numerator;
        int den = this.denominator * ((FractionImpl)f).denominator;
        return new FractionImpl(num, den);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        int num = this.numerator * ((FractionImpl)f).numerator;
        int den = this.denominator * ((FractionImpl)f).denominator;
        return new FractionImpl(num, den);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        int num = this.numerator * ((FractionImpl)f).denominator;
        int den = this.denominator * ((FractionImpl)f).numerator;
        return new FractionImpl(num, den);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        int num = this.numerator;
        int den = this.denominator;
        if(num < 0){
            num = Math.abs(num);
        }
        return new FractionImpl(num, den);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        int num = -1 * this.numerator;
        int den = this.denominator;
        return new FractionImpl(num, den);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
//        if (this == obj){return true;}
        if(this.getClass() != obj.getClass()){
            return false;
        }
        FractionImpl fraction = (FractionImpl) obj;                               //check this
        if(this.numerator == fraction.numerator && this.denominator == fraction.denominator){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        int num = this.denominator;
        int den = this.numerator;
        return new FractionImpl(num, den);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {

        int tot1 = this.numerator * ((FractionImpl)o).denominator;
        int tot2 = ((FractionImpl)o).numerator * this.denominator;

        if(tot1 > tot1){
            return 1;
        }
        else if(tot1 < tot2){
            return -1;
        }
        else{
            return 0;
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        if (this.denominator == 1) {
            return Integer.toString(this.numerator);
        } else {
            return (this.numerator + "/" + this.denominator);
        }
    }
}