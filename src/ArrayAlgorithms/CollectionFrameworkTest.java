package ArrayAlgorithms;

import java.util.Arrays;

public class CollectionFrameworkTest {
    public static void main(String[] args) {
        //call the method based on your test
        segregateElements(new int[]{1 ,-1, 3 ,2 ,-7,-5 ,11, 6}, 8);
    }
//    public static void segregateElements(int arr[], int n)
//    {
//        // Your code goes here
//        int ptr1 = 0, ptr2 = n-1;
//
//        while(ptr1 < ptr2)
//        {
//            while(arr[ptr1] >= 0)
//                ptr1++;
//            while(arr[ptr2] < 0)
//                ptr2--;
//
//            if(ptr1 >= ptr2)
//                break;
//
//            //swap ptr1 and ptr2
//            int temp = arr[ptr1];
//            arr[ptr1] = arr[ptr2];
//            arr[ptr2] = temp;
//            ptr1++;
//            ptr2--;
//        }
//        System.out.println(Arrays.toString(arr));
//    }
public static void segregateElements(int arr[], int n) {
    // Your code goes here
    int k = 0;//k = number of negative integers in array

    for (int x : arr)
        if (x < 0)
            k++;
    int count_negative = k;
    for (int i = 0; i < n - count_negative; i++) {
        if (arr[i] < 0) {
            int j = i;
            while (j != n - k) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j++;
            }
            k--;
        }
    }
    System.out.println(Arrays.toString(arr));
}
    public static void SetsTest(){

    }
}
