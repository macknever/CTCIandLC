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

}
