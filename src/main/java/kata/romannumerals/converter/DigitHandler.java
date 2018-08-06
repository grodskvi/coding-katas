package kata.romannumerals.converter;

public interface DigitHandler<T extends Digit, R> {
    void handleNextDigit(T digit);
    R getResult();
}
