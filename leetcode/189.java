class Solution {
    private int[] arr;

    public void rotate(int[] nums, int k) {
        arr = nums;
        int arrLen = nums.length;
        k = k % arrLen;
        reverse(0, arrLen - k - 1);
        reverse(arrLen - k, arrLen - 1);
        reverse(0, arrLen - 1);
    }

    private void reverse(int i, int j) {
        int temp;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
