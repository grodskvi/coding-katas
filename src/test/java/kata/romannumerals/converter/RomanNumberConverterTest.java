package kata.romannumerals.converter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RomanNumberConverterTest {

    private RomanNumberConverter romanNumberConverter = new RomanNumberConverter();

    @Test
    public void convertsSingleDigitNumberI() {
        assertEquals(1, romanNumberConverter.toNumeric("I"));
    }
    @Test
    public void convertsSingleDigitNumberV() {
        assertEquals(5, romanNumberConverter.toNumeric("V"));
    }
    @Test
    public void convertsMultipleDigstAccordingToAdditiveRuleII() {
        assertEquals(2, romanNumberConverter.toNumeric("II"));
    }
    @Test
    public void convertsMultipleDigstAccordingToAdditiveRuleVI() {
        assertEquals(6, romanNumberConverter.toNumeric("VI"));
    }

    @Test
    public void convertsMultipleDigitsNumberAccordingToSubstractiveRule() {
        assertEquals(4, romanNumberConverter.toNumeric("IV"));
    }

    @Test
    public void convertsComplexNumber() {
        assertEquals(1447, romanNumberConverter.toNumeric("MCDXLVII"));
    }

    @Test
    public void NotValidNumber() {
        assertFailsToConvert("VO", "O is not a Roman digit");
    }

    @Test
    public void failsOnNumberWithMoreThenThreeISymbols() {
        assertFailsToConvert("XIIII", "I can not be repeated more then 3 times");
    }

    @Test
    public void failsOnNumberWithMoreThenOneVSymbols() {
        assertFailsToConvert("CMVV", "V can not be repeated more then 1 times");
    }

    private void assertFailsToConvert(String romanNumber, String errorMessage) {
        try {
            romanNumberConverter.toNumeric(romanNumber);
            fail();
        } catch (Exception e) {
            assertEquals(e.getClass(), IllegalArgumentException.class);
            assertEquals(errorMessage, e.getMessage());
        }
    }

}