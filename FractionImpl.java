package fraction;

public class FractionImpl implements Fraction {
    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
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
        try {
          denominator == 0;
        }
        catch( ArithmeticException exc ) {
          throw new ArithmeticException("Divide by zero");
        }

        int low = lcd(numerator, denominator);
        numerator /= low;
        denominator /= low;

        if (denominator < 0){
          numerator = -numerator;
          denominator = - denominator;
        }

        this.numerator = numerator;
        this.denominator = denominator;
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
        /*
        split about /
        strip and remove spaces from either end
        convert string to an intege
        if array length is equal to one the add denominator and returned
        if array is equal to one then pass it through previous method
        IN

        use:
        Integer(string).parseInt()
        */

        //ArrayList<Integer> wordListNew = new ArrayList<Integer>(fraction.split("/"));

        ArrayList<String> fracstring = new ArrayList<String>(Arrays.asList(string.split("/")));
        ArrayList<Integer> fracint = new ArrayList<Integer>(fracstring.size());

        for (int i = 0; i < fracstring.size(); i++){
          try{
            fracint.add(i, fracstring.get(i).trim());
          }
          catch ( NumberFormatException exc ){
            throw new NumberFormatException("Incorrect number format.");
          }
        }

        if (fracint.size() == 1){
          FractionImpl(fracint.get(0));
        }
        else{
          FractionImpl(fracint.get(0), fracint.get(1))
        }






    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        int num = numerator * f.denominator + denominator * f.numerator;
        int den = denominator * f.denominator;
        return new Fraction(num, den);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
      int num = numerator * f.denominator - denominator * f.numerator;
      int den = denominator * f.denominator;
      return new Fraction(num, den);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
      int num = numerator * f.numerator;
      int den = denominator * f.denominator;
      return new Fraction(num, den);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
      int num = numerator * f.denominator;
      int den = denominator * f.numerator;
      return new Fraction(num, den);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {            //???
      int num = abs(numerator);
      int den = abs(denominator);
      return new Fraction(num, den);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
      int num = 0 - numerator;
      int den = denominator;
      return new Fraction(num, den);
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

        return super.equals(obj);
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
      int num = denominator;
      int den = numerator;
      return new Fraction(num, den);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        return null;
    }


    private int lcd(int a, int b) {
    if (a == 0)
        return b;

    while (b != 0) {
        if (a > b)
            a = a - b;
        else
            b = b - a;
    }

    return a;
}
}
