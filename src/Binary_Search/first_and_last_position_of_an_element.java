package Binary_Search;

import java.util.Arrays;

public class first_and_last_position_of_an_element {
    public static void main(String[] args) {
        int[] arr={1,2,3,3,3,3,4,5,9};
        //index :- 0 1 2 3 4 5 6 7 8 9 10
        //int[] arr={};
        int t=3;//target element
        int[] ans = tar_position(arr, t);
        System.out.println(Arrays.toString(ans));
    }
    static int[] tar_position(int[] nums, int target){
        int s=0, e= nums.length-1;
        while(s <= e) {
            int mid = s +(e-s)/2;
            if(nums[mid]==target) {
                int ans1 = binLeft(nums, 0, mid, target);
                int ans2 = binRight(nums, mid, nums.length - 1, target);
                return new int[] {ans1, ans2} ;
            }
            else if(nums[mid] < target)
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
            }

            else {
                if (mid != 0) {

                    if (arr[mid - 1] == t) {
                        return binLeft(arr, 0, mid-1, t);
                    }

                    else
                        return mid;
                }
                else
                    return mid;

            }
        }
        return -1;
    }
}
