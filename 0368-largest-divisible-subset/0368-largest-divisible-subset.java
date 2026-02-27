class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        int[] hash = new int[n];

        for (int i = 0; i < n; i++) {
            hash[i] = i;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0){
                   if(dp[j]+1 > dp[i]){
                     dp[i] = dp[j] + 1;
                     hash[i] = j;
                   }
                }
            }
        }


        int max = 0;

        for(int i = 1;i<n;i++){
            if(dp[max] < dp[i]){
                max = i;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        while(max != hash[max]){
            list.add(nums[max]);
            max = hash[max];
        }

        list.add(nums[max]);

        return list;
    }
}