package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayPartition {

    // 속도 14ms
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += Math.min(nums[i], nums[i + 1]);

        }
        return sum;

    }

    // 속도 22ms
    public int arrayPairSum2(int[] nums) {
        int sum = 0;
        List<Integer> pair = new ArrayList<>();

        Arrays.sort(nums);

        for (int n : nums) {
            pair.add(n);

            // 페어 변수에 값이 2개 채워지면 min()을 합산하고 변수 초기화
            if (pair.size() == 2) {
                sum += Collections.min(pair);
                pair.clear();
            }
        }

        return sum;
    }

    // 속도 13ms
    public int arrayPairSum3(int[] nums) {
        int sum = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            // 짝수 번째일 때 값의 합 계산
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6, 2, 6, 5, 1, 2};
        ArrayPartition arrayPartition = new ArrayPartition();
        System.out.println(arrayPartition.arrayPairSum3(nums));
    }
}
