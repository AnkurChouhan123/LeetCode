class Solution {
    public int countBinarySubstrings(String s) {

        if(s.length() <= 1) return 0;
        int old = 0;
        int curr = 0;
        char currChar = '0';
        int ans = 0;
        if(s.charAt(0) == '1') currChar = '1';

        int i = 0;

        while(i<s.length()){
            if(s.charAt(i) == currChar) curr++;
            else{
                 ans+=Math.min(old,curr);
                old = curr;
                curr=1;
                currChar = s.charAt(i);
            }
            i++;
        }

    
            ans += Math.min(old,curr);
        

        return ans;



    }
}