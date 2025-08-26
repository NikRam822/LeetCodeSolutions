import dt.tasks.*;
import utils.ListNode;
import utils.Point;
import utils.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*TwoSum twoSum =new TwoSum();*/
        /*System.out.println(Arrays.toString(twoSum.twoSum(new int[] {-1,-2,-3,-4,-5},-8)));*/

        /*Spiral Spiral = new Spiral();
        Spiral.spiralView();*/

       /* AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(new utils.ListNode(2, new utils.ListNode(4, new utils.ListNode(3))), new utils.ListNode(5, new utils.ListNode(6, new utils.ListNode(4))));
*/
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

        /*FourSum fourSum = new FourSum();
        fourSum.fourSum(new int[]{-1000000000,-1000000000,1000000000,-1000000000,-1000000000},
                294967296);*/

        /*RemoveElement remove = new RemoveElement();
        remove.removeElement(new int[]{3,2,2,3}, 3);*/

       /* RemoveNthNodeFromEndOfList remover = new RemoveNthNodeFromEndOfList();
        //remover.removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        remover.removeNthFromEnd(new ListNode(1),1);*/

        /*ValidParentheses validParentheses = new ValidParentheses();
        validParentheses.isValid("(){}][");*/

//        MergeTwoSortedLists m = new MergeTwoSortedLists();
//        //m.mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(1, new ListNode(3, new ListNode(4))));
//        m.mergeTwoLists(new ListNode(), new ListNode());

       /* GenerateParentheses gen = new GenerateParentheses();
        gen.generateParenthesis(4);*/

//        MergekSortedLists m = new MergekSortedLists();
//        m.mergeKLists(new ListNode[]{new ListNode(1, new ListNode(4, new ListNode(5))), new ListNode(1, new ListNode(3, new ListNode(4))), new ListNode(2, new ListNode(6))});
//
       /* SwapNodesInPairs swap = new SwapNodesInPairs();
        swap.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3))));*/

//        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
//       removeDuplicatesFromSortedArray.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4});
//        removeDuplicatesFromSortedArray.removeDuplicates(new int[] {1,1,2});

      /*  FindTheIndexOfTheFirstOccurrenceInAString f = new FindTheIndexOfTheFirstOccurrenceInAString();

        f.strStr("sadbutsad", "ut");*/

    /* ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        containsDuplicate.hasDuplicate(new int[]{1,2,3,4,4});*/

       /* ValidAnagram validAnagram = new ValidAnagram();
        validAnagram.isAnagram("st","ts");*/

        /*TwoSun twoSun = new TwoSun();
        twoSun.twoSum(new int[]{1,2,3,4}, 3);*/

       /* GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});*/

       /* TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        topKFrequentElements.topKFrequent(new int[]{1,1,1,2,2,3,3,3}, 2);*/

      /*  BinarySearch binarySearch = new BinarySearch();
        binarySearch.search(new int[]{-1, 0, 2, 4, 6, 8}, 4);*/

        /*ValidPalindrome validPalindrome = new ValidPalindrome();
        validPalindrome.isPalindrome("car");*/

       /* MinimumStack.MinStack minStack = new MinimumStack.MinStack();
        minStack.getMin();*/

/*        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        evaluateReversePolishNotation.evalRPN(new String[]{"1", "2", "+", "3", "*", "4", "/"});*/

/*        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        dailyTemperatures.dailyTemperatures(new int[]{30, 38, 30, 36, 35, 40, 28});
        dailyTemperatures.dailyTemperatures(new int[]{77, 41, 77, 41, 41, 41, 77, 77, 41, 41});*/

        /*BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        bestTimeToBuyAndSellStock.maxProfit(new int[]{10,1,5,6,7,1});*/

        /*InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        invertBinaryTree.invertTree(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7))));
*/
    /*    Compressor compressor = new Compressor();
        System.out.println(compressor.toCompress("AAACCABBBBDDDDDC"));*/

/*        SmileFixer smileFixer = new SmileFixer();
        smileFixer.smileFixer("Круто :-)) А я недавно завалил туда собес :-((()(");
        smileFixer.smileFixer(": - ))");*/

        /*Symmetry symmetry = new Symmetry();
        System.out.println(symmetry.checkPoint(new Point[] {new Point(0, 0), new Point(0, 0), new Point(1, 1), new Point(3, 1), new Point(4, 0), new Point(4, 0)}));
*/

//        SearchIndex searchIndex = new SearchIndex();
//        System.out.println(searchIndex.searchIndex("Я шёл по улице, капал дождь, было пасмурно, но моё настроение было на высоте, ведь я решил эту алгоритмическую задачу!", "жоддь"));
//        System.out.println(searchIndex.searchIndex("Я шёл по улице, капал дождь, было пасмурно, но моё настроение было на высоте, ведь я решил эту алгоритмическую задачу!", ", пасмурнобыло , но моё настроение"));
//        System.out.println(searchIndex.searchIndex("abab","bab")); TODO: Этот кейс не проходит, переделать

