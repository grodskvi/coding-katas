package kata.romannumerals.converter;

public class RomanNumberCalculationHandler implements DigitHandler<RomanDigit, Integer> {

    private int arabicValue;
    private int lastDigit = Integer.MIN_VALUE;

    @Override
    public void handleNextDigit(RomanDigit digit) {
        int currentArabicDigit = digit.getNumericValue();

        arabicValue += currentArabicDigit;

        if (lastDigit < currentArabicDigit) {
            arabicValue = arabicValue - 2 * lastDigit;
        }

        lastDigit = currentArabicDigit;
    }

    @Override
    public Integer getResult() {
        return arabicValue;
    }
}
