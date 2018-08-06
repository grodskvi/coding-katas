package kata.romannumerals.converter;

public enum RomanDigit implements Digit {
    I(1, 3),
    V(5, 1),
    X(10, 3),
    L(50, 1),
    C(100, 3),
    D(500, 1),
    M(1000, 3);

    private final int numericValue;
    private final int allowedRepeats;

    private RomanDigit(int numericValue, int allowedRepeats) {
        this.numericValue = numericValue;
        this.allowedRepeats = allowedRepeats;
    }

    @Override
    public int getNumericValue() {
        return numericValue;
    }

    public static RomanDigit valueOf(char digit) {
        try {
            return valueOf(String.valueOf(digit));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(digit + " is not a Roman digit");
        }
    }

    public int getAllowedRepeats() {
        return allowedRepeats;
    }
}
