package arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int num = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = num;
            num *= nums[i];
        }

        num = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= num;
            num *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(nums)));
    }
}
