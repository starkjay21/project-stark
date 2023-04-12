package SortingAlgorithms;

import java.util.Arrays;

/* Cyclic Sort Algorithm
*  Cyclic Sort Algorithm can be used to sort elements in O(N) time.
* However, it can be used only when the elements are consecutive, here, from 1-N
* and no numbers are repeated
* */
public class CyclicSort {

    public static int[] cyclicSort(int[] arr, int gap)
    {
        //TODO: at first position check if the element is at right position or not
        //IF its at the right position, go for next element
        //ELSE swap it with the right position
        int i = 0;
        while (i != arr.length-1)
        {
            if (i == arr[i]-gap)
                i++;
            else
            {
                int temp = arr[i];
                arr[i] = arr[arr[i]-gap];
                arr[temp-gap] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,5,3};
        int gap = Integer.MAX_VALUE; //gap is the smallest element in the array
        for (int i: arr) {
            gap = Math.min(gap, i);
        }
        System.out.println("Unsorted Array is: "+Arrays.toString(arr));
        System.out.println("Sorted Array is: "+ Arrays.toString(cyclicSort(arr,gap)));
    }
}
