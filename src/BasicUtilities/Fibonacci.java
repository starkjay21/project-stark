package BasicUtilities;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        long startTime = System.currentTimeMillis();
        System.out.println(n + "th fibonacci number is: "+ fibb(n));
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken: "+ (endTime-startTime)+"ms");
    }

    private static int fibb(int n) {
        double x = Math.sqrt(5);
//        double ans = (1/x)*(Math.pow((1+x)/2, n)-Math.pow((1-x)/2, n));
        double ans = (1/x)*(Math.pow((1+x)/2, n));
        return (int)Math.round(ans);
    }
}
