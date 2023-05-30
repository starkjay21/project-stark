package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        while (i != arr.length)
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
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length)
        {
            if (i == nums[i]-1)
                i++;
            else
            {

                int j = nums[i]-1;
                if(nums[i] == nums[j]){
                    i++;
                    continue;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        for (i = 0 ; i < nums.length ; i++)
        {
            if(i+1 != nums[i])
                list.add(i+1);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,4,2,5,6,8};
        System.out.println(findDisappearedNumbers(arr));
//        int gap = Integer.MAX_VALUE; //gap is the smallest element in the array
//        for (int i: arr) {
//            gap = Math.min(gap, i);
//        }
//        System.out.println("Unsorted Array is: "+Arrays.toString(arr));
//        System.out.println("Sorted Array is: "+ Arrays.toString(cyclicSort(arr,gap)));
    }
}
