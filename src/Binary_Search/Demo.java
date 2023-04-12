package Binary_Search;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int[] arr={1,2,2,3,7,7,7,8,9,9,9};
        //index :- 0 1 2 3 4 5 6 7 8 9 10
        //int[] arr={};
        int t=9;//target element
        int[] ans = tar_position(arr, t);
        System.out.println(Arrays.toString(ans));
    }
    static int[] tar_position(int[] arr, int t){
        int s=0, e= arr.length-1;
        while(s <= e) {
            int mid = s +(e-s)/2;
            if(arr[mid]==t) {
                int ans1 = binLeft(arr, 0, mid, t);
                int ans2 = binRight(arr, mid, arr.length - 1, t);
                return new int[] {ans1, ans2} ;
            }
            else if(arr[mid] < t)
                s=mid+1;
            else
                e=mid-1;
        }
        return new int[] {-1,-1};
    }

    static int binRight(int[] arr, int s, int e, int t) {
        while(s <= e) {
            int mid = s + (e - s) / 2;

            if (arr[mid] < t)
                s = mid + 1;
            else if (arr[mid] > t) {
                e = mid - 1;
            } else {
                if (mid != arr.length-1) {
                    if (arr[mid + 1] == t) {
                        return binRight(arr, mid+1, arr.length-1, t);
                    }
                    else
                        return mid;
                } else
                    return mid;

            }
        }
        return -1;
    }

    static int binLeft(int[] arr, int s, int e, int t){
        while(s <= e) {
            int mid = s + (e - s) / 2;


            if (arr[mid] < t)
                s = mid + 1;
            else if (arr[mid] > t) {
                e = mid - 1;
            } else {
                if (mid != 0) {
                    if (arr[mid - 1] == t) {
                        return binLeft(arr, 0, mid-1, t);
                    }
                    else
                        return mid;
                } else
                    return mid;

            }
        }
        return -1;
    }
}
