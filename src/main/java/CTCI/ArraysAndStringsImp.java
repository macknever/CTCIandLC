package CTCI;

import java.util.HashMap;
import java.util.Map;

public class ArraysAndStringsImp implements ArraysAndStrings{


    /**
     * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
     * cannot use additional data structures?
     * @param str
     * @return
     */
    @Override
    public boolean isUnique(String str) {
        boolean [] checker = new boolean[128];
        for(char ch : str.toCharArray()) {
            int index = ch;
            if(checker[index]) return false;
            else checker[index] = true;
        }
        return true;
    }

    /**
     * Given two strings, write a method to decide if one is a permutation of the
     * other.
     * @param str1
     * @param str2
     * @return
     */
    @Override
    public boolean permutationChecker(String str1, String str2) {
        // if lengths of two strings are not equal, 
        if(str1.length() != str2.length()) return false;

        int [] counter = new int[128];
        // count all the char from str1
        for(char ch : str1.toCharArray()) {
            int index = ch;
            counter[index] += 1;
        }

        for (char ch : str2.toCharArray()) {
            int index = ch;
            counter[index] -= 1;
            if (counter[index] == -1) return false;
        }
        return true;
    }

    /**
     * Write a method to replace all spaces in a string with '%20: You may assume that the string
     * has sufficient space at the end to hold the additional characters, and that you are given the "true"
     * length of the string. (Note: If implementing in Java, please use a character array so that you can
     * perform this operation in place.)
     *
     * EXAMPLE
     * Input: "Mr John Smith ", 13
     * Output: "Mr%20John%20Smith"
     * @param toBeUrlify
     * @param len
     * @return
     */
    @Override
    public String urlify(String toBeUrlify, int len) {

        StringBuilder sb = new StringBuilder();
        boolean isSpace = true;
        int counter = 0;
        for(char ch : toBeUrlify.toCharArray()) {
            if( counter == len) break;
            if (ch == ' ' && !isSpace) {
                sb.append("%20");
                isSpace = true;
                counter++;
            } else {
                if (ch == ' ' && isSpace)
                    ;
                else {
                    sb.append(ch);
                    isSpace = false;
                    counter++;
                }
            }
        }
        return sb.toString();
    }

    /**
     * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
     * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
     * is a rea rrangement of letters. The palindrome does not need to be limited to just dictionary words.
     *
     * EXAMPLE
     * Input: Tact Coa
     * Output: True (permutations: "taco cat". "atco cta". etc.)
     * @param str
     * @return
     */
    @Override
    public boolean palindromePermutation(String str) {

        // use a map to count each unique character in the string
        // ignore space and cases
        Map<Character, Integer> charToCount = new HashMap<>();
        for(char ch : str.toCharArray()) {
            if(ch == ' ') continue;
            ch = Character.toLowerCase(ch);
            int currCount = charToCount.getOrDefault(ch,0);
            charToCount.put(ch,currCount+1);
        }
        // check the count of each character, the odd character should not more than 1
        int oddCount = 0;
        for(char ch : charToCount.keySet()){
            ch = Character.toLowerCase(ch);
            int currCount = charToCount.get(ch);
            if (currCount % 2 == 1) {
                oddCount += 1;
                if (oddCount > 1) return false;
            }

        }

        return true;
    }

    /**
     * One Away: There are three types of edits that can be performed on strings: insert a character,
     * remove a character, or replace a character. Given two strings, write a function to check if they are
     * one edit (or zero edits) away.
     * EXAMPLE
     * pale, pIe -> true
     * pales. pale -> true
     * pale. bale -> true
     * pale. bake -> false
     * @param str1
     * @param str2
     * @return
     */
    @Override
    public boolean oneAway(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        //replace len1 == len2
        // check char in str1 and str2 1 by 1, if diff > 1 ,false
        if (len1 == len2) {
            int diff = 0;
            for (int i = 0; i < len1; i++) {
                char ch1 = str1.charAt(i);
                char ch2 = str2.charAt(i);
                if (ch1 != ch2) diff++;
                if (diff > 1) return false;
            }
        }

        //insert and remove is the same len1 and len2 should diff in 1
        // shortLen  and longLen
        // check char 1 by 1. if find a diff, index of long str increase 1.
        // if find another diff. false
        else{
            if(Math.abs(len1 - len2) != 1) return false;

            int shortLen = Math.min(len1, len2);
            int longLen = Math.max(len1,len2);
            boolean found = false;

            String shortStr,longStr;
            if(shortLen == len1) {
                shortStr = str1;
                longStr = str2;
            } else {
                shortStr = str2;
                longStr = str1;
            }
            for(int i = 0,j=0; i < shortLen && j < longLen; i++, j++) {
                char shortChar = shortStr.charAt(i);
                char longChar = longStr.charAt(j);
                if (shortChar != longChar && !found) {
                    i--;
                    found = true;
                    continue;
                }
                if (shortChar != longChar & found) return false;
            }
        }
        return true;
    }

    /**
     * String Compression: Implement a method to perform basic string compression using the counts
     * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
     * "compressed" string would not become smaller than the original string, your method should return
     * @param str
     * @return
     */
    @Override
    public String stringCompressor(String str) {
        // while within the length of str
        // while the next char == current char, counterIndex++.
        // if not counter = counterIndex - index
        // index = counterIndex; counterIndex += 1;
        int len = str.length();
        int index = 0;
        int counterIndex = 0;
        StringBuilder sb = new StringBuilder();

        while (counterIndex < len && index < len) {
            char ch = str.charAt(index);
            sb.append(ch);
            while(str.charAt(counterIndex) == ch){
                counterIndex++;
                if(counterIndex == len) break;
            }
            int count = counterIndex - index;
            sb.append(count);
            index = counterIndex;
        }

        String res = sb.toString();
        if(res.length() >= len){
            res = str;
        }
        return res;
    }

    @Override
    public int[][] matrixRotator(int[][] matrix) {
        int di = matrix.length;

        for(int i = 0; i < di/2; i++) {
            for(int j = i; j < di - 1 - i;j++) {
                int upper = matrix[i][j];
                matrix[i][j] = matrix[j][di-i-1];
                matrix[j][di-i-1] = matrix[di-i-1][di-j-1];
                matrix[di-i-1][di-j-1] = matrix[di-j-1][i];
                matrix[di-j-1][i] = upper;
            }

        }
        return matrix;
    }

}
