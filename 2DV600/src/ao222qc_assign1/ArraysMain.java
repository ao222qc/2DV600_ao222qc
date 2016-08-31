package ao222qc_assign1;

import ao222qc_assign1.Arrays1;

/**
 * Created by Adam on 2016-08-30.
 */
public class ArraysMain {
    public static void main(String args[]) throws Exception
    {
        int[] testArr = {5, 2, 4, 1, 3};
        int[] subArr1 = {9, 77, 8};
        int[] subArr2 = {1, 2, 3};
        int[] difArr = {1,1,1,1,1};
        System.out.println("Testing sum method...");
        System.out.println(Arrays1.sum(testArr));
        System.out.println();
        System.out.println("Testing toString method...");
        System.out.println(Arrays1.toString(testArr));
        System.out.println();
        System.out.println("Testing addN method, adding 5...");
        System.out.println(Arrays1.toString(Arrays1.addN(testArr, 5)));
        System.out.println();
        System.out.println("Testing reverse method...");
        System.out.println(Arrays1.toString(Arrays1.reverse(testArr)));
        System.out.println();
        System.out.println("Testing replace method... replacing 6 with 77...");
        Arrays1.replaceAll(testArr, 6, 77);
        System.out.println(Arrays1.toString(testArr));
        System.out.println("Testing sort method...");
        System.out.println(Arrays1.toString(Arrays1.sort(testArr)));
        System.out.println();
        System.out.println("Testing has subsequence method...");
        System.out.println("Array: " + Arrays1.toString(testArr));
        System.out.println("Subarray one: "+ Arrays1.toString(subArr1));
        System.out.println("Result: " + Arrays1.hasSubsequence(testArr, subArr1));
        System.out.println("Subarray two: "+ Arrays1.toString(subArr2));
        System.out.println("Result: "+Arrays1.hasSubsequence(testArr, subArr2));
        System.out.println();
        System.out.println("Testing absDif method... sending in {1,1,1,1,1}");
        System.out.println("Original values: " + Arrays1.toString(testArr));
        System.out.println(Arrays1.toString(Arrays1.absDif(testArr, difArr)));




    }
}
