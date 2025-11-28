package math;

public class MainMathTest {
    public static void main(String[] args) {
        MathCalculable mc = new MathFunc();
        MathFunc mf = new MathFunc();

        System.out.println("7^3 = " + mc.power(2, 5));
        System.out.println("|7 + 2i| = " + mc.absComplex(3, 4));
        System.out.println("Длина окружности R=8: " + mf.circleLength(10));
    }
}

