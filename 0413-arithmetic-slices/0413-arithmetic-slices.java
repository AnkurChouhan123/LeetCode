class Solution {
    public int numberOfArithmeticSlices(int[] nums) {

        if(nums.length<3) return 0;

        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int diff = nums[i+1] - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[j - 1] != diff)
                    break;
                if (j - i + 1 >= 3)
                    ans++;
            }
        }

        return ans;

    }
}