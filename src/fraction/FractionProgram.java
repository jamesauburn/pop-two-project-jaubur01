package fraction;

public class FractionProgram {
    public static void main(String[] arg){
        Fraction a = new FractionImpl(4, 5);
        Fraction b = new FractionImpl(5, 8);
        Fraction c = a.add(b);
        System.out.println(c);
        System.out.println(c.inverse());
        Fraction d = new FractionImpl(17, 10);
        Fraction e = c.subtract(d);
        System.out.println(e);
        System.out.println(b.abs());
        System.out.println(c.equals(e));

        Fraction A = new FractionImpl(4, 5);
        Fraction B = new FractionImpl(5, 8);
        Fraction C = A.multiply(B);
        System.out.println(C);
        System.out.println(B.abs());
        System.out.println(C.inverse());
        Fraction D = new FractionImpl(17, 10);
        Fraction E = C.divide(D);
        System.out.println(E);
        System.out.println(C.equals(E));

        System.out.println(a.compareTo(A));
        System.out.println(b.compareTo(B));
        System.out.println(c.compareTo(C));
    }
}
