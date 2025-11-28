package math;

public class MathFunc implements MathCalculable {

    @Override
    public double power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    @Override
    public double absComplex(double real, double imag) {
        return Math.sqrt(real * real + imag * imag);
    }

    public double circleLength(double radius) {
        return 2 * PI * radius;
    }
}

