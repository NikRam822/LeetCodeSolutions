import add_two_numbers.AddTwoNumbers;
import add_two_numbers.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*TwoSum twoSum =new TwoSum();*/
        /*System.out.println(Arrays.toString(twoSum.twoSum(new int[] {-1,-2,-3,-4,-5},-8)));*/

        /*Spiral Spiral = new Spiral();
        Spiral.spiralView();*/

        /*AddTwoNumbers addTwoNumbers = new AddTwoNumbers();*/
        /*addTwoNumbers.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4))));*/

        /*LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        lengthOfLongestSubstring.lengthOfLongestSubstring("aab");*/

       /* PalindromeNumber palindromeNumber = new PalindromeNumber();
        palindromeNumber.isPalindrome(12);*/

        /*RomanToInteger romanToInteger = new RomanToInteger();
        romanToInteger.romanToInt("MCMXCIV");*/

        /*IntegerToRoman integerToRoman = new IntegerToRoman();
        integerToRoman.intToRoman(58);*/

       /* MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4});*/

       /* LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        longestPalindromicSubstring.longestPalindrome("cbbd");*/

       /* ZigzagConversion zigzagConversion = new ZigzagConversion();
        zigzagConversion.convert("PAYPALISHIRING", 3);*/

       /* ReverseInteger reverseInteger = new ReverseInteger();
        reverseInteger.reverse(120);*/

        /*StringToInteger stringToInteger = new StringToInteger();
        stringToInteger.myAtoi("   -04f");*/

      /*  RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        regularExpressionMatching.isMatch("abc","a***abc");*/

        /*ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        containerWithMostWater.maxArea(new int[] {1,8,6,2,5,4,8,3,7});*/

        /*LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flower","flower","flower"});*/

        /*ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(new int[]{1,2,-2,-1});*/

        /*ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        threeSumClosest.threeSumClosest(new int[]{0,1,2},0);*/

        /*LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        letterCombinationsOfAPhoneNumber.letterCombinations("2346");*/

        FourSum fourSum = new FourSum();
        long start = System.currentTimeMillis();
        fourSum.fourSum(new int[]{-1000000000,-1000000000,1000000000,-1000000000,-1000000000},
                294967296);
        long duration = System.currentTimeMillis() - start;
        System.out.println( duration );
        /*RemoveElement remove = new RemoveElement();
        remove.removeElement(new int[]{3,2,2,3}, 3);*/
    }
}