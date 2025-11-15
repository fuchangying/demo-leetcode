package com.example.hot;

public class Demo34 {
    public static void main(String[] args) {
        Demo34 demo34 = new Demo34();
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] ints = demo34.searchRange(nums, 8);
        System.out.println(ints[0] + "=" + ints[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearchLeft(nums, target);
        int rightIndex = binarySearchRight(nums, target) - 1;
        if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
            return new int[]{leftIndex, rightIndex};
        }

        return new int[]{-1, -1};

    }

    public int binarySearchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                ans = left;
            }
        }
        return ans;
    }

    public int binarySearchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
