import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumTriplet{

    public static void findThreeSum(int[] nums) {
        Arrays.sort(nums);  
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                   
                    System.out.println(nums[i] + " " + nums[left] + " " + nums[right]);
                  
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  
                } else {
                    right--;  
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Unique triplets that sum to zero:");
        findThreeSum(nums);

        sc.close();
    }
}
