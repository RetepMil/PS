class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0; int prevNum = -100001; int freq = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != prevNum) {
                nums[k++] = nums[i];
                prevNum = nums[i];
                freq = 1;
            }
            else if (freq < 2) {
                nums[k++] = nums[i];
                freq++;
            }
        }
        return k;
    }
}
