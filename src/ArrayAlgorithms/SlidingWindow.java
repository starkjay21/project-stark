package ArrayAlgorithms;

public class SlidingWindow {
    public static void staticWindow(int[] arr, int k)
    {
        //return maximum sum in subarray of length k
        int n = arr.length;
        int currentSum=0, maxSum=Integer.MIN_VALUE;
        if(n<k)
        {
            System.out.println("Invalid input: Subarray length(k) greater than array length");
            return;
        }

        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        maxSum=currentSum;
        for (int i = k; i < n; i++) {
//            currentSum-=arr[i-k];
//            currentSum+=arr[i];
            currentSum +=arr[i]-arr[i-k];
            maxSum=Math.max(currentSum,maxSum);
        }
        /*
        %----Alternative approach for lines 15-24--------%

        for(int i = 0; i < n ; i++)
        {
            currentSum+=arr[i];
            if(i>=k-1)
            {
                maxSum=Math.max(currentSum,maxSum);
                currentSum-=arr[i-k+1];
            }
        }
        * */

        System.out.println("Maximum Sub-array Sum: "+maxSum);
    }
    public static void dynamicWindow(int[] arr, int key)
    {
        int windowStart=0;
        int currSum=0,minLen=Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currSum += arr[windowEnd];

            while(currSum >= key && windowStart <= windowEnd)
            {
                minLen = Math.min(minLen, windowEnd - windowStart + 1);
                currSum -= arr[windowStart];
                windowStart++;
            }
        }

        System.out.println("Minimum subarray having sum "+key+" is: "+minLen);

    }

    
    public static void main(String[] args) {
        int[] arr = {7,4,-1,3,0,5,1};
        int key=8;
        dynamicWindow(arr, key);
    }
}
