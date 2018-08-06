package kata.romannumerals.converter;


import static java.lang.String.format;

public class RomanNumberConverter implements NumberConverter {

    public int toNumeric(String number) {
        //init calculaor
        //init validators
        //for each digit
        //   validate current digit
        //   each validator
        //       validate current digit
        // get result

        int arabicValue = 0;
        int repeats = 0;
        int lastDigit = Integer.MIN_VALUE;
        for (int i = 0; i < number.length(); i++) {
            RomanDigit romanDigit = RomanDigit.valueOf(number.charAt(i));
            int currentArabicDigit = romanDigit.getNumericValue();

            repeats = lastDigit == currentArabicDigit ? repeats + 1 : 1;
            if (repeats > romanDigit.getAllowedRepeats()) {
                String errorMessage =
                        format("%s can not be repeated more then %d times", romanDigit.name(), romanDigit.getAllowedRepeats());
                throw new IllegalArgumentException(errorMessage);
            }

            arabicValue += currentArabicDigit;

            if (lastDigit < currentArabicDigit) {
                arabicValue = arabicValue - 2 * lastDigit;
            }

            lastDigit = currentArabicDigit;
        }
        
        return arabicValue;
    }

}
