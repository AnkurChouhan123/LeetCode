class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums,k) - solve(nums,k-1);
    }

    int solve(int[] nums,int k){

        int i = 0;
        int j = 0;
        int cnt = 0;
        int ans = 0;

        while(j<nums.length){
          if((nums[j] & 1) == 1) cnt++;

          while(cnt > k){
            if((nums[i] & 1) == 1) cnt--;
            i++;
          }

          j++;
          ans += j-i+1;
        }

        return ans;
    }
}