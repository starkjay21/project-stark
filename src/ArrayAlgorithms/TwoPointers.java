import java.util.Arrays;

public class TwoPointers {

    public static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int index1 = 0, index2 = nums.length-1;
        while(index1 < index2)
        {
            int sum = nums[index1]+nums[index2];

            if(sum < target)
                index1++;
            else if(sum > target)
                index2--;
            else
                return new int[]{index1, index2};
        }

        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
