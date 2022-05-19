package CTCI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArraysAndStringsTest {

    private ArraysAndStringsImp as;

    @BeforeEach
    void init() {
        as = new ArraysAndStringsImp();
    }

    @Test
    void isUniqueTest() {
        final String uniqueStr = "abc123fde";
        final String duplicatedStr = "abb123cde";
        assertFalse(as.isUnique(duplicatedStr));
        assertTrue(as.isUnique(uniqueStr));
    }

    @Test
    void permutationCheckerTest() {
        final String str1 = "abc";
        final String str2 = "cba";
        final String str3 = "acce";
        assertTrue(as.permutationChecker(str1,str2));
        assertFalse(as.permutationChecker(str1,str3));
    }

    @Test
    void URLifyTest() {
        final String str = "Mr  John Smith       a";
        final int len = 13;
        final String expectedResult = "Mr%20John%20Smith";

        final String actualResult = as.urlify(str,len);
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void palindromePermutationTest() {
        final String palindromeStr = "Tact Coa";
        final String nonPalindromeStr = "ab";
        assertTrue(as.palindromePermutation(palindromeStr));
        assertFalse(as.palindromePermutation(nonPalindromeStr));
    }
}
