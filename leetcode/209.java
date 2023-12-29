class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int answer = 100001;
        int sum = nums[0]; 
        int left = 0; int right = 0;
        while (true) {
            if (sum >= target)
                answer = Math.min(answer, right - left);
            if (sum < target) {
                if (right == nums.length - 1) break;
                sum += (nums[++right]);
            } else {
                sum -= (nums[left++]);
            }
        }
        return answer == 100001 ? 0 : answer + 1;
    }
}
