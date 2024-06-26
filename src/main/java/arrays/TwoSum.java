package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && j != i) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // target에서 첫 번째 수를 뺀 결과를 키로 조회하고 현재 인덱스가 아닌 경우 정답으로 리턴
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return null;
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        // 하나의 for 반복으로 통합
        for (int i = 0; i < nums.length; i++) {
            //target에서 num을 뺀 값이 있으면 정답으로 리턴
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum4(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left != right) {
            // 합이 target보다 작으면 왼쪽 포인터를 오른쪽으로 이동
            if (nums[left] + nums[right] < target) {
                left += 1;
                System.out.println(left);
                // 합이 target보다 크면 오른쪽 포인터를 왼쪽으로 이동
            } else if (nums[left] + nums[right] > target) {
                right -= 1;
            } else {
                return new int[]{left, right};
            }
        }
        // 항상 정답이 존재하므로 널이 리턴되는 경우는 없음
        return null;
    }

    public int[] twoSum5(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        Arrays.sort(nums);

        while (left != right) {
            // 합이 target보다 작으면 왼쪽 포인터를 오른쪽으로 이동
            if (nums[left] + nums[right] < target) {
                left += 1;
                System.out.println(left);
                // 합이 target보다 크면 오른쪽 포인터를 왼쪽으로 이동
            } else if (nums[left] + nums[right] > target) {
                right -= 1;
            } else {
                System.out.println(nums[left] + " , " + nums[right]);
                return null;
            }
        }
        // 항상 정답이 존재하므로 널이 리턴되는 경우는 없음
        return null;
    }



    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{1, -2, -3, -4, -5};

        int target = -8;
        System.out.println(Arrays.toString(twoSum.twoSum5(nums, target)));
    }
}