/*
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        maximumDepthOfBinaryTree.maxDepth(new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, new TreeNode(4), null)));
        maximumDepthOfBinaryTree.maxDepth(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7))));
        maximumDepthOfBinaryTree.maxDepth(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5))));

*/

 /*       DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        // [1,null,2,3,4,5]
        diameterOfBinaryTree.diameterOfBinaryTree(new TreeNode(1, null, new TreeNode(2, new TreeNode(3, new TreeNode(5), null), new TreeNode(4))));
 */

       /* ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.reverseList(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3)))));*/

       /* NeighborsSearch neighborsSearch = new NeighborsSearch();
        neighborsSearch.neighborsSearch(new int[]{1, 2, 5, 6, 100},3,3);
        neighborsSearch.neighborsSearch(new int[]{1, 2, 4, 5, 6}, 2, 0);   // []

        neighborsSearch.neighborsSearch(new int[]{1, 3, 3, 5, 7, 9}, 2, 4); // [3, 3, 5, 1]
        neighborsSearch.neighborsSearch(new int[]{10, 20, 30, 40, 50}, 0, 2); // [10, 20]
        neighborsSearch.neighborsSearch(new int[]{5, 6, 7, 8, 9}, 4, 3);    // [8, 9, 7]
        neighborsSearch.neighborsSearch(new int[]{1, 2, 3, 4, 5}, 2, 5);    // [3, 2, 4, 1, 5]
        neighborsSearch.neighborsSearch(new int[]{2, 4, 6, 8, 10}, 1, 1);   // [4]
        neighborsSearch.neighborsSearch(new int[]{1, 1, 1, 1, 1}, 0, 3);    // [1, 1, 1]
        neighborsSearch.neighborsSearch(new int[]{1}, 0, 1);                // [1]*/

        /*SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.summaryRanges(new int[]{0,1,2,4,5,7});
        summaryRanges.summaryRanges(new int[]{0,2,3,4,6,8,9});
        summaryRanges.summaryRanges(new int[]{-2147483648,-2147483647,2147483647});
        summaryRanges.summaryRanges(new int[]{0,1,2,4,5,7,9,10,12,14,15,16,27,28});*/


/*        new ZigzagIterator(Arrays.asList(1, 2), Arrays.asList(1, 2)); // 1 1 2 2
        new ZigzagIterator(Arrays.asList(1), Arrays.asList(2, 3, 4)); // 1 2 3 4
        new ZigzagIterator(Arrays.asList(1, 3, 5), Arrays.asList(2, 4)); // 1 2 3 4 5
        new ZigzagIterator(Arrays.asList(), Arrays.asList(1, 2, 3)); // 1 2 3
        new ZigzagIterator(Arrays.asList(10, 20, 30), Arrays.asList()); // 10 20 30
        new ZigzagIterator(Arrays.asList(), Arrays.asList()); // (пустой вывод)
        new ZigzagIterator(Arrays.asList(7), Arrays.asList(8)); // 7 8
        new ZigzagIterator(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6)); // 1 5 2 6 3 4


      var iterator=  new ZigzagIterator(Arrays.asList(1, 2), Arrays.asList(1, 2)); // 1 1 2 2
      var iterator=  new ZigzagIterator(Arrays.asList(1), Arrays.asList(2, 3, 4)); // 1 2 3 4
      var iterator=  new ZigzagIterator(Arrays.asList(1, 3, 5), Arrays.asList(2, 4)); // 1 2 3 4 5
      var iterator=  new ZigzagIterator(Arrays.asList(), Arrays.asList(1, 2, 3)); // 1 2 3
      var iterator=  new ZigzagIterator(Arrays.asList(10, 20, 30), Arrays.asList()); // 10 20 30
      var iterator=  new ZigzagIterator(Arrays.asList(), Arrays.asList()); // (пустой вывод)
      var iterator=  new ZigzagIterator(Arrays.asList(7), Arrays.asList(8)); // 7 8
      var iterator=  new ZigzagIterator(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6)); // 1 5 2 6 3 4

        System.out.print("Результат обхода: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }*/

/*        StringCompression stringCompression = new StringCompression();
        stringCompression.compress(new char[]{'a','a','b','b','c','c','c'});
        stringCompression.compress(new char[]{'a','b','b'});*/

        Search2DMatrix search2DMatrix = new Search2DMatrix();
        search2DMatrix.searchMatrix(new int[][] {{1},{3}},4);





    }
}