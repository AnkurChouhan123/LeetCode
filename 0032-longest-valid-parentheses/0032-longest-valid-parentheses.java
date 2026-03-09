class Solution {
    public int longestValidParentheses(String s) {
        
        int n = s.length();
        if(n<=1) return 0;

        int[] dp = new int[n];
        dp[0] = 0;
        int max = 0;

        Stack<Integer> st = new Stack<>();

        if(s.charAt(0) == '(') st.push(0);

        for(int i = 1; i < n; i++){
            char ch = s.charAt(i);

            if(ch == ')' && !st.isEmpty()){
               
                    dp[i] = i - st.peek() + 1;

                    if(st.peek()-1 >= 0){
                      dp[i] += dp[st.peek()-1];
                    }
                    max = Math.max(max,dp[i]);
                    st.pop();
                
            }
            else{
                // dp[i] = dp[i-1];
                if(ch == '(') st.push(i);
            }

        }
        // return Arrays.stream(dp).max().getAsInt();
        // int max = 0;
        // for(int num : dp){
        //     max = Math.max(max,num);
        // }

        return max;
    }

    // class Pair{
    //     char ch;
    //     int idx;

    //     Pair(char ch,int idx){
    //         this.ch = ch;
    //         this.idx = idx;
    //     }
    // }
}