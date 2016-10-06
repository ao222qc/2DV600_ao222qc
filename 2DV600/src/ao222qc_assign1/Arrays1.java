package ao222qc_assign1;

/**
 * Created by Adam on 2016-08-30.
 */
import java.util.Arrays;
public class Arrays1 {

    public static void main(String args[]) throws Exception
    {

    }

    public static int sum(int[] arr)
    {
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
        }
        return sum;
    }

    public static String toString(int[] arr)
    {
        String arrContent = "";

        for (int x : arr)
        {
            arrContent += " " + x;
        }
        return arrContent;
    }

    public static int[] addN(int[] arr, int n)
    {
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] += n;
        }
        //Add n to all elements of array
        return arr;
    }

    public static int[] reverse(int[] arr)
    {
        int arrEndPoint = arr.length -1;
        int[] reversedArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
        {
            reversedArr[i] = arr[arrEndPoint - i];
        }
        //reverse arr
        return reversedArr;
    }

    public static void replaceAll(int[] arr, int old, int nw)
    {
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == old)
            {
                arr[i] = nw;
            }
        }
        //replace all old in arr with nw
    }

    public static int[] sort(int[] arr)
    {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        return sortedArr;
    }

    public static boolean hasSubsequence(int[] arr, int[] sub) throws Exception
    {
        try
        {
            if (sub.length > arr.length)
            {
                throw new Exception();
            }
            int subLength = sub.length;     //Length of sub array to "splice" sections of larger array.
            int[] tempArr = new int[subLength];

            int[] fastArr = new int[subLength];

            for (int i = subLength; i <= arr.length; i++) { //Start at subLength, example size 4 of sub array.
                for (int k = subLength; k > 0; k--) {       //Loop backwards over larger array from that position
                    tempArr[subLength - k] = arr[i - k];    //Add values from the larger array to a temp arr
                }
                if (Arrays.equals(tempArr, sub)) {
                    return true;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error. Sub array is larger than main array.");
        }
        return false;
    }

    public static int[] absDif(int[] arr1, int[] arr2) throws Exception
    {
        int[] diffArr = new int[arr1.length];
        try
        {
            if(arr1.length != arr2.length)
                throw new Exception("The arrays are of different size and no result will be yielded.");

            for(int i = 0; i < arr1.length; i++)
            {
                diffArr[i] = Math.abs(arr1[i] - arr2[i]);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return diffArr;
    }
}

/*private static void quicksort(int[] arr, int low, int high)
    {
        if(arr == null || arr.length == 0)
        {
            return;
        }

        if(low>= high)
        {
            return;
        }

        int mid = low + (high - low) / 2;
        int pivot = arr[mid];

        int i = low, j = high;

        while(j <= j)
        {
            while(arr[i] < pivot)
            {
                i++;
            }
            while(arr[j] > pivot)
            {
                j--;
            }

            if(i <= j)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if(low < j)
        {
            quicksort(arr, low, j);
        }
        if(high > i)
        {
            quicksort(arr, i, high);
        }

    }*/
