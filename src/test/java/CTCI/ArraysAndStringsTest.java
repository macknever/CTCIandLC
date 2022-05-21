package CTCI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.junit.jupiter.api.Assertions.*;

public class ArraysAndStringsTest extends TestBase{

    private static final Logger LOG = LoggerFactory.getLogger(ArraysAndStringsTest.class);

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

    @Test
    void oneAwayTest() {
        assertTrue(as.oneAway("pale","ple"));
        assertTrue(as.oneAway("pales","pale"));
        assertTrue(as.oneAway("pale","bale"));
        assertFalse(as.oneAway("pale","bake"));
    }

    @Test
    void stringCompressorTest() {
        final String str = "a";
        final String expectedStr = "a";
        assertEquals(expectedStr,as.stringCompressor(str));
    }

    @Test
    void matrixRotatorTest() {
       final int [][] matrix = new int[][]{{1,2,3,4},{4,5,6,7},{7,8,9,10},{4,5,7,9}};
       final int [][] expectedRotatedMatrix = new int[][]{{4,7,10,9},{3,6,9,7},{2,5,8,5},{1,4,7,4}};
       as.matrixRotator(matrix);
       assertEqualMatrix(expectedRotatedMatrix,matrix);
    }

    @Test
    void zeroMatrixTest() {
        final int [][] matrix = new int[][]{{1,2,3,0},{4,5,6,7},{7,8,9,10},{4,5,7,9}};
        final int [][] expectedRotatedMatrix = new int[][]{{0,0,0,0},{4,5,6,0},{7,8,9,0},{4,5,7,0}};
        as.zeroMatrix(matrix);
        assertEqualMatrix(expectedRotatedMatrix,matrix);
    }

    @Test
    void rotationCheckerTest() {
        final String origin = "waterbottle";
        final String toBeCheckedStr1 = "erbottlewat";
        final String toBeCheckedStr2 =  "erbotlewate";
        assertTrue(as.rotationChecker(origin,toBeCheckedStr1));
        assertFalse(as.rotationChecker(origin,toBeCheckedStr2));
    }
}
